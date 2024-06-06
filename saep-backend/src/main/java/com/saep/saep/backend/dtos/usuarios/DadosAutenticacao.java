package com.saep.saep.backend.dtos.usuarios;

import java.security.SecureRandom;

public record DadosAutenticacao(
        String nome,
        String login,
        String senha
) {
}
