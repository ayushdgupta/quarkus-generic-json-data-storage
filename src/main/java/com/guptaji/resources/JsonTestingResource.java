package com.guptaji.resources;

import com.guptaji.entity.JsonTestingEntity;
import com.guptaji.repository.JsonTestingRepo;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/jsonTesting")
public class JsonTestingResource {

    @Inject
    public JsonTestingRepo jsonTestingRepo;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAuthorDetails(){
        return Response.ok(jsonTestingRepo.listAll()).build();
    }

    @POST
    @Transactional
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public Response insertAuthorDetails(JsonTestingEntity author){
        jsonTestingRepo.persist(author);
        if (jsonTestingRepo.isPersistent(author)){
            return Response.ok("Done dana done done").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
    }
}
