/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Appliance {
    private String name;
    private boolean isOn;

    public Appliance(String name) {
        this.name = name;
        this.isOn = false;
    }

    public void turnOn() {
        isOn = true;
        System.out.println(name + " is now ON");
    }

    public void turnOff() {
        isOn = false;
        System.out.println(name + " is now OFF");
    }

    public boolean isOn() {
        return isOn;
    }

    public String getName() {
        return name;
    }
}

class HomeAutomationSystem {
    private Map<String, Appliance> appliances;

    public HomeAutomationSystem() {
        appliances = new HashMap<>();
        // Adding some appliances to the system
        appliances.put("light", new Appliance("Light"));
        appliances.put("fan", new Appliance("Fan"));
        appliances.put("thermostat", new Appliance("Thermostat"));
    }

    public void turnOn(String applianceName) {
        Appliance appliance = appliances.get(applianceName.toLowerCase());
        if (appliance != null) {
            appliance.turnOn();
        } else {
            System.out.println("Appliance not found.");
        }
    }

    public void turnOff(String applianceName) {
        Appliance appliance = appliances.get(applianceName.toLowerCase());
        if (appliance != null) {
            appliance.turnOff();
        } else {
            System.out.println("Appliance not found.");
        }
    }

    public void status(String applianceName) {
        Appliance appliance = appliances.get(applianceName.toLowerCase());
        if (appliance != null) {
            System.out.println(appliance.getName() + " is " + (appliance.isOn() ? "ON" : "OFF"));
        } else {
            System.out.println("Appliance not found.");
        }
    }

    public void showAppliances() {
        System.out.println("Available appliances: " + appliances.keySet());
    }
}

public class LiveSUR {
    public static void main(String[] args) {
        HomeAutomationSystem system = new HomeAutomationSystem();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nHome Automation System");
            System.out.println("1. Control Appliance");
            System.out.println("2. Check Appliance Status");
            System.out.println("3. List Appliances");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter appliance name to control (e.g., light, fan, thermostat): ");
                    String applianceName = scanner.nextLine();
                    System.out.print("Enter command (on/off): ");
                    String command = scanner.nextLine();
                    if (command.equalsIgnoreCase("on")) {
                        system.turnOn(applianceName);
                    } else if (command.equalsIgnoreCase("off")) {
                        system.turnOff(applianceName);
                    } else {
                        System.out.println("Invalid command.");
                    }
                    break;
                case 2:
                    System.out.print("Enter appliance name to check status: ");
                    String statusName = scanner.nextLine();
                    system.status(statusName);
                    break;
                case 3:
                    system.showAppliances();
                    break;
                case 4:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}