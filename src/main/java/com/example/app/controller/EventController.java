package com.example.app.controller;

import com.example.app.controller.model.CreateMovie;
import com.example.app.controller.model.EventModel;
import com.example.app.dao.DaoFactory;

import com.example.app.dao.base.EventDao;
import com.example.app.dao.entity.Event;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/event")
public class EventController {

    private static List<Event> events = new ArrayList<>();




    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Event> events = DaoFactory.getEventDao().findAll();
        return Response.ok(events).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(EventModel e) {
        Event event = new Event(e.getTitle(),e.getStartingDate(),e.getEndingDate(),e.getParticipants(),e.getMovies());
        EventDao eDao = DaoFactory.getEventDao();
        eDao.save(event);
        return Response.status(201).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify(Event event) {
        EventDao eDao = DaoFactory.getEventDao();
        eDao.update(event);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteEventById(@PathParam("id") Long id) {
        DaoFactory.getEventDao().delete(id);
        return Response.status(202).build();
    }

}
