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
import zpwj.server.models.AverageIncome;
import zpwj.server.models.Gdp;
import zpwj.server.repository.GdpRepository;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class GdpServiceTest {

    @Autowired
    private GdpService gdpService;

    @MockBean
    private GdpRepository gdpRepository;

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
    public void testGetAllGdp(){
        Gdp gdp1 = new Gdp(2001,190900000000.0,"USD","POLAND");
        Gdp gdp2 = new Gdp(2002,199100000000.0,"USD","POLAND");
        List<Gdp> gdps = Arrays.asList(gdp1, gdp2);

        when(gdpRepository.findAll()).thenReturn(gdps);

        List<Gdp> result = gdpService.getAllGdp();

        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetAllGdpByCountryName() {

        String countryName = "POLAND";
        Gdp gdpPoland1 = new Gdp(2001, 190900000000.0, "USD", "POLAND");
        Gdp gdpPoland2 = new Gdp(2005, 199100000000.0, "USD", "POLAND");
        Gdp gdpGermany = new Gdp(2002, 2078000000000000000.0, "USD", "GERMANY");
        Gdp gdpFrance = new Gdp(2003, 1845000000000000000.0, "USD", "FRANCE");
        List<Gdp> allGdps = Arrays.asList(gdpPoland1, gdpPoland2, gdpGermany, gdpFrance);
        List<Gdp> polishGdps = Arrays.asList(gdpPoland1, gdpPoland2);

        when(gdpRepository.findAllByCountryName(countryName)).thenReturn(polishGdps);

        List<Gdp> result = gdpService.getAllGdpByCountryName(countryName);

        Assertions.assertEquals(2, result.size());
        Assertions.assertTrue(result.containsAll(polishGdps));
    }



}