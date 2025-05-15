package com.example.projetoapi.repository;

import com.example.projetoapi.model.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstudanteRepository extends JpaRepository<Estudante, Integer> {
    Optional<Estudante> findByEmail(String email);
}
