package com.saep.saep.backend.domains.atividades;

import com.saep.saep.backend.domains.turma.Turma;

public record DadosDetalhamentoAtividade(

        Long id,
        String nome,
        Turma turma

) {
    public DadosDetalhamentoAtividade(Atividade atividade){
        this(atividade.getId(), atividade.getNome(), atividade.getTurma());
    }
}
