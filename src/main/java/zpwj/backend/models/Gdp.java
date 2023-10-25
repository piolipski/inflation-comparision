package zpwj.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "gdp")
public class Gdp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    private Integer year;
    private double value;
    private String currency;
    private String countryName;

    public Gdp(Integer year, double value, String currency, String countryName) {
        this.year = year;
        this.value = value;
        this.currency = currency;
        this.countryName = countryName;
    }
}
