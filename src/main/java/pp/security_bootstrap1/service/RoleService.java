package pp.security_bootstrap1.service;

import pp.security_bootstrap1.model.Role;

public interface RoleService {
    Role findRoleByName(String name);
}