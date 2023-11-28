package main.java.school.DB.Repository;

import main.java.school.DB.Entity.SubjectEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SubjectEntityRepository extends JpaRepository<SubjectEntity, Long> {

    @Query("select s from SubjectEntity s where s.deptObj.id = :deptNo")
    List<SubjectEntity> getSubjectsByDeptNo(@Param("deptNo") Long deptNo);

}
