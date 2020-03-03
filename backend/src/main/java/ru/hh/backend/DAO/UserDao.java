package ru.hh.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hh.backend.Entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class UserDao {
    private final SessionFactory sessionFactory;

    public UserDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(User user) {
        session().persist(user);
    }

    @Transactional
    public Optional<User> get(int id) {
        return Optional.ofNullable(session().get(User.class, id));
    }

    @Transactional
    public List<User> getByType(String type){
        return session().createQuery("SELECT u from User u WHERE u.type = :type", User.class)
                .setParameter("type", type)
                .getResultList();
    }

}
