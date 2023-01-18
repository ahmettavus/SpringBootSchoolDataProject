package general.repository;

import general.entity.LectureStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LectureStudentRepository extends JpaRepository<LectureStudent,Long> {
}
