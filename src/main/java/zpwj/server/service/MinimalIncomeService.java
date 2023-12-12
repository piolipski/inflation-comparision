package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.MinimalIncome;
import zpwj.server.repository.MinimalIncomeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class MinimalIncomeService {
    private final MinimalIncomeRepository minimalIncomeRepository;

    public List<MinimalIncome> getAllMinimalIncome() {
        return minimalIncomeRepository.findAll();
    }

    public List<MinimalIncome> getAllMinimalIncomeByCountryName(String countryName) {
        return minimalIncomeRepository.findAllByCountryName(countryName);
    }

    public MinimalIncome updateMinimalIncome(Long id, MinimalIncome updatedIncome) {
        MinimalIncome existingIncome = minimalIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MinimalIncome not found with id: " + id));

        existingIncome.setYear(updatedIncome.getYear());
        existingIncome.setValue(updatedIncome.getValue());
        existingIncome.setCurrency(updatedIncome.getCurrency());
        existingIncome.setCountryName(updatedIncome.getCountryName());

        return minimalIncomeRepository.save(existingIncome);
    }

    public void deleteMinimalIncomeById(Long id) {
        MinimalIncome existingIncome = minimalIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("MinimalIncome not found with id: " + id));

        minimalIncomeRepository.delete(existingIncome);
    }


}
