package co.com.claro.repo;

import co.com.claro.entity.ShareHolder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShareHolderRepository extends JpaRepository<ShareHolder, Long> {
    Optional<ShareHolder> findByTipIdAndNumIdAndNumeroAccion(String tipId, Long numId, String numeroAccion);
    Optional<ShareHolder> findByNumeroAccion(String numeroAccion);
    Optional<ShareHolder> findByTipIdAndNumId(String tipId, Long numId);
}
