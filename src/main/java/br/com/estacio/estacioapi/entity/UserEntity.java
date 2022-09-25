package br.com.estacio.estacioapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_user", schema = "estacio")
public class UserEntity {
    @Id
    private Integer userId;
    private String userName;
    private String userEmail;
    @JsonIgnore
    private String userPassword;
}
