package com.example.BancoMalvaderWeb.Model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "usuario")
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class UsuarioModel {
    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nome;

    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cpf;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

    @Column(unique = true)
    private String telefone;

    @OneToMany(mappedBy = "usuario")
    private List<EnderecoModel> endereco;

    @CreationTimestamp
    @Column(name = "data_criacao")
    private LocalDate dataCriacao;

    @UpdateTimestamp
    @Column(name = "data_edicao")
    private LocalDate dataEdicao;

}
