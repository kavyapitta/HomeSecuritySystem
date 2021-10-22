import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Notification {

    private String time;
    private String subject;
    private String content;
    private boolean isReadStatus;

    public Notification(String subject, String content) {
        this.subject = subject;
        this.content = content;
        this.isReadStatus = false;
        this.time = (new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z")).format(new Date(System.currentTimeMillis()));
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public boolean isReadStatus() {
        return isReadStatus;
    }

    public void setStatus(boolean readStatus) {
        isReadStatus = readStatus;
    }

    public void setReadStatus() {
        this.isReadStatus = true;
    }

    @Override
    public String toString() {
        return "[Notification]\t[" + subject + "]\t" + content + "\t\t" + time + "\t" + isReadStatus;
    }
}
