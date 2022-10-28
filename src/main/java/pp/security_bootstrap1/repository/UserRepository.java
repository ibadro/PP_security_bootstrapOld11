package pp.security_bootstrap1.repository;


import org.springframework.stereotype.Repository;
import pp.security_bootstrap1.model.User;

import java.util.List;


@Repository
public interface UserRepository  {
    List<User> getAllUsers();

    void create(User user);

    User getUserById(Long id);

    void delete(Long id);

    void update(User user);

    User findByUsername(String username);

}