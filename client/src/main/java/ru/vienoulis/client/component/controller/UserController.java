package ru.vienoulis.client.component.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import ru.vienoulis.client.component.model.User;
import ru.vienoulis.client.component.service.inter.RoleService;
import ru.vienoulis.client.component.service.inter.UserService;

@Controller
public class UserController {


    private final UserService userService;
    private final RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping(value = "user")
    public String getUser(ModelMap map, Authentication authentication) {
        User visitor = (User) authentication.getPrincipal();
        map.addAttribute("visitor", visitor);
        return "user";
    }

    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdmin(ModelMap map, Authentication authentication) {
        User user = (User) authentication.getPrincipal();
        map.addAttribute("visitor",user);
        map.addAttribute("roles", roleService.getAllRoles());
        return "admin";
    }

    @PostMapping("/admin/user")
    public String postNewUser(ModelMap map, Authentication authentication, User user, String ...roleList) {
        userService.add(user, roleList);
        User visitor = (User) authentication.getPrincipal();
        map.addAttribute("visitor",visitor);

        return "redirect:/admin";
    }
}