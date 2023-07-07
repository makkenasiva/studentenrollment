package studentenrollment.citydistrictapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class District {
    @Id
    private int id;
    public String districtname;
    public int cityid;

    public static District districtNotFound() {
        District notFound = new District();
        notFound.setDistrictname("District not found");
        return notFound;
    }
}