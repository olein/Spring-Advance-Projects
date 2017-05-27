/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jonak.dao;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Md Mahfuj Jia
 * @param <T>
 * @param <PK>
 */
public interface GenericDao<T, PK extends Serializable> {

    PK create(T o);

    T read(PK id);

    List<T> loadAll();

    void update(T o);

    void delete(T o);

    void createOrUpdate(T o);
}
