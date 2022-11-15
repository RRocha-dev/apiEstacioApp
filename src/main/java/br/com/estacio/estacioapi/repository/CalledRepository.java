package br.com.estacio.estacioapi.repository;

import br.com.estacio.estacioapi.entity.CalledEntity;
import br.com.estacio.estacioapi.service.CalledService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CalledRepository extends JpaRepository<CalledEntity, Integer> {
    List<CalledEntity> findAllByUserEntityUserId(Integer Id);

    List<CalledEntity> findAllByCalledStatus(String status);
}
