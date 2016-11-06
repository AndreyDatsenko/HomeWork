package com.geekhub.lesson3;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Inventory inventory = new Inventory();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Add the one of the product types: PHONE, TV or FRIDGE");
        while (true) {

            if (scanner.equals("")) {
                break;
            }
            System.out.print("type: ");
            String type = scanner.nextLine();
            System.out.print("name: ");
            String name = scanner.nextLine();
            System.out.print("price: ");
            double price = scanner.nextDouble();
            System.out.print("count: ");
            int count = scanner.nextInt();
            scanner.nextLine();

            Product product = new Product();
            product.setName(name);
            product.setPrice(price);
            product.setCount(count);
            inventory.addProduct(ProductType.valueOf(type), product);

            System.out.println(" Do you want to continue to add products: Y/N?");
            String question = scanner.nextLine();

            if (question.equalsIgnoreCase("Y")) {
                continue;
            } else if (question.equalsIgnoreCase("N")) {
                inventory.getProducts().keySet()
                        .forEach(p -> System.out.println(p.toString() + " inventory = "
                                + inventory.inventoryType(p)));
                System.out.println("Inventory all types = " + inventory.inventoryAllTypes());
                scanner.close();
                break;
            }
        }
    }
}
