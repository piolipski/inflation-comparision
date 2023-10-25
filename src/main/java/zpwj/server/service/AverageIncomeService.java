package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.AverageIncome;
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
}
