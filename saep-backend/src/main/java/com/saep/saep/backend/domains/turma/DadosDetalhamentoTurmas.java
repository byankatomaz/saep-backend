package com.saep.saep.backend.domains.turma;


import com.saep.saep.backend.domain.usuario.Usuario;

public record DadosDetalhamentoTurmas (
        Long id,
        String nome,
        String professor
) {

    public DadosDetalhamentoTurmas(Turma turma){
        this(turma.getId(), turma.getNome(), turma.getProfessor().getLogin());
    }

}
