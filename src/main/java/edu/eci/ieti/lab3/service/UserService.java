package edu.eci.ieti.lab3.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.eci.ieti.lab3.model.User;
import edu.eci.ieti.lab3.persistence.UserPersistence;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserPersistence usuarioPersistence;

    public boolean existsById(int id) {
        return usuarioPersistence.existsById(id);
    }

    public List<User> findAll() {
        return usuarioPersistence.findAll();
    }

    public void save(User usuario) {
        usuarioPersistence.save(usuario);
    }

    public User findById(int id) {
        return usuarioPersistence.findById(id);
    }

    public void update(int id, User usuario) {
        usuarioPersistence.update(id, usuario);
    }

    public void delete(int id) {
        usuarioPersistence.delete(id);
    }

}
