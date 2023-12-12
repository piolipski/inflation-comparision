package zpwj.server.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.models.Gdp;
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

    public BaseRetirementIncome updateBaseRetirementIncome(Long id, BaseRetirementIncome updatedBaseRetirementIncome) {
        BaseRetirementIncome existingBaseRetirementIncome = baseRetirementIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BaseRetirementIncome not found with id: " + id));

        existingBaseRetirementIncome.setYear(updatedBaseRetirementIncome.getYear());
        existingBaseRetirementIncome.setValue(updatedBaseRetirementIncome.getValue());
        existingBaseRetirementIncome.setCurrency(updatedBaseRetirementIncome.getCurrency());
        existingBaseRetirementIncome.setCountryName(updatedBaseRetirementIncome.getCountryName());

        return baseRetirementIncomeRepository.save(existingBaseRetirementIncome);
    }

    public void deleteBaseRetirementIncomeById(Long id) {
        BaseRetirementIncome existingBaseRetirementIncome = baseRetirementIncomeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("BaseRetirementIncome not found with id: " + id));

        baseRetirementIncomeRepository.delete(existingBaseRetirementIncome);
    }

}
