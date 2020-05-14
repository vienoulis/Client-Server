package ru.vienoulis.server.comp.dao;


import org.springframework.stereotype.Repository;
import ru.vienoulis.server.comp.dao.interfaces.UserDao;
import ru.vienoulis.server.comp.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("from User ").getResultList();
    }

    @Override
    public void update(User user) {
        entityManager.merge(user);
    }

    @Override
    public void addUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void delete(long userId) {
        entityManager.createQuery("delete from User where id = :id")
                .setParameter("id", userId).executeUpdate();
    }

    @Override
    public User getUserById(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public User getUserByName(String name) {
        User user = (User) entityManager.createQuery("from User user where name = :nm")
                .setParameter("nm", name)
                .getSingleResult();
        return user;
    }

}
