package main.java.school.DB.DTO;

import lombok.Data;

import java.io.Serializable;

/**
 * DTO for {@link main.java.school.DB.Entity.SubjectEntity}
 */
@Data
public class SubjectDTO implements Serializable {
    private Long id;
    private Boolean major;
    private String subjectNm;
}