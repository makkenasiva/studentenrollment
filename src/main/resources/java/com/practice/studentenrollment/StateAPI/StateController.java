package com.practice.studentenrollment.StateAPI;

import com.practice.studentenrollment.InstitutionAPI.Institution;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {
    private final StateService stateService;

    @Autowired
    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<State>> getAllStates() {
        List<State> states = stateService.getAllStates();
        return ResponseEntity.ok(states);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getInstitutionById(@PathVariable Long id) {
        State state = stateService.getStateById(id);

        if (state == null) {
            return ResponseEntity.status(HttpStatus.OK).body("{\"message\": \"state not found\"}");
        } else {
            return ResponseEntity.ok(state);
        }
    }
}

