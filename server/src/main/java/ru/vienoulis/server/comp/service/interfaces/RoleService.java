package ru.vienoulis.server.comp.service.interfaces;


import ru.vienoulis.server.comp.model.Role;

import java.util.List;

public interface RoleService {

    Role getRoleByName(String role_admin);

    List<Role> getAllRoles();
}
