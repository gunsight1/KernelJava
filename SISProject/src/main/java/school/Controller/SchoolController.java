package main.java.school.Controller;

import main.java.school.DB.DTO.*;
import main.java.school.Service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@Controller("/")
public class SchoolController {

    @Autowired
    private SchoolService service;
    @RequestMapping
    public String School (ModelMap model){

        List<ScoreDTO> scores = service.getScores();
        List<DeptDTO> depts = service.getDepts();
        List<StudentDTO> students = service.getStudents();

        model.addAttribute("scores",scores);
        model.addAttribute("depts",depts);
        model.addAttribute("students",students);

        return "index";
    }
    @PostMapping("/postStudent")
    @ResponseBody
    public String postStudent(@ModelAttribute RequestStudentDTO dto) {

        String msg;

        try{
            service.postStudent(dto);
            msg = "success";
        }catch (RuntimeException e){
            msg = "faild";
        }

        return msg;
    }
    /** 수강신청이라곤 했지만 결국 score임. **/
    @PostMapping("/postEnrol")
    @ResponseBody
    public String postScore(@ModelAttribute ScoreDTO dto) {
        Random random = new Random();

        String msg;
        Long score = (long) (random.nextInt(100) + 1);
        dto.setScore(score);

        try{
            service.postScore(dto);
            msg = "success";
        }catch (RuntimeException e){
            msg = "faild";
        }

        return msg;
    }

    /** 등록된 학생 정보에 따른 고정 학과 return **/
    @GetMapping("/dept/{studentNo}")
    @ResponseBody
    public ResponseEntity<DeptDTO> getDept(@PathVariable Long studentNo){
        DeptDTO dept = service.getDeptByStudentNo(studentNo);
        return ResponseEntity.ok(dept);
    }

    /** 학과 정보에 따른 과목 목록 조회 **/
    @GetMapping("/subjects/{deptNo}")
    @ResponseBody
    public ResponseEntity<List<SubjectDTO>> getSubjects(@PathVariable Long deptNo){
        List<SubjectDTO> subjects = service.getSubjectsByDeptNo(deptNo);
        return ResponseEntity.ok(subjects);
    }

}
