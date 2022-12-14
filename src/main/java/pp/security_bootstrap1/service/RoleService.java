package pp.security_bootstrap1.service;


import pp.security_bootstrap1.model.Role;

import java.util.Set;

public interface RoleService {
    Set<Role> getAllRoles();

    Set<Role> getByName(String name);

    void saveRole(Role role);
}
