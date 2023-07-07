package studentenrollment.username.model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class UserName {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    // Default constructor
    public UserName() {
    }

    // Constructor with username
    public UserName(String username) {
        this.username = username;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
