package com.gmail.sanfrancisco.jpa;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;

@ApplicationScoped
public class PersistenceCfg {
    @PersistenceUnit
    private EntityManagerFactory entityManagerFactory;

    @Produces
    @Default
    //@RequestScoped
    //@SessionScoped
    @ApplicationScoped
    public EntityManager create() {
        return this.entityManagerFactory.createEntityManager();
    }

    @PostConstruct
    private void init() {
        entityManagerFactory.getMetamodel();
    }

    public void dispose(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }
}