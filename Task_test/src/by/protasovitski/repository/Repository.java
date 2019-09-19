package by.protasovitski.repository;

import by.protasovitski.exception.RepositoryException;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface Repository<T,V> extends Serializable {
    T save(T entity) throws RepositoryException;
    void remove(V id) throws RepositoryException;
    List<T> findAll() throws RepositoryException;
    Optional<T> findById(V id) throws RepositoryException;
}
