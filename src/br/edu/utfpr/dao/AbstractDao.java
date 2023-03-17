/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.utfpr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public interface AbstractDao<T> {

    public T insert(T obj);

    public T update(T obj);

    public Connection getConn();

    public boolean delete(int codigo);

    public T findById(int codigo);

    public List<T> findAll();

    public T mount(ResultSet res);

    public List<T> mountList(ResultSet res);
}