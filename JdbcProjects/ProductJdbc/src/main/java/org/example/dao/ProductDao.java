package org.example.dao;

import org.example.entity.Product;

import java.util.List;

public interface ProductDao {

        void addProduct(Product p);
        List<Product> findAll();
        Product findProductById(int id);
        void deleteProduct(int id);
        List<Product> sortByName();
        List<Product> sortByCost();
        List<Product> sortByCategory();
        List<Product> sortByManufactureDate();
        List<Product> findByCategory(String category);
        List<Product> findByCost(double mincost,double maxcost);
        List<Product> findByManufactureDate(String date);
        List<Product> findByManufactureMonth(String month);
        List<Product> findByManufactureYear(String year);

}
