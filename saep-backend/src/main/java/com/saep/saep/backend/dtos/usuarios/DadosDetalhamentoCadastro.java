package com.saep.saep.backend.dtos.usuarios;

import com.saep.saep.backend.domain.usuario.Usuario;

public record DadosDetalhamentoCadastro(

        Long id,
        String login,
        String senha

) {
    public DadosDetalhamentoCadastro(Usuario usuario) {
        this(usuario.getId(), usuario.getLogin(), usuario.getSenha());
    }
}
