package com.github.curriculeon.model;

import java.io.Serializable;

/**
 * Created by leon on 8/14/2020.
 */
public interface EntityInterface<IdType extends Serializable> {
    IdType getId();
}
