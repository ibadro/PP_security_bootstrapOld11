package pp.security_bootstrap1.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pp.security_bootstrap1.model.User;
import org.springframework.data.crossstore.ChangeSetPersister;

import javax.transaction.Transactional;
import java.util.List;

public interface UserService extends UserDetailsService {
    @Transactional
    List<User> findAllUsers();

    @Transactional
    User findUserById(Long id) throws ChangeSetPersister.NotFoundException;

    @Transactional
    User findByUsername(String username);

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    @Transactional
    void saveUser(User user);

    @Transactional
    void updateUser(Long id, User updatedUser) throws ChangeSetPersister.NotFoundException;

    @Transactional
    void deleteUser(Long id) throws ChangeSetPersister.NotFoundException;

}
