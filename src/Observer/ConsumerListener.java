package Observer;

import Models.Notification;

public interface ConsumerListener {

    void update(String eventType, Notification notification);
}
