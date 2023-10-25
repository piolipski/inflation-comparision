package zpwj.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "base_retirement_income")
public class BaseRetirementIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private double value;
    private String currency;
    private String countryName;

    public BaseRetirementIncome(Integer year, double value, String currency,String countryName) {
        this.year = year;
        this.value = value;
        this.currency = currency;
        this.countryName = countryName;
    }
}
