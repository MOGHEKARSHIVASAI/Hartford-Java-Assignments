package org.example;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class ProductManagementUsingMap {
    private Map<Integer, Product> products;

    public ProductManagementUsingMap() {
        products = new HashMap<>();
    }

    public void addProduct(Product product) {
        products.put(product.getPid(), product);
    }

    public Map<Integer, Product> getProducts() {
        return products;
    }

    public Product getProductsById(int id) {
        return products.get(id);
    }

    public boolean removeProductById(int id) {
        return products.remove(id) != null;
    }

    public List<Product> getProductsByBrand(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }

    public void sortByNameAsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> a.getName().compareToIgnoreCase(b.getName()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByNameDsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> b.getName().compareToIgnoreCase(a.getName()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByPriceAsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Double.compare(a.getPrice(), b.getPrice()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByPriceDsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Double.compare(b.getPrice(), a.getPrice()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByRatingAsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Integer.compare(a.getRating(), b.getRating()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByRatingDsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Integer.compare(b.getRating(), a.getRating()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByDiscountAsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Double.compare(a.getDiscount(), b.getDiscount()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public void sortByDiscountDsc() {
        List<Product> list = new ArrayList<>(products.values());
        Collections.sort(list, (a, b) -> Double.compare(b.getDiscount(), a.getDiscount()));
        products.clear();
        for (Product p : list) {
            products.put(p.getPid(), p);
        }
    }

    public List<Product> filterByCategory(String category) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getCategory().equalsIgnoreCase(category)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterByName(String name) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getName().equalsIgnoreCase(name)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterByPriceRange(double minPrice, double maxPrice) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterByBrand(String brand) {
        List<Product> result = new ArrayList<>();
        for (Product p : products.values()) {
            if (p.getBrand().equalsIgnoreCase(brand)) {
                result.add(p);
            }
        }
        return result;
    }

    public List<Product> filterByNameUsingStream(String name) {
        return products.values().stream().filter(p -> p.getName().equalsIgnoreCase(name)).toList();
    }

    public Product getByIdUsingStream(int id) {
        return products.values().stream().filter(p -> p.getPid() == id).findFirst().orElse(null);
    }
}

