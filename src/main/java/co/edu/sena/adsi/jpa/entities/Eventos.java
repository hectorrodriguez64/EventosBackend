/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "eventos")
public class Eventos implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "lugar")
    private String lugar;
    @Column(name = "fecha_A")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaA;
    @Column(name = "fecha_B")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaB;
    @JoinColumn(name = "id_asistencias", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Asistencias idAsistencias;
    @JoinColumn(name = "id_usuarios", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Usuarios idUsuarios;
    
    public Eventos() {
    }

    public Eventos(Integer id) {
        this.id = id;
    }

    public Eventos(Integer id, String lugar) {
        this.id = id;
        this.lugar = lugar;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Date getFechaA() {
        return fechaA;
    }

    public void setFechaA(Date fechaA) {
        this.fechaA = fechaA;
    }

    public Date getFechaB() {
        return fechaB;
    }

    public void setFechaB(Date fechaB) {
        this.fechaB = fechaB;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    public Asistencias getIdAsistencias() {
        return idAsistencias;
    }

    public void setIdAsistencias(Asistencias idAsistencias) {
        this.idAsistencias = idAsistencias;
    }

    public Usuarios getIdUsuarios() {
        return idUsuarios;
    }

    public void setIdUsuarios(Usuarios idUsuarios) {
        this.idUsuarios = idUsuarios;
    }

    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Eventos[ id=" + id + " ]";
    }
    
}
