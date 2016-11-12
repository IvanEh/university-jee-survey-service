package com.gmail.at.ivanehreshi.jee.vacancy.persistence;

import java.io.Serializable;
import java.util.List;

/**
 * Dao interface example from
 * https://www.ibm.com/developerworks/ru/library/j-genericdao/
 */
public interface Dao<T, PK> extends Serializable {
    PK create(T t);
    T read(PK id);
    void update(T t);
    void delete(PK id);
    List<T> findAll();
}
