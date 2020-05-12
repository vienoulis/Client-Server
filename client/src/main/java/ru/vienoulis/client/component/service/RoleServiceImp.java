package ru.vienoulis.client.component.service;

import org.springframework.stereotype.Component;
import ru.vienoulis.client.component.controller.RestController;
import ru.vienoulis.client.component.model.Role;
import ru.vienoulis.client.component.service.inter.RoleService;

import java.util.List;

@Component
public class RoleServiceImp implements RoleService {

    private final RestController restController;

    public RoleServiceImp(RestController restController) {
        this.restController = restController;
    }

    @Override
    public Role getRoleByName(String role) {
        return restController.getRoleByName(role);
    }

    @Override
    public List<Role> getAllRoles() {
        return restController.getAllRoles();
    }
}
