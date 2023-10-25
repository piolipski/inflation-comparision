package zpwj.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import zpwj.backend.models.Inflation;

import java.util.List;

public interface InflationRepository extends JpaRepository<Inflation, Integer> {

    List<Inflation> findAllByCountryName(String countryName);
}
