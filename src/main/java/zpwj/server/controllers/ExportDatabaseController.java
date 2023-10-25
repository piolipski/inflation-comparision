package zpwj.server.controllers;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zpwj.server.models.*;
import zpwj.server.service.*;

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/database")
@Transactional
public class ExportDatabaseController {
    AverageIncomeService averageIncomeService;
    MinimalIncomeService minimalIncomeService;
    BaseRetirementIncomeService baseRetirementIncomeService;
    GdpService gdpService;
    InflationService inflationService;

    // Average income
    @GetMapping("/averageincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<AverageIncome> getAllAverageIncome(){
        return averageIncomeService.getAllAverageIncome();
    }

    @GetMapping("/averageincome/{country_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<AverageIncome> getAverageIncomeByCountryName(@PathVariable("country_name") String countryName) {
        return averageIncomeService.getAllAverageIncomeByCountryName(countryName);
    }

    // Minimal income
    @GetMapping("/minimalincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<MinimalIncome> getAllMinimalIncome() {return minimalIncomeService.getAllMinimalIncome();}

    @GetMapping("/minimalincome/{country_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<MinimalIncome> getMinimalIncomeByCountryName(@PathVariable("country_name") String countryName) {
        return  minimalIncomeService.getAllMinimalIncomeByCountryName(countryName);
    }

    // Base retirement income
    @GetMapping("/baseretirementincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<BaseRetirementIncome> getAllBaseRetirementIncome() {return  baseRetirementIncomeService.getAllBaseRetirementIncome();}

    @GetMapping("/baseretirementincome/{country_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<BaseRetirementIncome> getBaseRetirementIncomeByCountryName(@PathVariable("country_name") String countryName) {
        return  baseRetirementIncomeService.getAllBaseRetirementIncomeByCountryName(countryName);
    }

    // GDP
    @GetMapping("/gdp")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<Gdp> getAllGdp() {return gdpService.getAllGdp();}

    @GetMapping("/gdp/{country_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<Gdp> getGdpByCountryName(@PathVariable("country_name") String countryName) {
        return gdpService.getAllGdpByCountryName(countryName);
    }

    // Inflation
    @GetMapping("/inflation")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<Inflation> getAllInflation() {return inflationService.getAllInflation();}

    @GetMapping("/inflation/{country_name}")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public List<Inflation> getInflationByCountryName(@PathVariable("country_name") String countryName) {
        return inflationService.getAllInflationByCountryName(countryName);
    }

}
