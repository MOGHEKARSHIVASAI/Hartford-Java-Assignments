package org.example.ui;

import org.example.dao.PhoneDao;
import org.example.dao.PhoneDaoImpl;
import org.example.entity.Phone;

import java.util.List;
import java.util.Scanner;

public class UserInterFace {
    private static PhoneDao dao = new PhoneDaoImpl();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        boolean running = true;

        while (running) {
            displayMenu();
            int choice = getUserChoice();

            switch (choice) {
                case 1:
                    addNewPhone();
                    break;
                case 2:
                    viewAllPhones();
                    break;
                case 3:
                    findPhoneById();
                    break;
                case 4:
                    deletePhoneById();
                    break;
                case 5:
                    sortByName();
                    break;
                case 6:
                    sortByCategory();
                    break;
                case 7:
                    sortByCost();
                    break;
                case 8:
                    filterByCategory();
                    break;
                case 9:
                    filterByCostRange();
                    break;
                case 10:
                    running = false;
                    System.out.println("\nThank you for using Phone Management System!");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.\n");
            }
        }
        sc.close();
    }

    private static void displayMenu() {
        System.out.println("\n========== Phone Management System ==========");
        System.out.println("1. Add Phone");
        System.out.println("2. View All Phones");
        System.out.println("3. Find Phone by ID");
        System.out.println("4. Delete Phone");
        System.out.println("5. Sort by Name");
        System.out.println("6. Sort by Category");
        System.out.println("7. Sort by Cost");
        System.out.println("8. Filter by Category");
        System.out.println("9. Filter by Cost Range");
        System.out.println("10. Exit");
        System.out.println("============================================");
    }

    private static int getUserChoice() {
        System.out.print("Enter your choice: ");
        return sc.nextInt();
    }

    private static void addNewPhone() {
        System.out.println("\n--- Add New Phone ---");
        System.out.print("Phone ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Phone Name: ");
        String name = sc.nextLine();

        System.out.print("Cost: ");
        double cost = sc.nextDouble();
        sc.nextLine();

        System.out.print("Brand: ");
        String brand = sc.nextLine();

        System.out.print("Category: ");
        String category = sc.nextLine();

        Phone phone = new Phone(id, name, cost, brand, category);
        dao.addPhone(phone);
        System.out.println("✓ Phone added successfully!\n");
    }

    private static void viewAllPhones() {
        System.out.println("\n--- All Phones ---");
        List<Phone> phones = dao.findAll();

        if (phones.isEmpty()) {
            System.out.println("No phones found!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void findPhoneById() {
        System.out.println("\n--- Find Phone by ID ---");
        System.out.print("Enter Phone ID: ");
        int id = sc.nextInt();

        Phone phone = dao.findPhoneById(id);
        if (phone != null) {
            System.out.println(phone);
        } else {
            System.out.println("Phone not found!");
        }
        System.out.println();
    }

    private static void deletePhoneById() {
        System.out.println("\n--- Delete Phone ---");
        System.out.print("Enter Phone ID to delete: ");
        int id = sc.nextInt();

        dao.deletePhone(id);
        System.out.println("✓ Phone deleted!\n");
    }

    private static void sortByName() {
        System.out.println("\n--- Phones Sorted by Name ---");
        List<Phone> phones = dao.sortByName();

        if (phones.isEmpty()) {
            System.out.println("No phones found!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void sortByCategory() {
        System.out.println("\n--- Phones Sorted by Category ---");
        List<Phone> phones = dao.sortByCategory();

        if (phones.isEmpty()) {
            System.out.println("No phones found!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void sortByCost() {
        System.out.println("\n--- Phones Sorted by Cost ---");
        List<Phone> phones = dao.sortByCost();

        if (phones.isEmpty()) {
            System.out.println("No phones found!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void filterByCategory() {
        System.out.println("\n--- Filter Phones by Category ---");
        sc.nextLine(); // Consume leftover newline
        System.out.print("Enter category: ");
        String category = sc.nextLine();

        List<Phone> phones = dao.filterByCategory(category);
        if (phones.isEmpty()) {
            System.out.println("No phones found in this category!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }

    private static void filterByCostRange() {
        System.out.println("\n--- Filter Phones by Cost Range ---");
        System.out.print("Enter minimum cost: ");
        double minCost = sc.nextDouble();

        System.out.print("Enter maximum cost: ");
        double maxCost = sc.nextDouble();

        List<Phone> phones = dao.filterByCost(minCost, maxCost);
        if (phones.isEmpty()) {
            System.out.println("No phones found in this price range!\n");
        } else {
            phones.forEach(System.out::println);
            System.out.println();
        }
    }
}
