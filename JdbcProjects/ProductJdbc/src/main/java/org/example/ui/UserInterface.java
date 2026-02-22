package org.example.ui;

import org.example.dao.ProductDao;
import org.example.dao.ProductDaoImpl;
import org.example.entity.Product;

import java.util.List;
import java.util.Scanner;

public class UserInterface {
    private static ProductDao dao = new ProductDaoImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewProduct();
                    break;
                case 2:
                    viewAllProducts();
                    break;
                case 3:
                    findProductById();
                    break;
                case 4:
                    deleteProductById();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    sortByCost();
                    break;
                case 7:
                    sortByCategory();
                    break;
                case 8:
                    sortByManufactureDate();
                    break;
                case 9:
                    filterByCategory();
                    break;
                case 10:
                    filterByCostRange();
                    break;
                case 11:
                    filterByManufactureDate();
                    break;
                case 12:
                    running = false;
                    System.out.println("\nThank you for using Product Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n========== Product Management System ==========");
        System.out.println("1.  Add Product");
        System.out.println("2.  View All Products");
        System.out.println("3.  Find Product by ID");
        System.out.println("4.  Delete Product");
        System.out.println("5.  Sort by Name");
        System.out.println("6.  Sort by Cost");
        System.out.println("7.  Sort by Category");
        System.out.println("8.  Sort by Manufacture Date");
        System.out.println("9.  Filter by Category");
        System.out.println("10. Filter by Cost Range");
        System.out.println("11. Filter by Manufacture Date");
        System.out.println("12. Exit");
        System.out.println("===============================================");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    private static void addNewProduct() {
        System.out.println("\n--- Add New Product ---");
        System.out.print("Product ID: ");
        int pid = sc.nextInt();
        sc.nextLine();

        System.out.print("Product Name: ");
        String pname = sc.nextLine();

        System.out.print("Cost: ");
        double cost = sc.nextDouble();
        sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        System.out.print("Rating (1-5): ");
        int rating = sc.nextInt();

        System.out.print("Discount: ");
        double discount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Manufacture Date (YYYY-MM-DD): ");
        String manufactureDate = sc.nextLine();

        Product product = new Product(pid, pname, cost, brand, category, rating, discount, manufactureDate);
        dao.addProduct(product);
        System.out.println("✓ Product added successfully!\n");
    }

    private static void viewAllProducts() {
        System.out.println("\n--- All Products ---");
        List<Product> products = dao.findAll();

        if (products.isEmpty()) {
            System.out.println("No products found!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void findProductById() {
        System.out.println("\n--- Find Product by ID ---");
        System.out.print("Enter Product ID: ");
        int id = sc.nextInt();

        Product product = dao.findProductById(id);
        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Product not found!");
        }
        System.out.println();
    }

    private static void deleteProductById() {
        System.out.println("\n--- Delete Product ---");
        System.out.print("Enter Product ID to delete: ");
        int id = sc.nextInt();

        dao.deleteProduct(id);
        System.out.println("✓ Product deleted!\n");
    }

    private static void sortByName() {
        System.out.println("\n--- Products Sorted by Name ---");
        List<Product> products = dao.sortByName();

        if (products.isEmpty()) {
            System.out.println("No products found!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void sortByCost() {
        System.out.println("\n--- Products Sorted by Cost ---");
        List<Product> products = dao.sortByCost();

        if (products.isEmpty()) {
            System.out.println("No products found!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void sortByCategory() {
        System.out.println("\n--- Products Sorted by Category ---");
        List<Product> products = dao.sortByCategory();

        if (products.isEmpty()) {
            System.out.println("No products found!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void sortByManufactureDate() {
        System.out.println("\n--- Products Sorted by Manufacture Date ---");
        List<Product> products = dao.sortByManufactureDate();

        if (products.isEmpty()) {
            System.out.println("No products found!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void filterByCategory() {
        System.out.println("\n--- Filter Products by Category ---");
        sc.nextLine();
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        List<Product> products = dao.findByCategory(category);
        if (products.isEmpty()) {
            System.out.println("No products found in this category!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void filterByCostRange() {
        System.out.println("\n--- Filter Products by Cost Range ---");
        System.out.print("Enter minimum cost: ");
        double minCost = sc.nextDouble();

        System.out.print("Enter maximum cost: ");
        double maxCost = sc.nextDouble();

        List<Product> products = dao.findByCost(minCost, maxCost);
        if (products.isEmpty()) {
            System.out.println("No products found in this price range!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void filterByManufactureDate() {
        System.out.println("\n--- Filter Products by Manufacture Date ---");
        sc.nextLine();
        System.out.print("Enter manufacture date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        List<Product> products = dao.findByManufactureDate(date);
        if (products.isEmpty()) {
            System.out.println("No products found for this date!\n");
        } else {
            products.forEach(System.out::println);
            System.out.println();
        }
    }
}
