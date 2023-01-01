package com.exchangerater.persistence.daos.base;

import com.exchangerater.persistence.entities.base.BaseEntity;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDao<T extends BaseEntity> {

    private Class<T> typeParamerterClass;

    @PostConstruct
    private void onInit() {
        this.typeParamerterClass = initTypeParamerterClass();
    }

    protected abstract Class<T> initTypeParamerterClass();

    @PersistenceContext(unitName = "exhcangeratePersistenceUnit")
    protected EntityManager entityManager;

    /**
     * This function fetches an entity of class T by id-
     *
     * @param id - Long, the id of the entity
     * @return the found entity if exists, null if the id is null and null if no entity exist with the given id
     */
    public T findById(Long id) {
        if (id == null) {
            return null;
        }
        return entityManager.find(typeParamerterClass, id);
    }

    /**
     * This method allows type safe entity persistence.
     *
     * @param entity - JPA entity with the type of the type parameter of this BaseDao class
     */
    public void persist(T entity) {
       entityManager.persist(entity);
    }

    /**
     * This method allows type safe entity removal.
     *
     * @param entity - JPA entity with the type of the type parameter of this BaseDao class
     */
    public void remove(T entity) {
        entityManager.remove(entity);
    }


    /**
     * This method allows type safe entity detaching from the persistence context.
     *
     * @param entity - JPA entity with the type of the type parameter of this BaseDao class
     */
    public void detach(T entity) {
        entityManager.detach(entity);
    }
}
