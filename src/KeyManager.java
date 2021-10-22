public class KeyManager {

    private static int camera_id = 0;
    private static int sensor_id = 0;

    public static int generateCameraID() {
        ++camera_id;
        return camera_id;
    }

    public static int generateSensorID() {
        ++sensor_id;
        return sensor_id;
    }
}
