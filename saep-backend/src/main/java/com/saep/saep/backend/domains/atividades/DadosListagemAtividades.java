package com.saep.saep.backend.domains.atividades;


import com.saep.saep.backend.domains.turma.Turma;

public record DadosListagemAtividades(

        Long id,
        String nome,
        Turma turma

) {

    public DadosListagemAtividades(Atividade atividade){
        this(atividade.getId(), atividade.getNome(), atividade.getTurma());
    }

}
