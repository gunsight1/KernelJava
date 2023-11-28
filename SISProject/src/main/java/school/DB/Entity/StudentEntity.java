package main.java.school.DB.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "STUDENT")
public class StudentEntity {
    @Id
    @Column(name = "stu_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dept_no")
    private DeptEntity deptObj;

    @Column(name = "stu_name")
    private String stuName;

    public StudentEntity(DeptEntity deptObj, String stuName) {
        this.deptObj = deptObj;
        this.stuName = stuName;
    }

    public StudentEntity() {
        // 기본 생성자
    }

}