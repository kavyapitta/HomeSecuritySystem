public class Sensor {

    private int id;
    private SensorType sensorType;
    private boolean status;

    public Sensor(int id, SensorType type) {
        this.id = id;
        this.status = false;
        this.sensorType = type;
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

    public SensorType getSensorType() {
        return this.sensorType;
    }

    @Override
    public String toString() {
        return "" + id + "\t" + sensorType + "\t\t" + status;
    }
}
