
import javax.xml.crypto.Data;
import java.util.Scanner;

public class SecuritySystem {

    private FacadeSystemFeatures systemFeatures;

    public SecuritySystem() {
        this.systemFeatures = new FacadeSystemFeatureImplementation();
        DataBase.getInstance();
    }

    public void init() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("=========== System =============");
            System.out.println();
            System.out.print("Enter Username : ");
            String username = scanner.next();
            System.out.print("Enter Password: ");
            String password = scanner.next();
            System.out.println();
            User user = login(username, password);
            if(user == null) {
                System.out.println("[Error] You are not authorized");
                systemFeatures.unauthorizedAccessDetect(username, password);
            } else {
                user.handler(scanner, this.systemFeatures);
            }
            System.out.println();
            System.out.println("================================");
        }
    }

    private User login(String username, String password) {

        // Check For Admins
        User user = DataBase.getInstance().getAdmin(username, password);
        if(user != null) return user;

        // Check for owners
        user = DataBase.getInstance().getOwner(username, password);
        if(user != null) return user;

        // Check for access users
        user = DataBase.getInstance().getUser(username, password);
        return user;
    }
}
