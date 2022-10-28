package edu.utez.mx.personaje.controller.personaje;

import edu.utez.mx.personaje.model.BeanPersonaje;
import edu.utez.mx.personaje.model.DaoPersonaje;
import edu.utez.mx.personaje.utils.Response;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;
@Path("/api/personaje")
public class personajeService {
        @GET
        @Path("/")
        @Produces(value = {"application/json"})
        public List<BeanPersonaje> getAll() {
            return new DaoPersonaje().findAll();

        }

        @GET
        @Path("/{id}")
        @Produces(MediaType.APPLICATION_JSON)
        public Response<BeanPersonaje> getById(@PathParam("id") Long id) {
            return new DaoPersonaje().findById(id);
        }

        @POST
        @Path("/")
        @Consumes(MediaType.APPLICATION_JSON)
        @Produces(MediaType.APPLICATION_JSON)
        public Response<BeanPersonaje> save(BeanPersonaje personaje) {
            return new DaoPersonaje().save(personaje);
        }
    }
