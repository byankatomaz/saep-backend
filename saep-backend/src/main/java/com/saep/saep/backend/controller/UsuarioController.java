package com.saep.saep.backend.controller;



import com.saep.saep.backend.domain.usuario.Usuario;
import com.saep.saep.backend.domain.usuario.UsuarioRepository;
import com.saep.saep.backend.dtos.usuarios.DadosAutenticacao;
import com.saep.saep.backend.dtos.usuarios.DadosDetalhamentoCadastro;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/cadastro")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosAutenticacao dados, UriComponentsBuilder uriBuilder){
        var usuario = new Usuario(dados);

        String senhaCript = passwordEncoder.encode(dados.senha());

        usuario.setSenha(senhaCript);

        repository.save(usuario);

        var uri = uriBuilder.path("/cadastro/{id}").buildAndExpand(usuario.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoCadastro(usuario));
    }


}
