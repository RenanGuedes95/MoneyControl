package br.edu.vianna.finance.dao;

import java.sql.SQLException;
import java.util.ArrayList;

public interface GenericsDAO<C, T> {
    public void insert(C object) throws ClassNotFoundException, SQLException;

    public void alter(C object) throws ClassNotFoundException, SQLException;

    public void delete(C object) throws ClassNotFoundException, SQLException;

    public C searchOne(T id) throws ClassNotFoundException, SQLException;

    public ArrayList<C> searchAll() throws ClassNotFoundException, SQLException;

    public int count() throws ClassNotFoundException, SQLException;
}
