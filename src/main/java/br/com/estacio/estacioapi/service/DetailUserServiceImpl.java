package br.com.estacio.estacioapi.service;

import br.com.estacio.estacioapi.data.DetailUserData;
import br.com.estacio.estacioapi.entity.UserEntity;
import br.com.estacio.estacioapi.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DetailUserServiceImpl implements UserDetailsService {

    private final UserRepository repository;

    public DetailUserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> optUser = repository.findByUserEmail(username);
        if (optUser.isEmpty()){
            throw new UsernameNotFoundException("Email nao foi encontrado no nosso banco de dados!");
        }
        return new DetailUserData(optUser);
    }
}
