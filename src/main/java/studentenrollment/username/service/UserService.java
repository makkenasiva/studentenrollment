package studentenrollment.username.service;

import studentenrollment.username.repository.UserRepository;
import studentenrollment.StudentinfoApi.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public boolean isUsernameExists(String username) {
        User existingUser = userRepository.findByUsernameIgnoreCase(username);
        return existingUser != null;
    }

    public User storeUser(String username, String password, String email, String status, Integer studentId) {
        User user = new User();
        user.setUsername(username);
        user.setUserPassword(password);
        user.setEmail(email);
        user.setStatus(status);
        user.setStudentId(studentId);
        return userRepository.save(user);
    }
}
