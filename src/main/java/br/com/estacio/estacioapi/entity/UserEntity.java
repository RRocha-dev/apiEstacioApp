package br.com.estacio.estacioapi.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;

    @JsonIgnore
    @OneToMany(mappedBy = "userEntity")
    private List<CalledEntity> calledEntityList;
}
