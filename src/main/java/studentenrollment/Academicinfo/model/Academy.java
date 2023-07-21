package studentenrollment.Academicinfo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Academy")
public class Academy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonIgnore
    private Integer id;

    @Column(name="studentId")
    private Integer studentId;

    @Column(name = "stateid")
    private Integer stateId;

    @Column(name = "cityId")
    private Integer cityId;

    @Column(name = "districtId")
    private Integer districtId;

    @Column(name = "schoolName")
    private String schoolName;

    @Column(name = "EntryOrTransfer")
    private String entryOrTransfer;


}
