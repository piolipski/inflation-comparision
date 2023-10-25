package zpwj.server.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import zpwj.server.models.Inflation;

import java.util.List;

public interface InflationRepository extends JpaRepository<Inflation, Integer> {

    List<Inflation> findAllByCountryName(String countryName);
}
