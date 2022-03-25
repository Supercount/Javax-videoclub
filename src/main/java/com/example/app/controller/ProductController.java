package com.example.app.controller;

import com.example.app.controller.model.CreateProduct;
import com.example.app.dao.DaoFactory;
import com.example.app.dao.base.ProductDao;
import com.example.app.dao.entity.Product;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/products")
public class ProductController {
    private static List<Product> products = new ArrayList<>();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAll(){
        List<Product> products = DaoFactory.getProductDao().findAll();
        return Response.ok(products).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreateProduct createProduct) {
        Product product = new Product(createProduct.getMovie(), createProduct.isAvailable());
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.save(product);
        return Response.status(201).build();
    }

    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modify(Product product) {
        ProductDao productDao = DaoFactory.getProductDao();
        productDao.update(product);
        return Response.status(200).build();
    }

    @DELETE
    @Path("{id}")
    public Response deleteProductById(@PathParam("id") Long id) {
        DaoFactory.getProductDao().delete(id);
        return Response.status(202).build();
    }
}
