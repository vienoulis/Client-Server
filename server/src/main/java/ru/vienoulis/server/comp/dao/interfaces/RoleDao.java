package ru.vienoulis.server.comp.dao.interfaces;

import ru.vienoulis.server.comp.model.Role;

import java.util.List;

public interface RoleDao {

    Role getRoleByName(String s);

    List<Role> getAllRoles();

}
