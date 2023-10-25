package zpwj.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "minimal_income")
public class MinimalIncome {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private double value;
    private String currency;
    private String countryName;

    public MinimalIncome(Integer year, double value, String currency, String countryName) {
        this.year = year;
        this.value = value;
        this.currency = currency;
        this.countryName = countryName;
    }
}
