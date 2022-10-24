package pp.security_bootstrap1.service;

import pp.security_bootstrap1.model.Role;
import pp.security_bootstrap1.repository.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;

    @Autowired
    public RoleServiceImpl(RoleRepo roleRepo) {
        this.roleRepo = roleRepo;
    }

    @Override
    public Role findRoleByName(String name) {
        return roleRepo.findRoleByName(name);
    }
}