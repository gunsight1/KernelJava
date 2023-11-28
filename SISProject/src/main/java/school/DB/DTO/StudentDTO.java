package main.java.school.DB.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link main.java.school.DB.Entity.StudentEntity}
 */
@Data
public class StudentDTO implements Serializable {
    Long id;
    String stuName;
    private DeptDTO deptDTO;
}