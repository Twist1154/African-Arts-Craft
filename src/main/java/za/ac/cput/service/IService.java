package za.ac.cput.service;

import java.util.List;

/**
 * IService.java
 *
 * A generic interface for basic CRUD operations.
 *
 * @param <T>  the type of entity
 * @param <ID> the type of the entity's identifier
 *
 * @author Rethabile Ntsekhe
 * Student Num: 220455430
 * @date 24-Jul-24
 */

public interface IService<T, ID> {
    /**
     * Create a new entity.
     *
     * @param t the entity to create
     * @return the created entity
     */
    T create(T t);

    /**
     * Read an entity by its identifier.
     *
     * @param id the identifier of the entity to read
     * @return the entity if found, otherwise null
     */
    T read(ID id);

    /**
     * Update an existing entity.
     *
     * @param t the entity to update
     * @return the updated entity
     */
    T update(T t);

    /**
     * Find all entities.
     *
     * @return a list of all entities
     */
    List<T> findAll();
}
