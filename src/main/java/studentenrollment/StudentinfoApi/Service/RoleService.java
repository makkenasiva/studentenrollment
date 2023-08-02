package studentenrollment.StudentinfoApi.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import studentenrollment.StudentinfoApi.Model.Role;
import studentenrollment.StudentinfoApi.Model.UserRole;
import studentenrollment.StudentinfoApi.Repository.RoleRepository;
import studentenrollment.StudentinfoApi.Repository.UserRoleRepository;

import java.util.List;
import java.util.Scanner;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    private UserRoleRepository userRoleRepository;

    public void insertData(Integer roleId, String roleName) {
        Role role = new Role();
        role.setRole_id(roleId);
        role.setRole_name(roleName);
        roleRepository.save(role);
    }

    @Autowired
    public RoleService(UserRoleRepository userRoleRepository) {
        this.userRoleRepository = userRoleRepository;
    }
    public List<Role> getAllRoles() {

        return roleRepository.findAll();
    }
}
