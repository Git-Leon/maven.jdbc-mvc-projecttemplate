package com.github.curriculeon.dto;

import com.github.curriculeon.model.EntityInterface;

import java.sql.ResultSet;
import java.util.List;

/**
 * Created by leon on 8/14/2020.
 */
public interface DtoInterface<EntityType extends EntityInterface> {
    ResultSet getResultSet();
    List<EntityType> toList();
}
