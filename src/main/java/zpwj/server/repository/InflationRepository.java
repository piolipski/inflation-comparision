package zpwj.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import zpwj.server.models.Inflation;
import zpwj.server.models.MinimalIncome;

import java.util.List;
import java.util.Optional;

public interface InflationRepository extends JpaRepository<Inflation, Integer> {

    List<Inflation> findAllByCountryName(String countryName);
    Optional<Inflation> findById(Long id);
}
