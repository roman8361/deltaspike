package ru.kravchenko.deltaspike.dao;

import org.apache.deltaspike.jpa.api.transaction.Transactional;
import ru.kravchenko.deltaspike.entity.Cat;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Roman Kravchenko
 */

@Transactional
@ApplicationScoped
public class CatDAO {

    @Inject
    private EntityManager em;

    public void persist(final Cat cat) {
        em.persist(cat);
    }

    public List<Cat> findAll() {return em.createQuery("SELECT e FROM Cat e", Cat.class).getResultList(); }

    public Cat findById(final String id) { return em.find(Cat.class, id); }

    public void removeById(final String id) {
        final Cat cat = em.find(Cat.class, id);
        em.remove(cat);
    }

}
