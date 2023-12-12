package zpwj.server.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import zpwj.server.models.Gdp;
import zpwj.server.models.Inflation;

import java.util.List;
import java.util.Optional;

@Repository
public interface GdpRepository extends JpaRepository<Gdp, Integer> {
    List<Gdp> findAllByCountryName(String countryName);
    Optional<Gdp> findById(Long id);
}
