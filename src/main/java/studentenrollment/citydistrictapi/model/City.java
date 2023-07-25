package studentenrollment.citydistrictapi.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="City")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="cityname")
    public String cityname;

    @Column(name="stateid")
    public Integer stateid;

    public static City cityNotFound() {
        City notFound = new City();
        notFound.setCityname("City not found");
        return notFound;
    }
}
