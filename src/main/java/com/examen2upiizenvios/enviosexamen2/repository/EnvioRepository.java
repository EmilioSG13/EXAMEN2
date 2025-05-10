package com.examen2upiizenvios.enviosexamen2.repository;



import com.examen2upiizenvios.enviosexamen2.entity.Envio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnvioRepository extends JpaRepository<Envio, Long> {
}