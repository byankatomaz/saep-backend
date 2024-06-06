package com.saep.saep.backend.domains.turma;

import com.saep.saep.backend.domain.usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TurmaRepository extends JpaRepository<Turma, Long> {
    List<Turma> findAllByProfessor(Usuario professor);
}
