//package com.saep.saep.backend.services;
//
//import com.saep.saep.backend.dtos.usuarios.DadosAutenticacao;
//import com.saep.saep.backend.dtos.usuarios.DadosDetalhamentoCadastro;
//import com.saep.saep.backend.models.Usuario;
//import com.saep.saep.backend.infra.security.TokenService;
//import com.saep.saep.backend.repositories.UsuarioRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class AuthService {
//
//    @Autowired
//    private AuthenticationManager manager;
//
//    @Autowired
//    private TokenService tokenService;
//
//    @Autowired
//    private UsuarioRepository repository;
//
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//    public TokenJWTDto login(DadosAutenticacao dados){
//        var authenticationToken = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
//        var authentication = manager.authenticate(authenticationToken);
//        var tokenJWT = tokenService.gerarToken((Usuario) authentication.getPrincipal());
//
//        return new TokenJWTDto(tokenJWT);
//    }
//
//    public DadosDetalhamentoCadastro register(DadosAutenticacao dados){
//        var usuario = new Usuario(dados);
//        String senhaCript = passwordEncoder.encode(dados.senha());
//        usuario.setSenha(senhaCript);
//        repository.save(usuario);
//        return new DadosDetalhamentoCadastro(usuario);
//    }
//
//}
