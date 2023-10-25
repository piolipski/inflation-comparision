package zpwj.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.backend.models.AverageIncome;

import java.util.List;

@Repository
public interface AverageIncomeRepository extends JpaRepository<AverageIncome, Integer> {
    List<AverageIncome> findAllByCountryName(String countryName);
}
