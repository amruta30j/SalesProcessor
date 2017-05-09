package com.salesprocessor.notification.receiver;

import com.salesprocessor.notification.model.Notification;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class NotificationReceiverImpl implements NotificationReceiver{

    private Queue<Notification> queue = new LinkedList<>();

    private boolean isPaused = false;


    @Override
    public void putNotification(Notification notification) throws IllegalStateException {
         if(isPaused) {
             throw new IllegalStateException("Currently not accepting notifications");
         }
        queue.add(notification);
    }

    @Override
    public Notification getNotification() {

        if(!isEmpty()){
                return  queue.remove();
            }
        return null;
    }

    @Override
    public void pauseReceiver() {
        isPaused = true;

    }

    @Override
    public void resumeReceiver() {
        isPaused = false;

    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public void clear() {
        queue.clear();
    }
}
