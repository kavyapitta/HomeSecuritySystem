package Models;

import Facade.FacadeSystemFeatures;
import Observer.ConsumerListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HomeOwner extends User implements ConsumerListener {

    private List<Notification> notifications;

    public HomeOwner(String name, String username, String password) {
        super(name, username, password);
        notifications  = new ArrayList<>();
    }

    @Override
    public void handler(Scanner scanner, FacadeSystemFeatures systemFeatures) {
        while(true) {
            System.out .println();
            System.out.println("1. Display camera");
            System.out.println("2. Status camera");
            System.out.println("3. Status sensor");
            System.out.println("4. Replay camera");
            System.out.println("5. activate or deactivate camera");
            System.out.println("6. activate or deactivate sensor");
            System.out.println("7. View Notifications");
            System.out.println("8. Exit");
            System.out.println();

            boolean EXIT_FLAG = false;
            System.out.print("Enter option which you want to select: ");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    systemFeatures.displayCamera(scanner);
                    break;
                case 2:
                    systemFeatures.statusCamera(scanner);
                    break;
                case 3:
                    systemFeatures.statusSensor(scanner);
                    break;
                case 4:
                    systemFeatures.replayCamera(scanner);
                    break;
                case 5:
                    systemFeatures.changeStatusCamera(scanner);
                    break;
                case 6:
                    systemFeatures.changeStatusSensor(scanner);
                    break;
                case 7:
                    viewNotifications();
                    break;
                case 8:
                    EXIT_FLAG = true;
                    break;
                default:
                    System.out.println("[Info] Invalid Choice!!");
                    break;
            }
            if(EXIT_FLAG) break;
        }
    }

    @Override
    public void update(String eventType, Notification notification) {
        System.out.println("[Models.Notification] Models.HomeOwner " + getName() + " Notified");
        notifications.add(notification);
    }

    private void viewNotifications() {
        System.out.println();
        if(notifications.size() == 0) System.out.println("[Info] No Notifications");
        for(Notification notification: notifications) {
            System.out.println(notification.toString());
            notification.setReadStatus();
        }
        System.out.println();
    }
}
