package zpwj.server.controllers;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zpwj.server.models.*;
import zpwj.server.payload.request.*;
import zpwj.server.payload.response.MessageResponse;
import zpwj.server.repository.*;
import zpwj.server.service.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/database")
@Transactional
public class EditDatabaseController {

    AverageIncomeService averageIncomeService;
    MinimalIncomeService minimalIncomeService;
    BaseRetirementIncomeService baseRetirementIncomeService;
    GdpService gdpService;
    InflationService inflationService;
    AverageIncomeRepository averageIncomeRepository;
    BaseRetirementIncomeRepository baseRetirementIncomeRepository;
    GdpRepository gdpRepository;
    InflationRepository inflationRepository;
    MinimalIncomeRepository minimalIncomeRepository;

    @PutMapping("/minimalincome/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editMinimalIncome (@Valid @PathVariable("id") Long id, @RequestBody MinimalIncomeRequest minimalIncomeRequest  ){

        MinimalIncome updatedMinimalIncome = new MinimalIncome(minimalIncomeRequest.getYear(), minimalIncomeRequest.getValue(), minimalIncomeRequest.getCurrency(), minimalIncomeRequest.getCountryName());

        minimalIncomeService.updateMinimalIncome(id, updatedMinimalIncome);

        return ResponseEntity.ok(new MessageResponse("Minimal income updated!"));

    };

    @PutMapping("/averageincome/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editAverageIncome(@Valid @PathVariable("id") Long id, @RequestBody AverageIncomeRequest averageIncomeRequest) {
        AverageIncome updatedAverageIncome = new AverageIncome(averageIncomeRequest.getYear(), averageIncomeRequest.getValue(), averageIncomeRequest.getCurrency(), averageIncomeRequest.getCountryName());
        averageIncomeService.updateAverageIncome(id, updatedAverageIncome);
        return ResponseEntity.ok(new MessageResponse("Average income updated!"));
    }

    @PutMapping("/baseretirementincome/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editBaseRetirementIncome(@Valid @PathVariable("id") Long id, @RequestBody BaseRetirementRequest baseRetirementIncomeRequest) {
        BaseRetirementIncome updatedBaseRetirementIncome = new BaseRetirementIncome(baseRetirementIncomeRequest.getYear(), baseRetirementIncomeRequest.getValue(), baseRetirementIncomeRequest.getCurrency(), baseRetirementIncomeRequest.getCountryName());
        baseRetirementIncomeService.updateBaseRetirementIncome(id, updatedBaseRetirementIncome);
        return ResponseEntity.ok(new MessageResponse("Base retirement income updated!"));
    }

    @PutMapping("/gdp/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editGdp(@Valid @PathVariable("id") Long id, @RequestBody GdpRequest gdpRequest) {
        Gdp updatedGdp = new Gdp(gdpRequest.getYear(), gdpRequest.getValue(), gdpRequest.getCurrency(), gdpRequest.getCountryName());
        gdpService.updateGdp(id, updatedGdp);
        return ResponseEntity.ok(new MessageResponse("GDP updated!"));
    }

    @PutMapping("/inflation/edit/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> editInflation(@Valid @PathVariable("id") Long id, @RequestBody InflationRequest inflationRequest) {
        Inflation updatedInflation = new Inflation(inflationRequest.getYear(), inflationRequest.getValue(), inflationRequest.getCurrency(), inflationRequest.getCountryName());
        inflationService.updateInflation(id, updatedInflation);
        return ResponseEntity.ok(new MessageResponse("Inflation updated!"));
    }



}
