package studentenrollment.citydistrictapi.controller;

import studentenrollment.citydistrictapi.model.District;
import studentenrollment.citydistrictapi.service.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/districts")

public class DistrictController {

    @Autowired
    private DistrictService districtService;

    public DistrictController(DistrictService districtService) {
        this.districtService = districtService;
    }


    @GetMapping("/districts/all")
    public ResponseEntity<List<District>> getAllDistricts() {
        List<District> districts = districtService.getAllDistricts();
        return ResponseEntity.ok(districts);
    }

  /*  @GetMapping("/districts/{id}")
    public ResponseEntity<District> getDistrictById(@PathVariable int id) {
        Optional<District> optionalDistrict = districtService.getDistrictById(id);
        if (optionalDistrict.isPresent()) {
            District district = optionalDistrict.get();
            return ResponseEntity.ok(district);
        } else {
            return ResponseEntity.notFound().build();
        }
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<?> getDistrictById(@PathVariable Integer id) {
        District district = districtService.getDistrictById(id);

        if (district == null) {
            return ResponseEntity.status(HttpStatus.OK).body("District not found");
        } else {
            return ResponseEntity.ok(district);
        }
    }
}