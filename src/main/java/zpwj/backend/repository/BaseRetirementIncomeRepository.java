package zpwj.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.backend.models.BaseRetirementIncome;

import java.util.List;

@Repository
public interface BaseRetirementIncomeRepository extends JpaRepository<BaseRetirementIncome, Integer> {
    List<BaseRetirementIncome> findAllByCountryName(String countryName);
}
