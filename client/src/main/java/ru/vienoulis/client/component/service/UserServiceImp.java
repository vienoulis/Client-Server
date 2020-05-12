package ru.vienoulis.client.component.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ru.vienoulis.client.component.controller.RestController;
import ru.vienoulis.client.component.model.User;
import ru.vienoulis.client.component.service.inter.UserService;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserServiceImp implements UserService, UserDetailsService {

    private final RestController restController;

    public UserServiceImp(RestController restController) {
        this.restController = restController;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = getUserByName(username);
        return getUserByName(username);
    }

    @Override
    public List<User> getUsers() {
        return restController.getUsers();
    }

    @Override
    public void add(User user, String[] roleList) {
        user.setRoleSet(Arrays.stream(roleList)
                .map(restController::getRoleByName)
                .collect(Collectors.toSet())
        );
        restController.addUser(user);
    }

    @Override
    public User updateUser (User user, String...roleList){
        user.setRoleSet(Arrays.stream(roleList)
                .map(restController::getRoleByName)
                .collect(Collectors.toSet())
        );
        restController.update(user);
        return user;
    }

    @Override
    public void delete(Long userId) {
        restController.delete(userId);
    }

    @Override
    public User getUserByName(String name) {
        return restController.getUserByName(name);
    }

    @Override
    public User getUserById(Long id) {
        return restController.getUserById(id);
    }
}
