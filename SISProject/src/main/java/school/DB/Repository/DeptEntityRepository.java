package main.java.school.DB.Repository;

import main.java.school.DB.Entity.DeptEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DeptEntityRepository extends JpaRepository<DeptEntity,Long> {
    @Query("select s from StudentEntity s where s.id = :studentNo")
    List<DeptEntity> getDeptsByStudentNo(@Param("studentNo") Long studentNo);

}
