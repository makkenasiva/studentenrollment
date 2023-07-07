package studentenrollment.username.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.User;
import studentenrollment.username.repository.UserNameRepository;

@Service
public class UserNameService {

    @Autowired
    private UserNameRepository userRepository;

    public boolean isUsernameExists(String username) {
        User existingUser = userRepository.findByUsernameIgnoreCase(username);
        return existingUser != null;
    }
}
