package ru.vienoulis.server.comp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.vienoulis.server.comp.dao.interfaces.RoleDao;
import ru.vienoulis.server.comp.model.Role;
import ru.vienoulis.server.comp.service.interfaces.RoleService;

import java.util.List;

@Service
public class RoleServiceImp implements RoleService {

    @Autowired
    private RoleDao dao;

    @Override
    @Transactional
    public Role getRoleByName(String role) {
        return dao.getRoleByName(role);
    }

    @Override
    @Transactional
    public List<Role> getAllRoles() {
        return dao.getAllRoles();
    }
}
