package main.java.school.DB.DTO;

import lombok.Data;

@Data
public class RequestStudentDTO {
    private String stuName;
    private Long deptNo;
    private DeptDTO deptDTO;
}
