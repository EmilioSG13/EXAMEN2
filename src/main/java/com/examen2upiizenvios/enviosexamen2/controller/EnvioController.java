package com.examen2upiizenvios.enviosexamen2.controller;



import com.examen2upiizenvios.enviosexamen2.entity.Envio;
import com.examen2upiizenvios.enviosexamen2.service.EnvioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@Controller
@RequestMapping("/tabla")
public class EnvioController {
    private final EnvioService envioService;

    @Autowired
    public EnvioController(EnvioService envioService) {
        this.envioService = envioService;
    }

    @GetMapping
    public String listarEnvios(Model model) {
        model.addAttribute("envios", envioService.obtenerTodosLosEnvios());
        return "tabla";
    }

    @GetMapping("/nuevo")
    public String mostrarFormularioNuevo(Model model) {
        model.addAttribute("envio", new Envio());
        model.addAttribute("estatuses", Envio.Estatus.values());
        return "formulario";
    }

    @PostMapping("/guardar")
    public String guardarEnvio(@ModelAttribute("envio") Envio envio) {
        envioService.guardarEnvio(envio);
        return "redirect:/tabla";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable Long id, Model model) {
        model.addAttribute("envio", envioService.obtenerEnvioPorId(id));
        model.addAttribute("estatuses", Envio.Estatus.values());
        return "formulario";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarEnvio(@PathVariable Long id) {
        envioService.eliminarEnvio(id);
        return "redirect:/tabla";
    }
}