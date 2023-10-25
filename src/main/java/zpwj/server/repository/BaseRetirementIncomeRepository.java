package zpwj.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.server.models.BaseRetirementIncome;

import java.util.List;

@Repository
public interface BaseRetirementIncomeRepository extends JpaRepository<BaseRetirementIncome, Integer> {
    List<BaseRetirementIncome> findAllByCountryName(String countryName);
}
