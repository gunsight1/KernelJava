package main.java.school.DB.Repository;

import main.java.school.DB.Entity.ScoreEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScoreEntityRepository extends JpaRepository<ScoreEntity,Long> {

}
