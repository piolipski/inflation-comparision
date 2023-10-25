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
}
