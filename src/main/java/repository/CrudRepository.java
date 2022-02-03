package repository;

import java.sql.SQLException;
import java.util.List;

public interface CrudRepository<T, ID> {

    List<T> findAll() throws SQLException;

    T getById(ID id) throws SQLException;

    T save(T t) throws SQLException;

    T update(T t) throws SQLException;

    T delete(T t) throws SQLException;

}