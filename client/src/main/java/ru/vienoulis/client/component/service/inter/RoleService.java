package ru.vienoulis.client.component.service.inter;

import ru.vienoulis.client.component.model.Role;

import java.util.List;

public interface RoleService {
    Role getRoleByName(String role_admin);

    List<Role> getAllRoles();
}
