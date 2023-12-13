package zpwj.server.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import zpwj.server.models.BaseRetirementIncome;
import zpwj.server.models.Inflation;
import zpwj.server.repository.BaseRetirementIncomeRepository;
import zpwj.server.repository.InflationRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class BaseRetirementIncomeServiceTest {
    @Autowired
    private BaseRetirementIncomeService baseRetirementIncomeService;

    @MockBean
    private BaseRetirementIncomeRepository baseRetirementIncomeRepository;

    @Container
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.2.0");
    @DynamicPropertySource
    static void dynamicConfiguration(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url",mySQLContainer::getJdbcUrl);
        registry.add("spring.datasource.username",mySQLContainer::getUsername);
        registry.add("spring.datasource.password",mySQLContainer::getPassword);
    }

    @BeforeAll
    static void startDb() {
        mySQLContainer.start();
    }

    @Test
    public void testGetAllBaseRetirementIncome() {
        BaseRetirementIncome bri1 = new BaseRetirementIncome(1999, 1327.44, "PLN", "POLAND");
        BaseRetirementIncome bri2 = new BaseRetirementIncome(2001, 1638.27, "PLN", "POLAND");

        List<BaseRetirementIncome> baseRetirementIncomes = Arrays.asList(bri1, bri2);

        when(baseRetirementIncomeRepository.findAll()).thenReturn(baseRetirementIncomes);

        List<BaseRetirementIncome> result = baseRetirementIncomeService.getAllBaseRetirementIncome();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllBaseRetirementIncomeByCountryName() {
        String countryName = "POLAND";
        BaseRetirementIncome bri1 = new BaseRetirementIncome(2003, 2059.92, "PLN", "POLAND");
        BaseRetirementIncome bri2 = new BaseRetirementIncome(2001, 1829.24, "PLN", "POLAND");
        BaseRetirementIncome bri3 = new BaseRetirementIncome(1999, 1327.44, "RUB", "RUSSIA");
        BaseRetirementIncome bri4 = new BaseRetirementIncome(2001, 800, "USD", "UNITED STATES");

        List<BaseRetirementIncome> baseRetirementIncomeList = Arrays.asList(bri1, bri2, bri3, bri4);
        List<BaseRetirementIncome> polishBaseRetirementIncomeList = Arrays.asList(bri1, bri2);

        when(baseRetirementIncomeRepository.findAllByCountryName(countryName)).thenReturn(polishBaseRetirementIncomeList);

        List<BaseRetirementIncome> result = baseRetirementIncomeService.getAllBaseRetirementIncomeByCountryName(countryName);

        assertEquals(2, result.size());
    }
}