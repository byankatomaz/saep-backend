package com.saep.saep.backend.domains.atividades;


import com.saep.saep.backend.domains.turma.Turma;

public record DadosCadastroAtividade(
        String nome,
        Turma turma

) {
}
