package pp.security_bootstrap1.repository;

import org.springframework.stereotype.Repository;
import pp.security_bootstrap1.model.Role;

import java.util.Set;


@Repository
public interface RoleRepository  {
    Set<Role> getAllRoles();

    Set<Role> getByName(String name);

    void saveRole(Role role);
}