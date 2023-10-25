package zpwj.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.server.models.MinimalIncome;

import java.util.List;

@Repository
public interface MinimalIncomeRepository extends JpaRepository<MinimalIncome, Integer> {
    List<MinimalIncome> findAllByCountryName(String countryName);
}
