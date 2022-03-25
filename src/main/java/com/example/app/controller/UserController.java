package com.example.app.controller;

import com.example.app.controller.model.CreateMovie;
import com.example.app.controller.model.CreateUser;
import com.example.app.dao.DaoFactory;
import com.example.app.dao.base.MovieDao;
import com.example.app.dao.base.UserDao;
import com.example.app.dao.entity.Movie;
import com.example.app.dao.entity.User;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/users")
public class UserController {

    private static List<User> users = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<User> users = DaoFactory.getUserDao().findAll();
        return Response.ok(users).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateUser createUser) {
        User user = new User(createUser.getFirstName(), createUser.getLastName(), createUser.getBirthDate(), createUser.getInscriptionDate());
        UserDao userDao = DaoFactory.getUserDao();
        userDao.save(user);
        return Response.status(201).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify(User user) {
        UserDao userDao = DaoFactory.getUserDao();
        userDao.update(user);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMovieById(@PathParam("id") Long id) {
        DaoFactory.getUserDao().delete(id);
        return Response.status(202).build();
    }

}
