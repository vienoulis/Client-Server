package ru.vienoulis.client.component.service.inter;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import ru.vienoulis.client.component.model.User;

import java.util.List;

public interface UserService  extends UserDetailsService {
    List<User> getUsers();

    void add(User user, String[] roleList);

    User updateUser( User user, String ... roleList);

    void delete(Long userId);

    User getUserByName(String name);

    User getUserById(Long id);

    UserDetails loadUserByUsername(String s) throws UsernameNotFoundException;
}
