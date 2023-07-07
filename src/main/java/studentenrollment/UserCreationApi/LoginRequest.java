package studentenrollment.UserCreationApi;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginRequest {
    private String username;
    private String password;

    // Constructors, getters, setters (omitted for brevity)
    // Add the getter and setter for the 'username' field
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
