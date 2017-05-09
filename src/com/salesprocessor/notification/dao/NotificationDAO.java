package com.salesprocessor.notification.dao;

import com.salesprocessor.notification.model.Notification;

import java.util.List;

/**
 * Created by amrutaj on 07/05/2017.
 */
public interface NotificationDAO {

    void saveNotification(Notification notification);

    List<Notification> getAllNotifications();

    void updateNotification(Notification notification);

}
