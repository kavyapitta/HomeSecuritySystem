import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

    private static DataBase database;

    private List<User> admins;
    private List<User> owners;
    private List<User> users;

    private Map<Integer, Camera> cameras;
    private Map<Integer, Sensor> sensors;

    private DataBase() {
        admins = new ArrayList<>();
        owners = new ArrayList<>();
        users = new ArrayList<>();
        cameras = new HashMap<>();
        sensors = new HashMap<>();

        User admin = new Admin("Admin", "admin", "admin");
        admins.add(admin);
    }

    public static DataBase getInstance() {
        if(database == null) {
            synchronized (DataBase.class) {
                if(database == null) {
                    database = new DataBase();
                }
            }
        }
        return database;
    }

    public boolean addOwner(User owner) {
        return owners.add(owner);
    }

    public boolean addUsers(User user) {
        return users.add(user);
    }

    public void addCamera(int id, Camera camera) {
        cameras.put(id, camera);
    }

    public void addSensor(int id, Sensor sensor) {
        sensors.put(id, sensor);
    }

    public boolean removeOwner(User owner) {
        return owners.remove(owner);
    }

    public boolean removeUsers(User user) {
        return users.remove(user);
    }

    public void removeCamera(int id) {
        cameras.remove(id);
    }

    public void removeSensor(int id) {
        sensors.remove(id);
    }

    public Map<Integer, Camera> getCameras() {
        return cameras;
    }

    public boolean addAdmin(User admin) {
        return admins.add(admin);
    }

    public boolean removeAdmin(User admin) {
        return admins.remove(admin);
    }

    public User getAdmin(String username, String password) {
        for(User user: admins) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getOwner(String username, String password) {
        for(User user: owners) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public User getUser(String username, String password) {
        for(User user: users) {
            if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public Camera getCamera(int id) {
        return cameras.get(id);
    }


    public Map<Integer,Sensor> getSensors() {
        return sensors;
    }

    public Sensor getSensor(int id) {
        return sensors.get(id);
    }
}
