package zpwj.backend.payload.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AverageIncomeRequest {

    @NotBlank
    private int year;

    @NotBlank
    private double value;

    @NotBlank
    private String currency;

    @NotBlank
    private String countryName;
}
