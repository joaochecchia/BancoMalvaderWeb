package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "cliente")
@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
public class ClienteModel extends UsuarioModel{

    @OneToMany(mappedBy = "cliente")
    List<ContaModel> contas;
}

