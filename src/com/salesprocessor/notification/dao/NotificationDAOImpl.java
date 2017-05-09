package com.salesprocessor.notification.dao;

import com.salesprocessor.notification.model.Notification;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class NotificationDAOImpl implements NotificationDAO {

    List<Notification> notificationList = new ArrayList<>();

    @Override
    public void saveNotification(Notification notification) {
        notificationList.add(notification);
    }
    @Override
    public List<Notification> getAllNotifications() {
        return notificationList;
    }

    @Override
    public void updateNotification(Notification notification) {
        int index = notificationList.indexOf(notification);
        notificationList.set(index,notification);
    }
}
