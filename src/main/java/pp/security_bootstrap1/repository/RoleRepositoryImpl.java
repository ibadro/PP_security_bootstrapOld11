package pp.security_bootstrap1.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pp.security_bootstrap1.model.Role;
import javax.persistence.EntityManager;

import java.util.Set;
import java.util.stream.Collectors;

@Repository
@Transactional
public class RoleRepositoryImpl implements RoleRepository {
    private EntityManager entityManager;

    @Override
    public Set<Role> getAllRoles() {
        String JPAql = "SELECT role FROM Role role";
        return entityManager.createQuery(JPAql, Role.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Set<Role> getByName(String name) {
        String JPAql = "SELECT role FROM Role role WHERE role.name = :name";
        return entityManager.createQuery(JPAql, Role.class).setParameter("name", name)
                .getResultStream().collect(Collectors.toSet());
    }

    @Override
    public void saveRole(Role role) {
        entityManager.persist(role);
    }

}

