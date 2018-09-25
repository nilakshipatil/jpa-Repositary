package repositary;

import org.springframework.data.jpa.repository.JpaRepository;

import com.query.model.Emp;

public interface EmpRepositary extends JpaRepository<Emp, Integer> {

}
