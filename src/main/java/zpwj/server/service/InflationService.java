package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.Inflation;
import zpwj.server.models.MinimalIncome;
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

    public double getInflationScore(double endingCpiLevel , double beginningCpiLevel){
        return (endingCpiLevel - beginningCpiLevel)/beginningCpiLevel*100;
    }

    public Inflation updateInflation(Long id, Inflation updatedInflation) {
        Inflation existingInflation = inflationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inflation not found with id: " + id));

        existingInflation.setYear(updatedInflation.getYear());
        existingInflation.setValue(updatedInflation.getValue());
        existingInflation.setCurrency(updatedInflation.getCurrency());
        existingInflation.setCountryName(updatedInflation.getCountryName());

        return inflationRepository.save(existingInflation);
    }

    public void deleteInflationById(Long id) {
        Inflation existingInflation = inflationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Inflation not found with id: " + id));

        inflationRepository.delete(existingInflation);
    }


}
