package zpwj.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.server.models.AverageIncome;
import zpwj.server.models.BaseRetirementIncome;

import java.util.List;
import java.util.Optional;

@Repository
public interface AverageIncomeRepository extends JpaRepository<AverageIncome, Integer> {
    List<AverageIncome> findAllByCountryName(String countryName);
    Optional<AverageIncome> findById(Long id);
}
