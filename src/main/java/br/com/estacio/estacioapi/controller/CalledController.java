package br.com.estacio.estacioapi.controller;

import br.com.estacio.estacioapi.entity.CalledEntity;
import br.com.estacio.estacioapi.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/called")
public class CalledController {
    @Autowired
    private CalledService calledService;

    @GetMapping("/findAllByStatus")
    public ResponseEntity<?> findAll(@RequestParam(name = "status") String status) {
        List<CalledEntity> entityList = calledService.findAllByStatus(status.toUpperCase());
        if (entityList != null && !entityList.isEmpty()) {
            return ResponseEntity.ok(entityList);
        }
        return ResponseEntity.ok().body("Nenhum chamado cadastrado até o momento!");
    }

    @PostMapping("/save/")
    @Transactional
    public ResponseEntity<?> save(@RequestBody CalledEntity entity) {
        try {
            if (entity != null) {
                calledService.save(entity);
                return ResponseEntity.ok().body("Chamado cadastrado com sucesso!");
            } else {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Corpo da requisição não preenchido!");
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
