package main.java.school.DB.Entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Entity
@Table(name = "DEPT")
public class DeptEntity {
    @Id
    @Column(name = "dept_no", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "dept_nm")
    private String deptNm;

}