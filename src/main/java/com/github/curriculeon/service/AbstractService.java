package com.github.curriculeon.service;

import com.github.curriculeon.dao.RepositoryInterface;
import com.github.curriculeon.model.EntityInterface;

import java.io.Serializable;

/**
 * Created by leon on 8/14/2020.
 */
public class AbstractService<
        IdType extends Serializable,
        EntityType extends EntityInterface<IdType>,
        RepositoryType extends RepositoryInterface<IdType, EntityType>>
        implements ServiceInterface<IdType, EntityType, RepositoryType> {
    private RepositoryType repository;

    public AbstractService(RepositoryType repository) {
        this.repository = repository;
    }

    @Override
    public RepositoryType getRepository() {
        return repository;
    }
}
