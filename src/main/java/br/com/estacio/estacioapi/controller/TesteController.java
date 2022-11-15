package br.com.estacio.estacioapi.controller;

import br.com.estacio.estacioapi.entity.CalledEntity;
import br.com.estacio.estacioapi.service.CalledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TesteController {
    @Autowired
    CalledService calledService;

    @GetMapping(name = "/teste")
    public ResponseEntity<?> teste() {
        List<CalledEntity> calledEntityList = calledService.getAll();
        return ResponseEntity.ok(calledEntityList);
    }
}
