package main.java.school.DB.Repository;

import main.java.school.DB.Entity.DeptEntity;
import main.java.school.DB.Entity.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Map;

public interface StudentEntityRepository extends JpaRepository <StudentEntity, Long> {

    @Query("SELECT s.deptObj FROM StudentEntity s WHERE s.id = :studentNo")
    DeptEntity getDeptByStudentNo(@Param("studentNo") Long studentNo);

}
