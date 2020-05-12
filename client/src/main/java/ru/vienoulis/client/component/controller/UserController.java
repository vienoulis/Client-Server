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

    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @GetMapping(value = "user")
    public String getUser(ModelMap map, Authentication authentication) {
        User visitor = (User) authentication.getPrincipal();
//        List<User> users= new ArrayList<>();
//        users.add(visitor);
//        map.addAttribute("users", users);
        map.addAttribute("visitor", visitor);
        return "user";
    }

    @GetMapping(value = "login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/admin")
    public String getAdmin(ModelMap map, Authentication authentication) {
//        List<User> users = userService.getUsers();
        User user = (User) authentication.getPrincipal();
        map.addAttribute("visitor",user);
//        map.addAttribute("users", users);
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

    // -----------------------------------------------------------------------------------------//
//
//    @PostMapping("/admin/delete")
//    public String postDelete(Long id, ModelMap map) {
//        userService.delete(id);
//        map.addAttribute("users", userService.getUsers());
//
//        return "redirect:/admin";
//    }

//    @GetMapping("/admin/update")
//    public String getUpdate(Long userId, ModelMap map) {
//        User user = userService.getUserById(userId);
//        map.addAttribute("userUpdated", user);
//        map.addAttribute("roles", roleService.getAllRoles());
//        return "update";
//    }

//    @PostMapping("/admin/update")
//    public String postUpdate(Long id, String... roleList) {
////        userService.updateUser(id, roleList);
//        return "redirect:/admin";
//    }
}