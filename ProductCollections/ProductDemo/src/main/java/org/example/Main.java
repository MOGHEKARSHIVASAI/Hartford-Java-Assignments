package org.example;

import java.util.Scanner;
import java.util.List;
import java.util.Map;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== PRODUCT MANAGEMENT ===");
            System.out.println("1. Test with List");
            System.out.println("2. Test with Map");
            System.out.println("3. Exit");
            System.out.print("Choose: ");

            int choice = readInt();

            switch (choice) {
                case 1 -> testList();
                case 2 -> testMap();
                case 3 -> {
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void testList() {
        ProductManagementUsingList pm = new ProductManagementUsingList();
        boolean run = true;

        while (run) {
            System.out.println("\n--- LIST MODE ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All");
            System.out.println("3. Get by ID");
            System.out.println("4. Filter by Brand");
            System.out.println("5. Filter by Category");
            System.out.println("6. Filter by Price Range");
            System.out.println("7. Sort by Name (ASC)");
            System.out.println("8. Sort by Name (DESC)");
            System.out.println("9. Sort by Price (ASC)");
            System.out.println("10. Sort by Price (DESC)");
            System.out.println("11. Sort by Rating (ASC)");
            System.out.println("12. Sort by Rating (DESC)");
            System.out.println("13. Remove by ID");
            System.out.println("14. Back");
            System.out.print("Choose: ");

            switch (readInt()) {
                case 1 -> {
                    Product p = inputProduct();
                    pm.adProduct(p);
                    System.out.println("✓ Added");
                }
                case 2 -> displayList(pm.getProducts());
                case 3 -> {
                    System.out.print("Enter ID: ");
                    Product p = pm.getProductsById(readInt());
                    if (p != null) System.out.println(format(p));
                    else System.out.println("Not found!");
                }
                case 4 -> {
                    System.out.print("Enter brand: ");
                    displayList(pm.getProductsByBrand(sc.nextLine()));
                }
                case 5 -> {
                    System.out.print("Enter category: ");
                    displayList(pm.filterByCategory(sc.nextLine()));
                }
                case 6 -> {
                    System.out.print("Min price: ");
                    double min = readDouble();
                    System.out.print("Max price: ");
                    double max = readDouble();
                    displayList(pm.filterByPriceRange(min, max));
                }
                case 7 -> {
                    pm.sortByNameAsc();
                    displayList(pm.getProducts());
                }
                case 8 -> {
                    pm.sortByNameDsc();
                    displayList(pm.getProducts());
                }
                case 9 -> {
                    pm.sortByPriceAsc();
                    displayList(pm.getProducts());
                }
                case 10 -> {
                    pm.sortByPriceDsc();
                    displayList(pm.getProducts());
                }
                case 11 -> {
                    pm.sortByRatingAsc();
                    displayList(pm.getProducts());
                }
                case 12 -> {
                    pm.sortByRatingDsc();
                    displayList(pm.getProducts());
                }
                case 13 -> {
                    System.out.print("Enter ID to remove: ");
                    boolean removed = pm.removeProductById(readInt());
                    System.out.println(removed ? "✓ Removed" : "Not found!");
                }
                case 14 -> run = false;
                default -> System.out.println("Invalid!");
            }
        }
    }

    private static void testMap() {
        ProductManagementUsingMap pm = new ProductManagementUsingMap();
        boolean run = true;

        while (run) {
            System.out.println("\n--- MAP MODE ---");
            System.out.println("1. Add Product");
            System.out.println("2. View All");
            System.out.println("3. Get by ID");
            System.out.println("4. Filter by Brand");
            System.out.println("5. Filter by Category");
            System.out.println("6. Filter by Price Range");
            System.out.println("7. Sort by Name (ASC)");
            System.out.println("8. Sort by Name (DESC)");
            System.out.println("9. Sort by Price (ASC)");
            System.out.println("10. Sort by Price (DESC)");
            System.out.println("11. Sort by Rating (ASC)");
            System.out.println("12. Sort by Rating (DESC)");
            System.out.println("13. Remove by ID");
            System.out.println("14. Back");
            System.out.print("Choose: ");

            switch (readInt()) {
                case 1 -> {
                    Product p = inputProduct();
                    pm.addProduct(p);
                    System.out.println("✓ Added");
                }
                case 2 -> displayMap(pm.getProducts());
                case 3 -> {
                    System.out.print("Enter ID: ");
                    Product p = pm.getProductsById(readInt());
                    if (p != null) System.out.println(format(p));
                    else System.out.println("Not found!");
                }
                case 4 -> {
                    System.out.print("Enter brand: ");
                    displayList(pm.getProductsByBrand(sc.nextLine()));
                }
                case 5 -> {
                    System.out.print("Enter category: ");
                    displayList(pm.filterByCategory(sc.nextLine()));
                }
                case 6 -> {
                    System.out.print("Min price: ");
                    double min = readDouble();
                    System.out.print("Max price: ");
                    double max = readDouble();
                    displayList(pm.filterByPriceRange(min, max));
                }
                case 7 -> {
                    pm.sortByNameAsc();
                    displayMap(pm.getProducts());
                }
                case 8 -> {
                    pm.sortByNameDsc();
                    displayMap(pm.getProducts());
                }
                case 9 -> {
                    pm.sortByPriceAsc();
                    displayMap(pm.getProducts());
                }
                case 10 -> {
                    pm.sortByPriceDsc();
                    displayMap(pm.getProducts());
                }
                case 11 -> {
                    pm.sortByRatingAsc();
                    displayMap(pm.getProducts());
                }
                case 12 -> {
                    pm.sortByRatingDsc();
                    displayMap(pm.getProducts());
                }
                case 13 -> {
                    System.out.print("Enter ID to remove: ");
                    boolean removed = pm.removeProductById(readInt());
                    System.out.println(removed ? "✓ Removed" : "Not found!");
                }
                case 14 -> run = false;
                default -> System.out.println("Invalid!");
            }
        }
    }

    private static Product inputProduct() {
        System.out.print("ID: ");
        int id = readInt();
        sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        System.out.print("Price: ");
        double price = readDouble();
        sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Rating (1-5): ");
        int rating = readInt();
        sc.nextLine();

        System.out.print("Discount (%): ");
        double discount = readDouble();

        return new Product(id, name, price, brand, category, rating, discount);
    }

    private static void displayList(List<Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products) {
                System.out.println(format(p));
            }
        }
    }

    private static void displayMap(Map<Integer, Product> products) {
        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products.values()) {
                System.out.println(format(p));
            }
        }
    }

    private static String format(Product p) {
        return String.format("ID: %d | %s | $%.2f | %s | %s | Rating: %d | Discount: %.1f%%",
                p.getPid(), p.getName(), p.getPrice(), p.getBrand(), p.getCategory(),
                p.getRating(), p.getDiscount());
    }

    private static int readInt() {
        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Invalid! Enter number: ");
            return readInt();
        }
    }

    private static double readDouble() {
        try {
            return Double.parseDouble(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.print("Invalid! Enter number: ");
            return readDouble();
        }
    }
}
