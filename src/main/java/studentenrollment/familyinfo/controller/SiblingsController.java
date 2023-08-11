package studentenrollment.familyinfo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentenrollment.familyinfo.model.Siblings;
import studentenrollment.familyinfo.service.SiblingsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/siblings")
@CrossOrigin("*")
public class SiblingsController {
    private final SiblingsService siblingsService;

    @Autowired
    public SiblingsController(SiblingsService siblingsService) {
        this.siblingsService = siblingsService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<?> storeSiblingDetails(
            @PathVariable int studentId,
            @RequestParam String firstName,
            @RequestParam String middleName,
            @RequestParam String lastName,
            @RequestParam Long contactNumber
    ) {
        try {
            Siblings updatedSibling = siblingsService.storeSiblingDetails(studentId, firstName, middleName, lastName, contactNumber);
            return ResponseEntity.ok(updatedSibling);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }
}


