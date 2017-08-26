/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Equipos;
import co.edu.sena.adsi.jpa.entities.Eventos;
import co.edu.sena.adsi.jpa.sessions.EventosFacade;
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
@Path("eventos")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class EventosREST {
      
    @EJB
    private EventosFacade eventosEJB;
    
    @GET
    public List<Eventos> findAll() {
        return eventosEJB.findAll();
    }
    
       
    @GET
    @Path("{id}")
    public Eventos findById(@PathParam("id") String id){
        return eventosEJB.find(id);
    }
    
    /**
     * Crear un rol
     * @param eventos
     */
    @POST
    public void create(Eventos eventos){
        eventosEJB.create(eventos);
    }
    
    /**
     * Edita un rol
     * @param id
     * @param eventos
     */
    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") String id, Eventos eventos){
       eventosEJB.edit(eventos);
    }
}
