package main.java.school.DB.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "SCORE")
public class ScoreEntity {
    @Id
    @Column(name = "score_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "score")
    private Integer score;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stu_no")
    private StudentEntity studentObj;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_no")
    private SubjectEntity subjectObj;

    public ScoreEntity(StudentEntity student, SubjectEntity subject, Integer score) {
        this.score = score;
        this.studentObj = student;
        this.subjectObj = subject;

    }

    public ScoreEntity() {

    }
}