package sn.bouya.panierclient.Repository;

import java.util.List;

public interface IGenericDAO<T>{
    void save(T entite);
    void update(T entite);
    void delete(T entite);
    List<T> getAll();
}