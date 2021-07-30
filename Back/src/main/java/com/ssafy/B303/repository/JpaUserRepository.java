package com.ssafy.B303.repository;

import com.ssafy.B303.domain.User;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Optional;

public class JpaUserRepository implements UserRepository {
    private final EntityManager em;

    public JpaUserRepository(EntityManager em){
        this.em = em;
    }

    public User save(User user) {
        em.persist(user);
        return user;
    }


    //public Optional<User> findByUser_id(int user_id) {
    //    User user = em.find(User.class, user_id);
    //    return Optional.ofNullable(user);
    //}

    @Override
    public Optional<User> findByLogin_id(String login_id) {
        List<User> result = em.createQuery("select u from User u where u.login_id = :login_id",
                User.class)
                .setParameter("login_id", login_id)
                .getResultList();
        return result.stream().findAny();
    }

    public List<User> findAll() {
        return em.createQuery("select u from User u", User.class)
                .getResultList();
    }
}
