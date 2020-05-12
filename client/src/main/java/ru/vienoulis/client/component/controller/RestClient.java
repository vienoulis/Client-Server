package ru.vienoulis.client.component.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vienoulis.client.component.model.Role;
import ru.vienoulis.client.component.model.User;
import ru.vienoulis.client.component.service.inter.RoleService;
import ru.vienoulis.client.component.service.inter.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestClient {
    private final UserService userService;

    private final RoleService roleService;

    public RestClient(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "/GET/client/user")
    public User getUser(Authentication authentication) {
        return (User) authentication.getPrincipal();
    }

    @GetMapping("/GET/client/user/by_id")
    public User getUserById( Long id){
        return userService.getUserById(id);
    }

    @GetMapping("GET/client/user_list")
    public List<User> getAdmin() {
        return userService.getUsers();
    }

    @PostMapping("/POST/client/delete")
    public long postDelete(Long id) {
        userService.delete(id);
        return id;
    }
    @PostMapping("/POST/client/update")
    public User postUpdateUser(User user, String ...roleList){
        return userService.updateUser(user, roleList);
    }

    @GetMapping("/GET/client/role/list")
    public List<Role> gepRoleList(){
        return roleService.getAllRoles();
    }

    @GetMapping("/GET/client/role/by_name")
    public Role getRoleByName(String name){
        return roleService.getRoleByName(name);
    }

}
