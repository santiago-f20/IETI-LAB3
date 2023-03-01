package edu.eci.ieti.lab3.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.eci.ieti.lab3.model.User;
import edu.eci.ieti.lab3.service.UserService;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService usuarioService;

    @GetMapping("/user")
    public ResponseEntity<List<User>> getUsuarios() {
        return new ResponseEntity<List<User>>(usuarioService.findAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<?> getUsuario(@PathVariable("id") int id) {
        if (!usuarioService.existsById(id)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<User>(usuarioService.findById(id), HttpStatus.ACCEPTED);
    }

    @PostMapping("/addUsuario")
    public ResponseEntity<?> addUsuario(User user) {
        try {
            usuarioService.save(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
        }
    }

    @PutMapping("/updateUsuario/{id}")
    public ResponseEntity<?> updateUsuario(@PathVariable("id") int id, User user) {
        if (usuarioService.existsById(id)) {
            try {
                usuarioService.update(id, user);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteUsuario/{id}")
    public ResponseEntity<?> deleteUsuario(@PathVariable("id") int id) {
        if (usuarioService.existsById(id)) {
            try {
                usuarioService.delete(id);
                return new ResponseEntity<>(HttpStatus.ACCEPTED);
            } catch (Exception e) {
                return new ResponseEntity<>(HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
