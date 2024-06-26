package zpwj.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import zpwj.server.models.Inflation;
import zpwj.server.repository.InflationRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class InflationServiceTest {
    @Autowired
    private InflationService inflationService;

    @MockBean
    private InflationRepository inflationRepository;

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
    public void testGetAllInflation() {
        Inflation inflation1 = new Inflation(2000, 5.1, "CPI", "POLAND");
        Inflation inflation2 = new Inflation(2001, 6.3, "CPI", "POLAND");

        List<Inflation> minimalIncomes = Arrays.asList(inflation1, inflation2);

        when(inflationRepository.findAll()).thenReturn(minimalIncomes);

        List<Inflation> result = inflationService.getAllInflation();

        assertEquals(2, result.size());
    }

    @Test
    public void testGetAllInflationByCountryName() {
        String countryName = "GERMANY";
        Inflation inflation1 = new Inflation(2002, 8, "CPI", "RUSSIA");
        Inflation inflation2 = new Inflation(2005, 7, "CPI", "POLAND");
        Inflation inflation3 = new Inflation(2003, 4, "CPI", "GERMANY");
        Inflation inflation4 = new Inflation(2001, 7, "CPI", "GERMANY");

        List<Inflation> inflationList = Arrays.asList(inflation1, inflation2, inflation3, inflation4);
        List<Inflation> germanInflation = Arrays.asList(inflation3, inflation4);

        when(inflationRepository.findAllByCountryName(countryName)).thenReturn(germanInflation);

        List<Inflation> result = inflationService.getAllInflationByCountryName(countryName);

        assertEquals(2, result.size());
    }

    @Test
    public void testGetInflationScore() {
        double actualInflationScore = inflationService.getInflationScore(110, 100);
        Assertions.assertEquals(10.0, actualInflationScore, 0.01);
    }

}