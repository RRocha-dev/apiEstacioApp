package br.com.estacio.estacioapi.service;

import br.com.estacio.estacioapi.entity.UserEntity;
import br.com.estacio.estacioapi.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    UserRepository repository;

    public Optional<UserEntity> findByEmail(String email) {
        return repository.findByUserEmail(email);
    }

    public List<UserEntity> findAll() {
        return repository.findAll();
    }

    public UserEntity save(UserEntity user) {
        return repository.save(user);
    }
}
