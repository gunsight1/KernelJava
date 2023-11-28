package main.java.school.DB.DTO;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
public class ScoreDTO {
    private Long stuNo;
    private String stuName;
    private Long deptNo;
    private String deptName;
    private Long subjectNo;
    private String subjectName;
    private Long score;
    private Boolean major;
    private String rank;
    private String passable;

    public ScoreDTO(Long stuNo, String stuName, Long deptNo, String deptName,
                    Long subjectNo, String subjectName, Long score, Boolean major, String rank, String passable) {
        this.stuNo = stuNo;
        this.stuName = stuName;
        this.deptNo = deptNo;
        this.deptName = deptName;
        this.subjectNo = subjectNo;
        this.subjectName = subjectName;
        this.score = score;
        this.major = major;
        this.rank = rank;
        this.passable = passable;
    }
}
