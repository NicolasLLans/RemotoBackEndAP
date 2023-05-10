package com.ap.argprogram.modelos;

import jakarta.persistence.*;

@Entity
@Table(name = "Skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;

    private String descripcion;
    private String img;
    private int porcentaje;


    public Skill() {
    }

    public Skill(Long id, String titulo, String descripcion, String img, int porcentaje) {
        this.id = id;
        this.titulo = titulo;
        this.porcentaje = porcentaje;
        this.descripcion = descripcion;
        this.img = img;
    }

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

}
