package com.saep.saep.backend.domain.usuario;

import java.security.SecureRandom;

public record DadosAutenticacao(
        String login,
        String senha
) {
}
