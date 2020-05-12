package ru.vienoulis.server.comp.controller;

import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vienoulis.server.comp.model.Role;
import ru.vienoulis.server.comp.model.User;
import ru.vienoulis.server.comp.service.interfaces.RoleService;
import ru.vienoulis.server.comp.service.interfaces.UserService;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

//    @GetMapping(value = "/GET/user")
//    public User getUser(Authentication authentication) {
//        return (User) authentication.getPrincipal();
//    }

    @GetMapping("/GET/user/by_id")
    public User getUserById( Long id){
        return userService.getUserById(id);
    }

    @GetMapping("/GET/user/by_name")
    public User getUserByName(String name){
        return userService.getUserByName(name);
    }

    @GetMapping("GET/user_list")
    public List<User> getAdmin() {
        return userService.getUsers();
    }

    @PostMapping("/POST/delete")
    public void postDelete(Long id) {
        userService.delete(id);
    }
    @PostMapping("/POST/update")
    public void postUpdateUser(User user, String ...roleList){
        userService.updateUser(user, roleList);
    }

    @GetMapping("/GET/role/list")
    public List<Role> gepRoleList(){
        return roleService.getAllRoles();
    }
}
