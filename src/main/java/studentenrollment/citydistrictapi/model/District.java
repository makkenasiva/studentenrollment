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
@Table(name = "District")
public class District {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "districtname")
    public String districtname;

    @Column(name = "cityid")
    public Integer cityid;

    public static District districtNotFound() {
        District notFound = new District();
        notFound.setDistrictname("District not found");
        return notFound;
    }
}