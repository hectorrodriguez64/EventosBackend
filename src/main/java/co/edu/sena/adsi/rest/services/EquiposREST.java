/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Equipos;
import co.edu.sena.adsi.jpa.entities.Rol;
import co.edu.sena.adsi.jpa.sessions.EquiposFacade;
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
@Path("equipos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EquiposREST {
        
    @EJB
    private EquiposFacade equiposEJB;
    
    @GET
    public List<Equipos> findAll() {
        return equiposEJB.findAll();
    }
    
    @GET
    @Path("{id}")
    public Equipos findById(@PathParam("id") String id){
        return equiposEJB.find(id);
    }
    
    /**
     * Crear un rol
     * @param equipos
     */
    @POST
    public void create(Equipos equipos){
        equiposEJB.create(equipos);
    }
    
    /**
     * Edita un rol
     * @param id
     * @param equipos
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Equipos equipos){
       equiposEJB.edit(equipos);
    }
}
