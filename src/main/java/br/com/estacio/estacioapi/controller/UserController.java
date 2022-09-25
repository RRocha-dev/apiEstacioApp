package br.com.estacio.estacioapi.controller;

import br.com.estacio.estacioapi.entity.UserEntity;
import br.com.estacio.estacioapi.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Entity;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user/")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder encoder;

    public UserController(UserService userService, PasswordEncoder encoder) {
        this.userService = userService;
        this.encoder = encoder;
    }

    @GetMapping("findAll")
    public ResponseEntity<List<UserEntity>> findAll() {
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping("save")
    public ResponseEntity<UserEntity> save(@RequestBody UserEntity user) {
        user.setUserPassword(encoder.encode(user.getUserPassword()));
        return ResponseEntity.ok(userService.save(user));
    }

    @GetMapping("validatePassword")
    public ResponseEntity<String> validatePassword(@RequestParam String userEmail,
                                                   @RequestParam String userPassword) {

        Optional<UserEntity> optUser = userService.findByEmail(userEmail);
        if (!optUser.isPresent()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuario invalido!");
        }
        if (!encoder.matches(userPassword, optUser.get().getUserPassword())){
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Senha invalida!");
        }
        return ResponseEntity.ok("Ola novamente ".concat(optUser.get().getUserName()));
    }
}
