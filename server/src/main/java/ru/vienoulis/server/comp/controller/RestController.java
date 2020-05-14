package ru.vienoulis.server.comp.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.vienoulis.server.comp.model.Role;
import ru.vienoulis.server.comp.model.User;
import ru.vienoulis.server.comp.service.interfaces.RoleService;
import ru.vienoulis.server.comp.service.interfaces.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    private final UserService userService;
    private final RoleService roleService;

    public RestController(RoleService roleService, UserService userService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/GET/user")
    public User getUserByName(String name){
        return userService.getUserByName(name);
    }

    @GetMapping("/GET/user/by_id")
    public User getUserById(Long id){
        return userService.getUserById(id);
    }

    @PostMapping(value = "/POST/add/user",produces = MediaType.APPLICATION_JSON_VALUE)
    public void postUser(@RequestBody User user){
        userService.add(user);
    }

    @GetMapping("/GET/user_list")
    public List<User> getAdmin() {
        return userService.getUsers();
    }

    @DeleteMapping("/POST/delete")
    public long postDelete( Long id) {
        userService.delete(id);
        return id;
    }
    @PutMapping("/POST/update")
    public User postUpdateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/GET/role/list")
    public List<Role> gepRoleList(){
        return roleService.getAllRoles();
    }

    @GetMapping("/GET/role/by_name")
    public Role getRoleByName(String name){
        return roleService.getRoleByName(name);
    }

}
