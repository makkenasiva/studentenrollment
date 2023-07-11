package studentenrollment.SearchApi.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentenrollment.SearchApi.Service.StudentSearchService;
import studentenrollment.SearchApi.pojo.SearchEntity;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentSearchController {
    @Autowired
    private StudentSearchService studentSearchService;

    @GetMapping("/{input}")
    public ResponseEntity<List<SearchEntity>> searchStudents(@PathVariable String input) {
        List<SearchEntity> searchResults = studentSearchService.searchStudents(input);
        return new ResponseEntity<>(searchResults, HttpStatus.OK);
    }
}
