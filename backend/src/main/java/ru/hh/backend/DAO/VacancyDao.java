package ru.hh.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hh.backend.Entity.Vacancy;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class VacancyDao
{
    private final SessionFactory sessionFactory;

    public VacancyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(Vacancy vacancy) {
        session().persist(vacancy);
    }

    @Transactional
    public Optional<Vacancy> get(int id) {
        return Optional.ofNullable(session().get(Vacancy.class, id));
    }

    @Transactional
    public List<Vacancy> getAll(){
        return session().createQuery("SELECT c FROM Vacancy c", Vacancy.class).getResultList();
    }
}
