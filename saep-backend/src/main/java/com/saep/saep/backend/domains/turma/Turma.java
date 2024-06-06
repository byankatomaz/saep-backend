package com.saep.saep.backend.domains.turma;


import com.saep.saep.backend.domain.usuario.Usuario;
import com.saep.saep.backend.domains.atividades.Atividade;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Optional;

@Table(name="turmas")
@Entity(name="Turma")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Turma {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_professor", referencedColumnName = "id")
    private Usuario professor;

    @OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Atividade> atividades;


    public Turma(DadosCadastroTurma dados, Usuario user) {
        this.nome = dados.nome();
        this.professor = user;
    }
}
