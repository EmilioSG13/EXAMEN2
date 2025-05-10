package com.examen2upiizenvios.enviosexamen2.entity;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "envios")
public class    Envio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String destinatario;

    @Column(nullable = false, length = 200)
    private String direccion;

    @Column(name = "fecha_envio", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date fechaEnvio;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Estatus estatus;

    // Enumeración para el estatus
    public enum Estatus {
        // Usa exactamente los mismos valores que tienes en la base de datos
        pendiente("pendiente"),
        en_transito("en tránsito"),
        entregado("entregado");

        private final String descripcion;

        Estatus(String descripcion) {
            this.descripcion = descripcion;
        }

        public String getDescripcion() {
            return descripcion;
        }

        // Metodo para convertir desde String
        public static Estatus fromString(String text) {
            for (Estatus e : Estatus.values()) {
                if (e.name().equalsIgnoreCase(text) || e.descripcion.equalsIgnoreCase(text)) {
                    return e;
                }
            }
            throw new IllegalArgumentException("No se encontró el estatus: " + text);
        }
    }

    // Constructores, getters y setters
    public Envio() {}

    public Envio(String destinatario, String direccion, Date fechaEnvio, Estatus estatus) {
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.fechaEnvio = fechaEnvio;
        this.estatus = estatus;
    }

    // Getters y Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Date fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public Estatus getEstatus() {
        return estatus;
    }

    public void setEstatus(Estatus estatus) {
        this.estatus = estatus;
    }
}