package Facade;

import java.util.Scanner;

public interface FacadeSystemFeatures {

    void changeStatusSensor(Scanner scanner);

    void changeStatusCamera(Scanner scanner);

    void statusSensor(Scanner scanner);

    void statusCamera(Scanner scanner);

    void replayCamera(Scanner scanner);

    void displayCamera(Scanner scanner);

    void addAdmin(Scanner scanner);

    void addOwner(Scanner scanner);

    void addAuthorizedUser(Scanner scanner);

    void addCamera(Scanner scanner);

    void addSensor(Scanner scanner);

    void unauthorizedAccessDetect(String username, String password);
}
