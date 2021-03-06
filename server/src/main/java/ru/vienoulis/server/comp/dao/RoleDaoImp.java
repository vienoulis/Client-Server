package ru.vienoulis.server.comp.dao;

import org.springframework.stereotype.Repository;
import ru.vienoulis.server.comp.dao.interfaces.RoleDao;
import ru.vienoulis.server.comp.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class RoleDaoImp implements RoleDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Role getRoleByName(String role) {
        Role role1 = (Role) entityManager.createQuery("from Role where role= :rl")
                .setParameter("rl", role).getSingleResult();
        return role1;
    }

    @Override
    public List<Role> getAllRoles() {
        return entityManager.createQuery(" from Role ").getResultList();
    }
}
