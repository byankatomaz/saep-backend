package com.saep.saep.backend.domain.turma;

import com.saep.saep.backend.domains.turma.Turma;

public record DadosListagemTurmas(

        Long id,
        String nome

    ) {

    public DadosListagemTurmas(Turma turma) {
        this(turma.getId(), turma.getNome());
    }

}
