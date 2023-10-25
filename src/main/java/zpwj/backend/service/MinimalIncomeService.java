package zpwj.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.backend.models.MinimalIncome;
import zpwj.backend.repository.MinimalIncomeRepository;

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
}
