package org.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        ProductManagementUsingList pm = new ProductManagementUsingList();

        pm.adProduct(new Product(1, "iPhone 14", 999.99, "Apple", "Electronics", 5, 10.0));
        pm.adProduct(new Product(2, "Galaxy S23", 899.99, "Samsung", "Electronics", 4, 15.0));
        pm.adProduct(new Product(3, "MacBook Pro", 2499.99, "Apple", "Computers", 5, 5.0));
        pm.adProduct(new Product(4, "Dell XPS", 1499.99, "Dell", "Computers", 4, 8.0));
        pm.adProduct(new Product(5, "AirPods", 199.99, "Apple", "Accessories", 4, 12.0));

        System.out.println("=== All Products ===");
        printProducts(pm.getProducts());

        System.out.println("\n=== Get Product by ID (3) ===");
        System.out.println(formatProduct(pm.getProductsById(3)));

        System.out.println("\n=== Products by Brand (Apple) ===");
        printProducts(pm.getProductsByBrand("Apple"));

        System.out.println("\n=== Sort by Name Ascending ===");
        pm.sortByNameAsc();
        printProducts(pm.getProducts());

        System.out.println("\n=== Sort by Price Descending ===");
        pm.sortByPriceDsc();
        printProducts(pm.getProducts());

        System.out.println("\n=== Sort by Rating Descending ===");
        pm.sortByRatingDsc();
        printProducts(pm.getProducts());

        System.out.println("\n=== Filter by Category (Electronics) ===");
        printProducts(pm.filterByCategory("Electronics"));

        System.out.println("\n=== Filter by Price Range (500-1500) ===");
        printProducts(pm.filterByPriceRange(500, 1500));

        System.out.println("\n=== Remove Product by ID (2) ===");
        System.out.println("Removed: " + pm.removeProductById(2));
        printProducts(pm.getProducts());

        // random map example
        showFrequencyExample();
    }

    private static void showFrequencyExample() {
        Map<Character, Integer> freq = new HashMap<>();
        freq.put('a', 10);
        freq.put('b', 20);
        freq.put('c', 30);
        freq.put('d', 30);
        List<Set<Map.Entry<Character,Integer>>> maxEntry = (freq.entrySet()).toList();


    }

    private static void printProducts(java.util.List<Product> products) {
        for (Product p : products) {
            System.out.println(formatProduct(p));
        }
    }

    private static String formatProduct(Product p) {
        return String.format("ID: %d | %s | $%.2f | %s | %s | Rating: %d | Discount: %.1f%%",
                p.getPid(), p.getName(), p.getPrice(), p.getBrand(), p.getCategory(), p.getRating(), p.getDiscount());
    }
}