package ru.hh.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.hh.backend.Entity.Company;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class CompanyDao {
    private final SessionFactory sessionFactory;

    public CompanyDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(Company company) {
        session().persist(company);
    }

    @Transactional
    public Optional<Company> get(int id) {
        return Optional.ofNullable(session().get(Company.class, id));
    }

    @Transactional
    public List<Company> getAll(){
        return session().createQuery("SELECT c FROM Company c", Company.class).getResultList();
    }
}
