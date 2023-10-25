package zpwj.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.backend.models.Gdp;

import java.util.List;

@Repository
public interface GdpRepository extends JpaRepository<Gdp, Integer> {
    List<Gdp> findAllByCountryName(String countryName);
}
