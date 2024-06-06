package com.saep.saep.backend.domains.atividades;


import com.saep.saep.backend.domains.turma.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AtividadeRepository extends JpaRepository<Atividade, Long> {
    List<Atividade> findByTurma(Turma turma);
}
