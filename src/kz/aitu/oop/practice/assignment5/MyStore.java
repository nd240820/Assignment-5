package kz.aitu.oop.practice.assignment5;

import kz.aitu.oop.practice.assignment5.controllers.Generic;
import kz.aitu.oop.practice.assignment5.controllers.NecklaceController;

import java.util.Scanner;

public class MyStore {
    private final NecklaceController controller;
    private final Scanner scanner;

    public MyStore(NecklaceController controller) {
        this.controller = controller;
        scanner = new Scanner(System.in);
    }

    public void start() {
            /*
            outputting messages to console
             */
        do {
            System.out.println();
            System.out.println("Welcome to my store!");
            System.out.println("Select option:");
            System.out.println("1. Get all stones");
            System.out.println("2. Get all necklaces");
            System.out.println("3. Create necklace with stones");
            System.out.println("0. Exit");
            System.out.println();
            System.out.print("Enter option (0-3): "); //choosing option
            int option = (scanner.nextInt());
            if (option == 1) {
                getAllStonesMenu(); //calling method in case of option = 1
            } else if (option == 2) {
                getAllNecklacesMenu();//calling method in case of option = 2
            } else if (option == 3) {
                totalNecklaceCost(); //calling method in case of option = 3
            } else {
                break; //stopping program
            }
        } while (true);
        System.out.println("\n*************************");
    }

    public void getAllStonesMenu() {
        String response = controller.getAllStones(); //creating new variable and equalizing it to output of method from controller class
        System.out.println(response);
    }

    public void getAllNecklacesMenu() {
        String response = controller.getAllNecklaces(); //creating new variable and equalizing it to output of method from controller class
        System.out.println(response);
    }

    public void totalNecklaceCost() {
        /*
        outputting message and scanning values
         */
        System.out.println("Please choose number of stones");
        int num = scanner.nextInt();
        System.out.println("Please enter id of the necklace");
        int necklace_id = scanner.nextInt();
        System.out.println("Please enter the weight of the stone. There will be the same weight for all stones");
        double stone_weight = scanner.nextDouble();
        System.out.println("Please enter the weight of the necklace");
        double necklace_weight = scanner.nextDouble();

        int sumStones = 0;
        String stn = null;

        Generic<String> necklace = new Generic<>(); //creating generic array list


        /*
        loop for choosing stone and calculating cost of all stones
         */
        for (int i = 0; i < num; i++) {
            System.out.println("Please enter id of the stone");
            int stone_id = scanner.nextInt();
            if (stone_id == 1) {
                stn = "red diamond";
                sumStones += 1000000;
            } else if (stone_id == 2) {
                stn = "taaffeite";
                sumStones += 35000;
            } else if (stone_id == 3) {
                stn = "grandidierite";
                sumStones += 20000;
            } else
                System.out.println("Not correct id");
            necklace.addValue(stn);
        }

        String ncklc;

        /*
        switch statement to give name for each necklace id
         */
        ncklc = switch (necklace_id) {
            case 1 -> "thread";
            case 2 -> "filament";
            case 3 -> "wire";
            default -> throw new IllegalStateException("Unexpected value: " + necklace_id);
        };

        /*
        outputting message about chosen necklace and stones
         */
        System.out.println("You have selected a necklace from " + ncklc + " which consists of stones such as");
        necklace.printValues(); //printing all stones inside generic

        double totalCost, ncklcCost = 1;
        double totalWeight;

        if (necklace_id == 1)
            ncklcCost = 1000;
        else if (necklace_id == 2)
            ncklcCost = 2000;
        else if (necklace_id == 3)
            ncklcCost = 3000;
        else System.out.println("Not correct id");

        /*
        calculating total cost for necklace and outputting it to console
         */
        totalWeight = necklace_weight + (stone_weight * num);
        totalCost = ((necklace_weight * ncklcCost) + (stone_weight * sumStones));

        System.out.println("Total weight for necklace is " + totalWeight + " carats");
        System.out.println("Total cost for necklace is " + totalCost + " kzt");
    }


}