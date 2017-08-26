/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.jpa.entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author adsi1261718
 */
@Entity
@Table(name = "asistencias")
public class Asistencias implements Serializable {

    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "reporte")
    private String reporte;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nivel")
    private String nivel;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAsistencias")
    private List<Eventos> eventosList;

    public Asistencias() {
    }

    public Asistencias(Integer id) {
        this.id = id;
    }

    public Asistencias(Integer id, String reporte, String nivel) {
        this.id = id;
        this.reporte = reporte;
        this.nivel = nivel;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReporte() {
        return reporte;
    }

    public void setReporte(String reporte) {
        this.reporte = reporte;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    @XmlTransient
    public List<Eventos> getEventosList() {
        return eventosList;
    }

    public void setEventosList(List<Eventos> eventosList) {
        this.eventosList = eventosList;
    }


    @Override
    public String toString() {
        return "co.edu.sena.adsi.jpa.entities.Asistencias[ id=" + id + " ]";
    }
    
}
