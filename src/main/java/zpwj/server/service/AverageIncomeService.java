package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.AverageIncome;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.repository.AverageIncomeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class AverageIncomeService {
    private final AverageIncomeRepository averageIncomeRepository;

    public List<AverageIncome> getAllAverageIncome() {
        return averageIncomeRepository.findAll();
    }

    public List<AverageIncome> getAllAverageIncomeByCountryName(String countryName) {
        return averageIncomeRepository.findAllByCountryName(countryName);
    }

    public AverageIncome updateAverageIncome(Long id, AverageIncome updatedBaseAverageIncome) {
        AverageIncome existingAverageIncome = averageIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AverageIncome not found with id: " + id));

        existingAverageIncome.setYear(updatedBaseAverageIncome.getYear());
        existingAverageIncome.setValue(updatedBaseAverageIncome.getValue());
        existingAverageIncome.setCurrency(updatedBaseAverageIncome.getCurrency());
        existingAverageIncome.setCountryName(updatedBaseAverageIncome.getCountryName());

        return averageIncomeRepository.save(existingAverageIncome);
    }

    public void deleteAverageIncomeById(Long id) {
        AverageIncome existingAverageIncome = averageIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("AverageIncome not found with id: " + id));

        averageIncomeRepository.delete(existingAverageIncome);
    }

}
