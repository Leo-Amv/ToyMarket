package ru.gb.market.view;

import ru.gb.market.controller.Controller;

import java.util.Scanner;

public class Menu {
    private final Controller c = new Controller();

    public Menu() {
    }

    public void run() {
        Commands cmd;
        while (true) {
            try {
                System.out.println("---Raffle prizes app!---\n");
                System.out.println("ADD -- add toy\nUPD -- update chance at the toy");
                System.out.println("RAF -- raffle prize\nGET -- give a prize\nEXT -- exit");
                String command = input("Enter command: ");
                cmd = Commands.valueOf(command.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Not found command!");
                continue;
            }
            if (cmd == Commands.EXT) return;
            switch (cmd) {
                case ADD:
                    try {
                        String name = String.format(input("\n" +
                                "Name of the toy: "));
                        Integer count = Integer.parseInt(input("Number of toys\n: "));
                        Integer chance = Integer.parseInt(input("Chance of winning: "));
                        c.createToy(name, count, chance);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case UPD:
                    try {
                        Long id = Long.parseLong(input("Enter toy ID : "));
                        Integer chance = Integer.parseInt(input("Change chance of winning: "));
                        c.updateToy(id, chance);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case RAF:
                    try {
                        String firstName = input("Name: ");
                        String lastName = input("Last name: ");
                        String phone = input("Phone: ");
                        c.getRuffle(firstName, lastName, phone);
                        continue;
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                        continue;
                    }
                case GET:
                    try {
                        Long id = Long.parseLong(input("Enter ID: "));
                        c.getPrize(id);
                    } catch (IllegalStateException e) {
                        System.out.println(e.getMessage());
                    }
            }
        }
    }

    private String input(String message) {
        Scanner sc = new Scanner(System.in, "Cp866");
        System.out.print(message);
        return sc.nextLine();
    }
}
