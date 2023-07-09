package studentenrollment.familyinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentenrollment.familyinfo.model.Siblings;
import studentenrollment.familyinfo.service.SiblingsService;

@RestController
@RequestMapping("/api/v1/family/siblings")
public class SiblingsController {
    private SiblingsService siblingsService;

    @Autowired
    public SiblingsController(SiblingsService siblingsService) {
        this.siblingsService = siblingsService;
    }

    @PostMapping("/siblings")
    public ResponseEntity<?> saveSiblings(@RequestBody Siblings siblings) {
        boolean studentExists = siblingsService.checkIfStudentExists(siblings.getStudentId());
        if (studentExists) {
            Siblings savedSiblings = siblingsService.saveSiblings(siblings);
            return ResponseEntity.ok(savedSiblings);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"Institution not found\"}");
        }
    }
}

