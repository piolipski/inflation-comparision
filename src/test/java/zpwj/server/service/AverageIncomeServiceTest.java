package zpwj.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import zpwj.server.models.AverageIncome;
import zpwj.server.repository.AverageIncomeRepository;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

@SpringBootTest
public class AverageIncomeServiceTest {

    @Autowired
    private AverageIncomeService averageIncomeService;

    @MockBean
    private AverageIncomeRepository averageIncomeRepository;

    @Test
    public void testGetAllAverageIncome() {

        AverageIncome income1 = new AverageIncome(2001,24742.2,"PLN","POLAND");
        AverageIncome income2 = new AverageIncome(2002,25598.52,"PLN","POLAND");
        List<AverageIncome> incomes = Arrays.asList(income1, income2);

        when(averageIncomeRepository.findAll()).thenReturn(incomes);

        List<AverageIncome> result = averageIncomeService.getAllAverageIncome();

        Assertions.assertEquals(2, result.size());

    }

    @Test
    public void testGetAllAverageIncomeByCountryName() {

        String countryName = "POLAND";
        AverageIncome incomePoland1 = new AverageIncome(2001, 24742.2, "PLN", "POLAND");
        AverageIncome incomePoland2 = new AverageIncome(2005, 26000.0, "PLN", "POLAND");
        AverageIncome incomeGermany = new AverageIncome(2002, 25598.52, "EUR", "GERMANY");
        AverageIncome incomeFrance = new AverageIncome(2003, 30000.0, "EUR", "FRANCE");
        List<AverageIncome> allIncomes = Arrays.asList(incomePoland1, incomePoland2, incomeGermany, incomeFrance);
        List<AverageIncome> polishIncomes = Arrays.asList(incomePoland1, incomePoland2);

        when(averageIncomeRepository.findAllByCountryName(countryName)).thenReturn(polishIncomes);

        List<AverageIncome> result = averageIncomeService.getAllAverageIncomeByCountryName(countryName);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(polishIncomes));
    }
}