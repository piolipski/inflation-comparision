package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.Inflation;
import zpwj.server.repository.InflationRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class InflationService {
    private final InflationRepository inflationRepository;

    public List<Inflation> getAllInflation() {return inflationRepository.findAll();}

    public List<Inflation> getAllInflationByCountryName(String countryName){
        return inflationRepository.findAllByCountryName(countryName);
    }
}
