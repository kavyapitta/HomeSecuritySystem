import javax.swing.text.Keymap;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class FacadeSystemFeatureImplementation implements FacadeSystemFeatures {

    private ObjectFactory factory;
    private ProducerManager producerManager;

    public FacadeSystemFeatureImplementation() {
        factory = new UserFactory();
        producerManager = new ProducerManager();
    }

    public void changeStatusSensor(Scanner scanner) {
        // change status of given sensor
        System.out.print("Enter Sensor ID for which you want to change the status: ");
        int id = scanner.nextInt();
        DataBase.getInstance().getSensor(id).changeStatus();
        Sensor sensor = DataBase.getInstance().getSensor(id);
        if(sensor == null) System.out.println("[Error] Invalid Sensor ID !!");
        else sensor.changeStatus();
    }

    public void changeStatusCamera(Scanner scanner) {
        // change status of given camera
        System.out.print("Enter Camera ID for which you want to change the status: ");
        int id = scanner.nextInt();
        Camera camera = DataBase.getInstance().getCamera(id);
        if(camera == null) System.out.println("[Error] Invalid Camera ID !!");
        else camera.changeStatus();
    }

    public void statusSensor(Scanner scanner) {
        // show status of all sensors
        Map<Integer, Sensor> sensors = DataBase.getInstance().getSensors();
        System.out.println("ID\tSensor Type\t\tStatus");
        for(Integer key: sensors.keySet()) {
            System.out.println(sensors.get(key).toString());
        }
    }

    public void statusCamera(Scanner scanner) {
        // Show status of all cameras
        Map<Integer, Camera> cameras = DataBase.getInstance().getCameras();
        System.out.println();
        System.out.println("ID\tLocation\t\tStatus");
        for(Integer key: cameras.keySet()) {
            System.out.println(cameras.get(key).toString());
        }
    }

    public void replayCamera(Scanner scanner) {
        // Select recorded images or videos to play
        System.out.println();
        System.out.println("[Info] This feature Currently not supported");
        System.out.println();
    }

    public void displayCamera(Scanner scanner) {
        // Select camera to render
        System.out.print("Enter Camera ID which you want to render: ");
        int id = scanner.nextInt();
        Camera camera = DataBase.getInstance().getCamera(id);
        if(camera == null) System.out.println("[Error] Invalid Camera ID !!");
        else {
            camera.render();
            pressAnyKeyToContinue();
        }
    }

    public void addAdmin(Scanner scanner) {
        String[] args = userInput(scanner);
        User admin = (User) factory.getObject("admin",args);
        if ( DataBase.getInstance().addAdmin(admin) ) {
            System.out.println("[SUCCESS] Admin Added !!");
        } else {
            System.out.println("[FAILED] Admin not Added !!");
        }
    }

    public void addOwner(Scanner scanner) {
        String[] args = userInput(scanner);
        User owner = (User) factory.getObject("owner",args);
        if ( DataBase.getInstance().addOwner(owner) ) {
            producerManager.subscribe(EventType.UNAUTHORISED, (HomeOwner) owner);
            System.out.println("[SUCCESS] Owner Added !!");
        } else {
            System.out.println("[FAILED] Owner not Added !!");
        }
    }

    public void addAuthorizedUser(Scanner scanner) {
        String[] args = userInput(scanner);
        User user = (User) factory.getObject("users",args);
        if ( DataBase.getInstance().addUsers(user) ) {
            System.out.println("[SUCCESS] User Added !!");
        } else {
            System.out.println("[FAILED] Owner not Added !!");
        }
    }

    public void addCamera(Scanner scanner) {
        System.out.print("Enter Location where you want to install : ");
        String location = scanner.next();
        int key = KeyManager.generateCameraID();
        Camera camera = new Camera(key, location);
        DataBase.getInstance().addCamera(key, camera);
    }

    public void addSensor(Scanner scanner) {
        int choice = 1;
        while(true) {
            System.out.println();
            System.out.println("1. Heat Sensor");
            System.out.println("2. Motion Sensor");
            System.out.println("3. Exit");
            System.out.println();
            System.out.print("Enter your choice:");
            choice = scanner.nextInt();
            if(choice == 1 || choice == 2) break;
            if(choice == 3) return;
            System.out.println("[Error] Invalid choice. Please retry again.");
            System.out.println();
        }

        SensorType sensorType = (choice == 1)? SensorType.HEAT : SensorType.MOTION;
        int key = KeyManager.generateSensorID();
        Sensor sensor = new Sensor(key, sensorType);
        DataBase.getInstance().addSensor(key, sensor);
    }

    @Override
    public void unauthorizedAccessDetect(String username, String password) {
        Notification notification = new Notification("UnAuthorized Access" , "Someone tried to enter the house with this username: " + username + " and password: " + password);
        producerManager.notify(EventType.UNAUTHORISED, notification);
    }

    private void pressAnyKeyToContinue() {
        System.out.println("Press Enter key to continue...");
        try {
            System.in.read();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String[] userInput(Scanner scanner) {
        System.out.print("Enter Name : ");
        String name = scanner.next();
        System.out.print("Enter Username : ");
        String username = scanner.next();
        System.out.print("Enter Password: ");
        String password = scanner.next();
        System.out.println();
        String[] args = new String[3];
        args[0] = name; args[1] = username; args[2] = password;
        return args;
    }
}
