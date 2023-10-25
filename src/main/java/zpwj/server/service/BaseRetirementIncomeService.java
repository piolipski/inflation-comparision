package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.repository.BaseRetirementIncomeRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BaseRetirementIncomeService {
    private final BaseRetirementIncomeRepository baseRetirementIncomeRepository;

    public List<BaseRetirementIncome> getAllBaseRetirementIncome() {
        return baseRetirementIncomeRepository.findAll();
    }

    public List<BaseRetirementIncome> getAllBaseRetirementIncomeByCountryName(String countryName) {
        return baseRetirementIncomeRepository.findAllByCountryName(countryName);
    }
}
