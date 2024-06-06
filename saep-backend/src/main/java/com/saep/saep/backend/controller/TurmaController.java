package com.saep.saep.backend.controller;

import com.saep.saep.backend.domain.usuario.Usuario;
import com.saep.saep.backend.domain.usuario.UsuarioRepository;
import com.saep.saep.backend.domains.turma.DadosCadastroTurma;
import com.saep.saep.backend.domains.turma.DadosDetalhamentoTurmas;
import com.saep.saep.backend.domains.turma.Turma;
import com.saep.saep.backend.domains.turma.TurmaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/turmas")
@SecurityRequirement(name = "bearer-key")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroTurma dados, UriComponentsBuilder uriBuilder){

        var user = usuarioRepository.findById(dados.professor());

        var turma = new Turma(dados, user.get());

        repository.save(turma);

        var uri = uriBuilder.path("/turmas/{id}").buildAndExpand(turma.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoTurmas(turma));
    }

    @GetMapping
    public ResponseEntity<List<Turma>> listar() {
        // Obtém o usuário autenticado
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Usuario username = (Usuario) authentication;
        List<Turma> turmas = repository.findAllByProfessor(username);

        return ResponseEntity.ok(turmas);
    }


    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id) {
        var turma = repository.getReferenceById(id);

        repository.delete(turma);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalhar(@PathVariable Long id) {
        var medico = repository.getReferenceById(id);

        return ResponseEntity.ok(new DadosDetalhamentoTurmas(medico));
    }
}
