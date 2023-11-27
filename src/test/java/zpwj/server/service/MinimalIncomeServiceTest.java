package zpwj.server.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import zpwj.server.models.MinimalIncome;
import zpwj.server.repository.MinimalIncomeRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class MinimalIncomeServiceTest {
    @Autowired
    private MinimalIncomeService minimalIncomeService;

    @MockBean
    private MinimalIncomeRepository minimalIncomeRepository;

    @Test
    public void testGetAllMinimalIncome() {
        // Mocking data
        MinimalIncome minimalIncome1 = new MinimalIncome(2000, 700, "PLN", "POLAND");
        MinimalIncome minimalIncome2 = new MinimalIncome(2001, 760, "PLN", "POLAND");

        List<MinimalIncome> minimalIncomes = Arrays.asList(minimalIncome1, minimalIncome2);

        when(minimalIncomeRepository.findAll()).thenReturn(minimalIncomes);

        List<MinimalIncome> result = minimalIncomeService.getAllMinimalIncome();

        // Verify the result
        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllMinimalIncomeByCountryName() {
        String countryName = "POLAND";
        MinimalIncome minimalIncome1 = new MinimalIncome(2000, 700, "PLN", "POLAND");
        MinimalIncome minimalIncome2 = new MinimalIncome(2001, 500, "EUR", "FRANCE");
        MinimalIncome minimalIncome3 = new MinimalIncome(2001, 555, "USD", "UNITED STATES");
        MinimalIncome minimalIncome4 = new MinimalIncome(2001, 600, "PLN", "POLAND");

        List<MinimalIncome> minimalIncomes = Arrays.asList(minimalIncome1, minimalIncome2, minimalIncome3, minimalIncome4);
        List<MinimalIncome> polishMinimalIncomes = Arrays.asList(minimalIncome1, minimalIncome4);

        when(minimalIncomeRepository.findAllByCountryName(countryName)).thenReturn(polishMinimalIncomes);

        List<MinimalIncome> result = minimalIncomeService.getAllMinimalIncomeByCountryName(countryName);

        assertEquals(2, result.size());
    }
}