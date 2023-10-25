package zpwj.server.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "inflation")
public class Inflation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer year;
    private double value;
    private String currency;
    private String countryName;

    public Inflation(Integer year, double value, String currency, String countryName) {
        this.year = year;
        this.value = value;
        this.currency = currency;
        this.countryName = countryName;
    }
}
