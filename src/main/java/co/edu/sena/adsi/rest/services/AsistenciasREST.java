/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Asistencias;
import co.edu.sena.adsi.jpa.sessions.AsistenciasFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("asistencias")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AsistenciasREST {
    
    @EJB
    private AsistenciasFacade asistenciasEJB;
    
    /**
     * Obtiene todas las tipos de documentos
     * @return lista de tipos de documentos
     */
    @GET
    public List<Asistencias> findAll(){
        return asistenciasEJB.findAll();
    }
    

    @GET
    @Path("{id}")
    public Asistencias findById(@PathParam("id") Integer id){
        return asistenciasEJB.find(id);
    }
    
    /**
     * Crear una asistencia
     * @param Asistencias
     */
    @POST
    public void create(Asistencias Asistencias){
        asistenciasEJB.create(Asistencias);
    }
    
    /**
     * Edita un tipoDocumento
     * @param id
     * @param Asistencias
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, Asistencias Asistencias){
        asistenciasEJB.edit(Asistencias);
    }
    
    
    
}
