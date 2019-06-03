package ru.kravchenko.deltaspike.cdi;

import com.sun.istack.internal.NotNull;
import org.apache.deltaspike.jpa.api.entitymanager.PersistenceUnitName;
import org.apache.deltaspike.jpa.api.transaction.TransactionScoped;

import javax.inject.Inject;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 * @author Roman Kravchenko
 */

public class ProducerCDI {

    private static final String UNIX_NAME = "ENTERPRISE";

    @Inject
    @PersistenceUnitName(UNIX_NAME)
    private EntityManagerFactory entityManagerFactory;

    @NotNull
    @Produces
    @TransactionScoped
    public EntityManager create() { return this.entityManagerFactory.createEntityManager(); }

    public void dispose(@Disposes EntityManager entityManager) { if (entityManager.isOpen()) entityManager.close(); }

}
