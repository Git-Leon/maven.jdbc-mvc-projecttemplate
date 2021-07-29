package com.github.curriculeon.dao;

import com.github.curriculeon.DatabaseConnection;
import com.github.curriculeon.DatabaseConnectionInterface;
import com.github.curriculeon.model.EntityInterface;

import java.io.Serializable;
import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public abstract class AbstractRepository<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>>
        implements RepositoryInterface<IdType, EntityType> {

    private DatabaseConnectionInterface databaseConnection;

    public AbstractRepository(DatabaseConnectionInterface databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public AbstractRepository() {
        this(DatabaseConnection.PRODUCTION_DATABASE);
    }

    @Override
    public DatabaseConnectionInterface getDatabaseConnection() {
        return this.databaseConnection;
    }

    /**
     * // TODO - 1. fetch all of the respective entity type from the database as `ResultSet`
     * // TODO - 2. convert from `ResultSet` to `List<Entity>`
     *
     * @return
     */
    @Override
    abstract public List<EntityType> findAll();

    @Override
    abstract public EntityType update(EntityType existingEntity, EntityType newData);

    @Override // TODO - Persist data from current JVM instance to database
    abstract public void commit();
}
