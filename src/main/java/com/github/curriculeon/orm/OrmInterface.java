package com.github.curriculeon.orm;

import com.github.curriculeon.model.EntityInterface;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public interface OrmInterface<EntityType extends EntityInterface> {
    ResultSet getResultSet();
    List<EntityType> toList();
}
