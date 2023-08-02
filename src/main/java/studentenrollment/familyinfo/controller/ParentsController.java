package studentenrollment.familyinfo.controller;

import studentenrollment.familyinfo.model.Parents;
import studentenrollment.familyinfo.service.ParentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;






@RestController
@RequestMapping("/parents")
public class ParentsController {
    private final ParentsService parentsService;

    @Autowired
    public ParentsController(ParentsService parentsService) {
        this.parentsService = parentsService;
    }

    @PostMapping("/{studentId}")
    public ResponseEntity<?> storeParentDetails(
            @PathVariable int studentId,
            @RequestParam String fatherName,
            @RequestParam String motherName,
            @RequestParam Long contactNumber
    ) {
        try {
            Parents updatedParents = parentsService.storeParentDetails(studentId, fatherName, motherName, contactNumber);
            return ResponseEntity.ok(updatedParents);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.OK).body(e.getMessage());
        }
    }
}




