package main.java.school.Service;

import main.java.grade.BasicEvaluation;
import main.java.grade.MajorEvaluation;
import main.java.grade.PassFailEvaluation;
import main.java.school.DB.DTO.*;
import main.java.school.DB.Entity.DeptEntity;
import main.java.school.DB.Entity.ScoreEntity;
import main.java.school.DB.Entity.StudentEntity;
import main.java.school.DB.Entity.SubjectEntity;
import main.java.school.DB.Repository.DeptEntityRepository;
import main.java.school.DB.Repository.ScoreEntityRepository;
import main.java.school.DB.Repository.StudentEntityRepository;
import main.java.school.DB.Repository.SubjectEntityRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    @Autowired
    private ScoreEntityRepository scoreRepo;

    @Autowired
    private DeptEntityRepository deptRepo;

    @Autowired
    private StudentEntityRepository studentRepo;

    @Autowired
    private SubjectEntityRepository subjectRepo;

    private MajorEvaluation majorRank;
    private BasicEvaluation normalRank;
    private PassFailEvaluation checkPns;
    private ModelMapper mapper = new ModelMapper();
    public SchoolService(MajorEvaluation majorRank, BasicEvaluation normalRank, PassFailEvaluation checkPns) {
        this.majorRank = majorRank;
        this.normalRank = normalRank;
        this.checkPns = checkPns;
    }
    /** ------------------------------ All ----------------------------------- **/
    public List<ScoreDTO> getScores() {
        List<ScoreEntity> entityList = scoreRepo.findAll();
        List<ScoreDTO> resultList = new ArrayList<>();

        for (ScoreEntity entity : entityList) {

            Boolean major = entity.getSubjectObj().getMajor();
            int score = entity.getScore();
            String rank = major ? majorRank.getGrade(score) : normalRank.getGrade(score);
            String passable = checkPns.getGrade(score);

            ScoreDTO info = ScoreDTO.builder().stuNo(entity.getStudentObj().getId())
                    .stuName(entity.getStudentObj().getStuName())
                    .deptNo(entity.getSubjectObj().getDeptObj().getId().longValue())
                    .deptName(entity.getSubjectObj().getDeptObj().getDeptNm())
                    .subjectNo(entity.getSubjectObj().getId())
                    .subjectName(entity.getSubjectObj().getSubjectNm())
                    .score(entity.getScore().longValue())
                    .major(major)
                    .rank(rank)
                    .passable(passable)
                    .build();

            resultList.add(info);
        }
        return resultList;
    }

    public List<DeptDTO> getDepts() {
        List<DeptEntity> entitys = deptRepo.findAll();
        return entitys.stream().map(DeptEntity -> mapper.map(DeptEntity, DeptDTO.class)).collect(Collectors.toList());
    }

    public List<StudentDTO> getStudents() {
        List<StudentEntity> entitys = studentRepo.findAll();
        return entitys.stream().map(StudentEntity -> mapper.map(StudentEntity, StudentDTO.class)).collect(Collectors.toList());
    }

    /** ------------------------------ option ----------------------------------- **/

    public List<SubjectDTO> getSubjectsByDeptNo(Long deptNo) {
        List<SubjectEntity> entitys = subjectRepo.getSubjectsByDeptNo(deptNo);
        return entitys.stream().map(SubjectEntity -> mapper.map(SubjectEntity, SubjectDTO.class)).collect(Collectors.toList());
    }

    public List<DeptDTO> getDeptsByStudentNo(Long studentNo) {
        List<DeptEntity> entitys = deptRepo.getDeptsByStudentNo(studentNo);
        return entitys.stream().map(DeptEntity -> mapper.map(DeptEntity, DeptDTO.class)).collect(Collectors.toList());
    }

    public DeptDTO getDeptByStudentNo(Long studentNo) {
        DeptEntity entity = studentRepo.getDeptByStudentNo(studentNo);
        return mapper.map(entity, DeptDTO.class);
    }

    public void postStudent(RequestStudentDTO dto) {
        Optional<DeptEntity> deptOptional = deptRepo.findById(dto.getDeptNo());
        if (deptOptional.isPresent()) {
            DeptEntity dept = deptOptional.get();
            StudentEntity entity = new StudentEntity(dept,dto.getStuName());
            studentRepo.save(entity);
        } else {
           throw new RuntimeException("안된다~");
        }

    }

    public void postScore(ScoreDTO dto) {
        Optional<StudentEntity> studentO = studentRepo.findById(dto.getStuNo());
        Optional<SubjectEntity> subjectO = subjectRepo.findById(dto.getSubjectNo());

        if(studentO.isPresent() && subjectO.isPresent()){
            StudentEntity student = studentO.get();
            SubjectEntity subject = subjectO.get();

            ScoreEntity entity = new ScoreEntity(student,subject,Math.toIntExact(dto.getScore()));
            scoreRepo.save(entity);
        }

    }
}
