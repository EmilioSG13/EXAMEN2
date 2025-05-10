package com.examen2upiizenvios.enviosexamen2.service;



import com.examen2upiizenvios.enviosexamen2.entity.Envio;
import com.examen2upiizenvios.enviosexamen2.repository.EnvioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnvioService {
    private final EnvioRepository envioRepository;

    @Autowired
    public EnvioService(EnvioRepository envioRepository) {
        this.envioRepository = envioRepository;
    }

    public List<Envio> obtenerTodosLosEnvios() {
        return envioRepository.findAll();
    }

    public Envio guardarEnvio(Envio envio) {
        return envioRepository.save(envio);
    }

    public Envio obtenerEnvioPorId(Long id) {
        return envioRepository.findById(id).orElse(null);
    }

    public void eliminarEnvio(Long id) {
        envioRepository.deleteById(id);
    }
}