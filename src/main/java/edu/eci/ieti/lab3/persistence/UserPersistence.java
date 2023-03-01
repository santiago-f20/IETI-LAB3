package edu.eci.ieti.lab3.persistence;

import java.util.List;

import edu.eci.ieti.lab3.model.User;

public interface UserPersistence {

    public List<User> findAll();

    public boolean existsById(int id);

    public void save(User usuario);

    public User findById(int id);

    public void update(int id, User usuario);

    public void delete(int id);

}
