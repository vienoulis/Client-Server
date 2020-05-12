package ru.vienoulis.server.comp.service.interfaces;

import org.springframework.security.core.userdetails.UserDetailsService;
import ru.vienoulis.server.comp.model.User;
import java.util.List;

public interface UserService extends UserDetailsService {
    List<User> getUsers();

    void add(User user, String[] roleList);

    void add(User user);

    User updateUser( User user, String ... roleList);

    void delete(Long userId);

    User getUserByName(String name);

    User getUserById(Long id);
}
