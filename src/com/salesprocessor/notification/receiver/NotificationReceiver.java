package com.salesprocessor.notification.receiver;

import com.salesprocessor.notification.model.Notification;

/**
 * Created by amrutaj on 07/05/2017.
 */
public interface NotificationReceiver {

    void putNotification(Notification notification);

    Notification getNotification();

    void pauseReceiver();

    void resumeReceiver();

    boolean isEmpty();

    void clear();
}
