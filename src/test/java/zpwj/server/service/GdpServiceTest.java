package zpwj.server.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
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