package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Usuarios;
import co.edu.sena.adsi.jpa.sessions.UsuariosFacade;
import co.edu.sena.adsi.rest.auth.DigestUtil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.security.RolesAllowed;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author ruberr
 */
@Path("usuarios")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class UsuariosREST {

    @EJB
    private UsuariosFacade usuarioEJB;


    /**
     * Obtiene todos los usuarioes
     *
     * @param idUsuario
     * @param activo
     * @param numDocumento
     * @param email
     * @param idTipoDocumento
     * @return lista de usuarios
     */
    @GET
    @RolesAllowed({"ADMIN"})
    public List<Usuarios> findAll(@QueryParam("idUsuario") Integer idUsuario,
          
            @QueryParam("activo") Boolean activo,
            @QueryParam("numDocumento") String numDocumento,
            @QueryParam("email") String email, 
            @QueryParam("idTipoDocumento") idTipoDocumento){

        return usuarioEJB.findUsers(idUsuario, activo, numDocumento,
                email, idTipoDocumento);
    }

    /**
     * Busca usuario por su id
     *
     * @param id
     * @return usuario
     */
    @GET
    @Path("{id}")
    public Usuarios findById(@PathParam("id") Integer id) {
        return usuarioEJB.find(id);
    }

    /**
     * Crear un usuario
     *
     * @param usuario
     * @return
     */
    @POST
    public Response create(Usuarios usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        String pass = usuario.getPassword();
        try {
            if (usuarioEJB.findUsuariosByEmail(usuario.getEmail()) == null) {
                if (usuarioEJB.findUsuariosByNumDocumento(usuario.getNumDocumento()) == null) {

                    usuario.setPassword(DigestUtil.cifrarPassword(usuario.getPassword()));
                    usuarioEJB.create(usuario);
                    try {

                        //Uso configuración de email para Registro
                        Email email = emailEJB.findConfigEmail("REGISTRO");
                        if (emailApp == null) {
                            emailApp = emailEJB.findConfigEmail("GENERAL");
                        }
                        //Envio de email
                        SendEmail enviarEmailUser = new SendEmail();
                        enviarEmailUser.sendEmailRegistroUsuario(emailApp, usuario, pass);

                        return Response.status(Response.Status.CREATED).entity(gson.toJson("El usuario se creó correctamente!")).build();
                    } catch (Exception e) {
                        System.out.println("ERROR ENVIO DE EMAIL: " + e);
                        return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("No fue posible el envio del email")).build();
                    }
                } else {
                    return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El número de documento ya se encuentra registrado!.")).build();
                }
            } else {
                return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("El email ya se encuentra registrado!.")).build();
            }
        } catch (Exception e) {
            Logger.getLogger(UsuariosREST.class.getName()).log(Level.SEVERE, null, e);
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al guardar el usuario!.")).build();
        }
    }

    /**
     * Edita un usuario
     *
     * @param id
     * @param usuario
     * @return 
     */
    @PUT
    @Path("{id}")
    public Response edit(@PathParam("id") Integer id, Usuarios usuario) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        try {
            usuarioEJB.edit(usuario);
            return Response.status(Response.Status.CREATED).entity(gson.toJson("El usuario se actualizó correctamente!")).build();
        } catch (Exception e) {
            return Response.status(Response.Status.BAD_REQUEST).entity(gson.toJson("Error al actualizar el usuario!.")).build();
        }
    }
}
