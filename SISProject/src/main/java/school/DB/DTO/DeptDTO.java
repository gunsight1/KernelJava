package main.java.school.DB.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link main.java.school.DB.Entity.DeptEntity}
 */
@Data
public class DeptDTO implements Serializable {
    private Integer id;
    private String deptNm;
}