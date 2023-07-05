package studentenrollment.UserCreationApi;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import studentenrollment.UserCreationApi.UserModel;
import studentenrollment.UserCreationApi.UserRepository;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserRepository userRepository;

    @Autowired
    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @PostMapping("/register")
    public String registerUser(@RequestBody UserModel user) {
        // Check if the username or emailId already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            return "Username already exists!";
        }
        if (userRepository.findByEmailId(user.getEmailId()) != null) {
            return "Email already exists!";
        }

        // Set the default status to ACTIVE for a newly registered user
        user.setStatus(UserModel.Status.ACTIVE);

        // Save the user
        userRepository.save(user);
        return "Registration successful!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest) {
        UserModel user = userRepository.findByUsername(loginRequest.getUsername());
        if (user == null || !user.getPassword().equals(loginRequest.getPassword())) {
            return "Invalid username or password";
        }

        return "Login successful!";
    }

    // Inner class for login request
    @Getter
    @Setter
    public static class LoginRequest {
        private String username;
        private String password;
    }
}
