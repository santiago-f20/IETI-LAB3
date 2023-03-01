package edu.eci.ieti.lab3.persistence.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import org.springframework.stereotype.Component;

import edu.eci.ieti.lab3.model.User;
import edu.eci.ieti.lab3.persistence.UserPersistence;

@Component
public class UserPersistenceImpl implements UserPersistence {

    private final Map<Integer, User> usuarios = new HashMap<>();

    public UserPersistenceImpl() {

        List<String> nombres = List.of("Michael", "David", "Daniel", "John", "James", "Robert", "Joseph", "William",
                "Richard", "Thomas");
        List<String> apellidos = List.of("Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson",
                "Moore", "Taylor");

        for (int i = 0; i < 10; i++) {
            User usuario = new User(i, nombres.get(i), apellidos.get(i),
                    nombres.get(i).toLowerCase() + "@gmail.com", "123456");
            usuarios.put(i, usuario);
        }
    }

    public boolean existsById(int id) {
        return usuarios.containsKey(id);
    }

    public List<User> findAll() {
        return List.copyOf(usuarios.values());
    }

    public void save(User usuario) {
        if (usuarios.containsKey(usuario.getId())) {
            usuario.setId(usuarios.size());
        }
        usuarios.put(usuario.getId(), usuario);
    }

    public User findById(int id) {
        return usuarios.get(id);
    }

    public void update(int id, User usuario) {
        User temp = findById(id);
        temp.setId(usuario.getId());
        temp.setNombre(usuario.getNombre());
        temp.setApellido(usuario.getApellido());
        temp.setEmail(usuario.getEmail());
        temp.setPassword(usuario.getPassword());

        usuarios.replace(usuario.getId(), temp);

    }

    public void delete(int id) {
        usuarios.remove(id);
    }

}
