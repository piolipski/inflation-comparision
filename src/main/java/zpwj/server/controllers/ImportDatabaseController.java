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

import java.util.List;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/database")
@Transactional
public class ImportDatabaseController {
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

    // Average Income
    @PostMapping("/averageincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addAverageIncome (@Valid @RequestBody List<AverageIncomeRequest> averageIncomeRequest){
        averageIncomeRequest.forEach(e -> {
            AverageIncome averageIncome = new AverageIncome(e.getYear(),e.getValue(),e.getCurrency(),e.getCountryName());

            averageIncomeRepository.save(averageIncome);
        });
        return ResponseEntity.ok(new MessageResponse("Average Income added successfully!"));
    }

    // Base Retirement Income
    @PostMapping("/baseretirementincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addBaseRetirementIncome (@Valid @RequestBody List<BaseRetirementRequest> baseRetirementIncomeRequest){
        baseRetirementIncomeRequest.forEach(e -> {
            BaseRetirementIncome baseRetirementIncome = new BaseRetirementIncome(e.getYear(), e.getValue(), e.getCurrency(), e.getCountryName());

            baseRetirementIncomeRepository.save(baseRetirementIncome);
        });
        return ResponseEntity.ok(new MessageResponse("Base retirement income added successfully!"));
    }

    // Gdp
    @PostMapping("/gdp")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addGdp (@Valid @RequestBody List<GdpRequest> gdpRequest){
        gdpRequest.forEach(e -> {
            Gdp gdp = new Gdp(e.getYear(),e.getValue(),e.getCurrency(),e.getCountryName());

            gdpRepository.save(gdp);
        });
        return ResponseEntity.ok(new MessageResponse("GDP added successfully!"));
    }

    // Inflation
    @PostMapping("/inflation")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addInflation (@Valid @RequestBody List<InflationRequest> inflationRequest){
        inflationRequest.forEach(e -> {
            Inflation inflation = new Inflation(e.getYear(),e.getValue(),e.getCurrency(),e.getCountryName());

            inflationRepository.save(inflation);
        });
        return ResponseEntity.ok(new MessageResponse("Inflation added successfully!"));
    }

    // Minimal Income
    @PostMapping("/minimalincome")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> addMinimalIncome (@Valid @RequestBody List<MinimalIncomeRequest> minimalIncomeRequest){
        minimalIncomeRequest.forEach(e -> {
            MinimalIncome minimalIncome = new MinimalIncome(e.getYear(),e.getValue(),e.getCurrency(),e.getCountryName());

            minimalIncomeRepository.save(minimalIncome);
        });
        return ResponseEntity.ok(new MessageResponse("Minimal income added successfully!"));
    }
}
