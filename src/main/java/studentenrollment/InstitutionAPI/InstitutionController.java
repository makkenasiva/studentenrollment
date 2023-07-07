package studentenrollment.InstitutionAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/institutions")
public class InstitutionController {
    private final InstitutionService institutionService;

    @Autowired
    public InstitutionController(InstitutionService institutionService) {
        this.institutionService = institutionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Institution>> getAllInstitutions() {
        List<Institution> institutions = institutionService.getAllInstitutions();
        return ResponseEntity.ok(institutions);
    }

    @GetMapping("/{institutionId}")
    public ResponseEntity<?> getInstitutionById(@PathVariable("institutionId") Long institutionId) {
        Institution institution = institutionService.getInstitutionByInstitutionId(institutionId);

        if (institution.getName().equals("Institution not found")) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Institution not found\"}");
        } else {
            return ResponseEntity.ok(institution);
        }
    }
}
