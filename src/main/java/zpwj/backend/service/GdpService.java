package zpwj.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.backend.models.Gdp;
import zpwj.backend.repository.GdpRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class GdpService {

    private final GdpRepository gdpRepository;

    public List<Gdp> getAllGdp() {
        return gdpRepository.findAll();
    }

    public List<Gdp> getAllGdpByCountryName(String countryName) {
        return gdpRepository.findAllByCountryName(countryName);
    }
}
