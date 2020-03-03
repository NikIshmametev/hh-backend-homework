package ru.hh.backend.DAO;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import ru.hh.backend.Entity.Resume;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public class ResumeDao {
    private final SessionFactory sessionFactory;

    public ResumeDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional
    public void save(Resume resume) {
        session().persist(resume);
    }

    @Transactional
    public Optional<Resume> get(int id) {
        return Optional.ofNullable(session().get(Resume.class, id));
    }

    @Transactional
    public List<Resume> getAll(){
        return session().createQuery("SELECT c FROM Resume c", Resume.class).getResultList();
    }
}
