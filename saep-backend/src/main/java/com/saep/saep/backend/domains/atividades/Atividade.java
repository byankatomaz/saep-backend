package com.saep.saep.backend.domains.atividades;

import com.saep.saep.backend.domains.turma.Turma;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="atividades")
@Entity(name="Atividade")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Atividade {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_turma", referencedColumnName = "id")
    private Turma turma;

    public Atividade(DadosCadastroAtividade dados) {
        this.nome = dados.nome();
        this.turma = dados.turma();
    }
}
