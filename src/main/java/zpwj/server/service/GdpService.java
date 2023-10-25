package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.Gdp;
import zpwj.server.repository.GdpRepository;

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
