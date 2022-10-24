package pp.security_bootstrap1.repository;

import pp.security_bootstrap1.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findRoleByName(String name);

}