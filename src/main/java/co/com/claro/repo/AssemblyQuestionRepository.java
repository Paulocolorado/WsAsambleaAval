package co.com.claro.repo;

import co.com.claro.entity.AssemblyQuestions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AssemblyQuestionRepository extends JpaRepository<AssemblyQuestions, Long> {
}
