package com.example.app.controller;

import com.example.app.controller.model.CreateMovie;
import com.example.app.dao.DaoFactory;
import com.example.app.dao.base.MovieDao;
import com.example.app.dao.entity.Movie;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/movies")
public class MovieController {

    private static List<Movie> movies = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Movie> movies = DaoFactory.getMovieDao().findAll();
        return Response.ok(movies).build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateMovie createMovie) {
        Movie movie = new Movie(createMovie.getTitre(), createMovie.getDuration(), createMovie.getReleaseDate());
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.save(movie);
        return Response.status(201).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify(Movie movie) {
        MovieDao movieDao = DaoFactory.getMovieDao();
        movieDao.update(movie);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteMovieById(@PathParam("id") Long id) {
        DaoFactory.getMovieDao().delete(id);
        return Response.status(202).build();
    }

}
