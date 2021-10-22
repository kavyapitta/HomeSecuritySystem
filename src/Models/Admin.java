package Models;

import Facade.FacadeSystemFeatures;

import java.util.Scanner;

public class Admin extends User {

    public Admin(String name, String username, String password) {
        super(name, username, password);
    }

    @Override
    public void handler(Scanner scanner, FacadeSystemFeatures systemFeatures) {
        while(true) {
            System.out.println();
            System.out.println("1. Add Sensor");
            System.out.println("2. Add Camera");
            System.out.println("3. Add Authorized User");
            System.out.println("4. Add Home Owner");
            System.out.println("5. Add Admin");
            System.out.println("6. Exit");
            System.out.println();

            boolean EXIT_FLAG = false;
            System.out.print("Enter you choice: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    systemFeatures.addSensor(scanner);
                    break;
                case 2:
                    systemFeatures.addCamera(scanner);
                    break;
                case 3:
                    systemFeatures.addAuthorizedUser(scanner);
                    break;
                case 4:
                    systemFeatures.addOwner(scanner);
                    break;
                case 5:
                    systemFeatures.addAdmin(scanner);
                    break;
                case 6:
                    EXIT_FLAG = true;
                    break;
                default:
                    System.out.println("[Info] Invalid Choice!!");
                    break;
            }

            if(EXIT_FLAG) break;
        }
    }
}