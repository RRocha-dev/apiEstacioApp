package br.com.estacio.estacioapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_called", schema = "estacio")
public class CalledEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer calledId;
    private String calledCreatedDescription;
    private String calledSoluction;
    private Date calledDtCreated;
    private Date calledDtFinally;
    private String calledStatus;
    @ManyToOne
    @JoinColumn(name = "user_entity")
    private UserEntity userEntity;
}
