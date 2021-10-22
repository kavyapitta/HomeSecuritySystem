import java.util.Scanner;

public class AccessedUser extends User {

    public AccessedUser(String name, String username, String password) {
        super(name, username, password);
    }

    @Override
    public void handler(Scanner scanner, FacadeSystemFeatures systemFeatures) {
        System.out.println();
        System.out.println("Welcome " + getName() + ", You can enter inside.");
        System.out.println();
    }

}
