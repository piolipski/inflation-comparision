package zpwj.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.models.Gdp;

import java.util.List;
import java.util.Optional;

@Repository
public interface BaseRetirementIncomeRepository extends JpaRepository<BaseRetirementIncome, Integer> {
    List<BaseRetirementIncome> findAllByCountryName(String countryName);
    Optional<BaseRetirementIncome> findById(Long id);
}
