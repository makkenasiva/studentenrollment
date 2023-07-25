package studentenrollment.StudentinfoApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.Role;
import studentenrollment.StudentinfoApi.Repository.RoleRepository;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void insertData(Integer roleId, String roleName) {
        Role role = new Role();
        role.setRole_id(roleId);
        role.setRole_name(roleName);
        roleRepository.save(role);
    }
}
