package zpwj.server.controllers;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import zpwj.server.models.MinimalIncome;
import zpwj.server.payload.request.MinimalIncomeRequest;
import zpwj.server.payload.response.MessageResponse;
import zpwj.server.repository.*;
import zpwj.server.service.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@AllArgsConstructor
@RequestMapping("/api/database")
@Transactional
public class DeleteDatabaseController {
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

    @DeleteMapping("/minimalincome/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteMinimalIncome (@Valid @PathVariable("id") Long id  ){

        minimalIncomeService.deleteMinimalIncomeById(id);

        return ResponseEntity.ok(new MessageResponse("Minimal income: "+ id + " deleted!"));

    };

    @DeleteMapping("/averageincome/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteAverageIncome (@Valid @PathVariable("id") Long id  ){

        averageIncomeService.deleteAverageIncomeById(id);

        return ResponseEntity.ok(new MessageResponse("Average income: "+ id + " deleted!"));

    };

    @DeleteMapping("/baseretirementincome/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteBaseRetirementIncome (@Valid @PathVariable("id") Long id  ){

        baseRetirementIncomeService.deleteBaseRetirementIncomeById(id);

        return ResponseEntity.ok(new MessageResponse("Base retirement income: "+ id + " deleted!"));

    };

    @DeleteMapping("/gdp/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteGdp(@Valid @PathVariable("id") Long id  ){

       gdpService.deleteGdpById(id);

        return ResponseEntity.ok(new MessageResponse("Gdp: "+ id + " deleted!"));

    };

    @DeleteMapping("/inflation/delete/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> deleteInflation (@Valid @PathVariable("id") Long id  ){

        inflationService.deleteInflationById(id);

        return ResponseEntity.ok(new MessageResponse("Inflation: "+ id + " deleted!"));

    };

}
