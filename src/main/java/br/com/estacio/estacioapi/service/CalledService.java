package br.com.estacio.estacioapi.service;

import br.com.estacio.estacioapi.entity.CalledEntity;
import br.com.estacio.estacioapi.repository.CalledRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CalledService {
    @Autowired
    CalledRepository repository;


    public List<CalledEntity> getAllByUser(Integer user) {
        return repository.findAllByUserEntityUserId(user);
    }

    public void save(CalledEntity entity) {
        repository.save(entity);
    }

    public List<CalledEntity> getAll() {
        return repository.findAll();
    }

    public List<CalledEntity> findAllByStatus(String status) {
        return repository.findAllByCalledStatus(status);
    }
}
