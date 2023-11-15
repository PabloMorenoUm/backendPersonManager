package com.example.backend.rest;

import com.example.backend.core.PersonService;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;

import java.util.List;

@Path("/person")
public class PersonController {

    @Inject
    private PersonService service;

    @POST
    @Produces("application/json")
    public PersonDto create(){
        return null;
    }

    @GET
    @Produces("application/json")
    public List<PersonDto> getAll(){
        return null;
    }
}
