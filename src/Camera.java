public class Camera {

    private int ID;
    private String location;
    private boolean status;

    public Camera(int ID, String location) {
        this.ID = ID;
        this.location = location;
        this.status = false;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void changeStatus() {
        this.status = ! this.status;
    }

    @Override
    public String toString() {
        return "" + ID + "\t" + location + "\t\t" + status;
    }

    public void render() {
        System.out.println("[Info] Camera with ID: " + ID + " has been rendered !!");
        System.out.println("*****************");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*               *");
        System.out.println("*****************");
        System.out.println("");
    }
}
