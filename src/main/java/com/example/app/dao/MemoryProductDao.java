package com.example.app.dao;

import com.example.app.dao.base.ProductDao;
import com.example.app.dao.entity.Product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MemoryProductDao implements ProductDao {
    private static List<Product> products = new ArrayList<>();
    private static Long idSequence = 1L;

    MemoryProductDao() {}

    @Override
    public Long save(Product product) {
        product.setId(idSequence++);
        products.add(product);
        return product.getId();
    }

    @Override
    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    @Override
    public boolean update(Product productToUpdate) {
        boolean isUpdate=false;
        List<Product> tempList = new ArrayList<>();
        for (Product m:products) {
            if (m.getId() == productToUpdate.getId()) {
                m = productToUpdate;
                isUpdate=true;
            }
            tempList.add(m);
        }
        this.products = tempList;
        return isUpdate;
    }

    @Override
    public void delete(Long id) {
        this.products = this.products.stream()
                .filter(product -> product.getId() != id)
                .collect(Collectors.toList());
    }
}
