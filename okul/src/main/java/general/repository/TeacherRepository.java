package general.repository;

import general.entity.Teacher;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
    List<Teacher> findAllByNameLike(String name, Sort sort);
    List<Teacher> findAllByNameLikeOrderByNameAsc(String name);
    List<Teacher> findByNameLike(String name);


}
