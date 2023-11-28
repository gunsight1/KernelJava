package main.java.school.DB.Entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "SUBJECT")
public class SubjectEntity {
    @Id
    @Column(name = "subject_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no")
    private DeptEntity deptObj;

    @Column(name = "major")
    private Boolean major;

    @Column(name = "subject_nm")
    private String subjectNm;

}