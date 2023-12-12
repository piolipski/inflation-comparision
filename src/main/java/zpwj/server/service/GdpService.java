package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.Gdp;
import zpwj.server.models.Inflation;
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

    public Gdp updateGdp(Long id, Gdp updatedGdp) {
        Gdp existingGdp = gdpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gdp not found with id: " + id));

        existingGdp.setYear(updatedGdp.getYear());
        existingGdp.setValue(updatedGdp.getValue());
        existingGdp.setCurrency(updatedGdp.getCurrency());
        existingGdp.setCountryName(updatedGdp.getCountryName());

        return gdpRepository.save(existingGdp);
    }

    public void deleteGdpById(Long id) {
        Gdp existingGdp = gdpRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Gdp not found with id: " + id));

        gdpRepository.delete(existingGdp);
    }


}
