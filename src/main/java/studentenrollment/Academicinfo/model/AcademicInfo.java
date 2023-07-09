package studentenrollment.Academicinfo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@Entity
public class AcademicInfo {
    @Id
    private int id;
    private String schoolName;
    private String stateName;
    private String districtName;
    private String cityName;
    private String entryLevel;
    private String transfer;

    public int studentid;
}
