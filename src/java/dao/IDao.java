/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;

/**
 *
 * @author root
 */
public interface IDao<T> {
    boolean create(T t);
    boolean update(T t);
    boolean delete(T t);
    T findById(int id);
    List<T> findAll();
}
