package ru.vienoulis.server.comp.service.interfaces;

import ru.vienoulis.server.comp.model.User;

import java.util.List;

public interface UserService {
    List<User> getUsers();

    void add(User user, String[] roleList);

    void updateUser(User user, String... roleList);

    void delete(Long userId);

    User getUserByName(String name);

    User getUserById(Long id);
}
