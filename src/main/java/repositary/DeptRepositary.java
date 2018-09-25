package repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.model.Dept;

public interface DeptRepositary extends JpaRepository<Dept, Integer> {

}
