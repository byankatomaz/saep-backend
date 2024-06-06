package com.saep.saep.backend.controller;

import com.saep.saep.backend.domains.atividades.Atividade;
import com.saep.saep.backend.domains.atividades.AtividadeRepository;
import com.saep.saep.backend.domains.atividades.DadosCadastroAtividade;
import com.saep.saep.backend.domains.atividades.DadosDetalhamentoAtividade;
import com.saep.saep.backend.domains.turma.Turma;
import com.saep.saep.backend.domains.turma.TurmaRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/atividades")
@SecurityRequirement(name = "bearer-key")
public class AtividadeController {

    @Autowired
    private AtividadeRepository repository;

    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastroAtividade(@RequestBody @Valid DadosCadastroAtividade dados, UriComponentsBuilder uriBuilder){
        var paciente = new Atividade(dados);
        repository.save(paciente);

        var uri = uriBuilder.path("/atividades/{id}").buildAndExpand(paciente.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAtividade(paciente));
    }

    @GetMapping("/turma/{turmaId}")
    public ResponseEntity<List<Atividade>> listarAtividadesPorTurma(@PathVariable Long turmaId) {
        Turma turma = turmaRepository.findById(turmaId)
                .orElseThrow(() -> new RuntimeException("Turma não encontrada com o ID: " + turmaId));

        List<Atividade> atividades = repository.findByTurma(turma);
        return ResponseEntity.ok(atividades);
    }


}
