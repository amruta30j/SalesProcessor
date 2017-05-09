package com.salesprocessor.notification.processor;

import com.salesprocessor.notification.dao.NotificationDAO;
import com.salesprocessor.notification.model.Notification;
import com.salesprocessor.notification.receiver.NotificationReceiver;
import com.salesprocessor.notification.reporter.ReportGenerator;

import java.util.List;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class NotificationProcessor {

    private  NotificationReceiver receiver;
    private  ReportGenerator generator;
    private  NotificationDAO dao;
    private  int numberOfNOtificationsProcessed=0;

    public NotificationProcessor(NotificationReceiver receiver, ReportGenerator generator, NotificationDAO dao) {
        this.receiver= receiver;
        this.generator= generator;
        this.dao=dao;
    }



    public void process(){

        Notification notificationMessage = receiver.getNotification();

        //get a type of notification,
        /*All   have been saved*/
        dao.saveNotification(notificationMessage);

        if(notificationMessage.getMessageType().equals(Notification.MessageType.MESSAGE_TYPE_1)){
            Double totalValue=0.0;
            totalValue = notificationMessage.getProduct().getProductPrice() * notificationMessage.getProduct()
                    .getProductQuantity();
            notificationMessage.setValue(totalValue);
        }

        // No special processing required for MESSAGE_TYPE_2

        else if(notificationMessage.getMessageType().equals(Notification.MessageType.MESSAGE_TYPE_3)){
            adjustNotifications(notificationMessage);
        }

        numberOfNOtificationsProcessed++;

        if (numberOfNOtificationsProcessed%10==0){
            /**/
           //log a report detailing the number of sales of each product and their total value.
            String report = generator.generateSummaryReport();

            // print report
            System.out.println("Printing the report for 10 values recived.");
            System.out.println(report);

            }

        if (numberOfNOtificationsProcessed%50==0){
            /**/
            // pause the receiver
            System.out.println("Notification receiver is pausing");
            receiver.pauseReceiver();

            // generate report and print report
            generator.generateAdjustmentReport();

            // resume receiver
            System.out.println("Notification receiver is resuming");
            receiver.resumeReceiver();
        }


    }

    public void adjustNotifications(Notification notificationIn) {
        List<Notification> allNotifications = dao.getAllNotifications();

        for(Notification n : allNotifications){
            if(n.getProduct().getProductNmae().equals(notificationIn.getProduct().getProductNmae())) {
                if(n.getValue()!=null){
                    n.setValue(notificationIn.getOperationtype().applyAsDouble(n.getValue(),
                            notificationIn.getAdjustment()));
                }
                else{
                    n.setValue(notificationIn.getAdjustment());
                }
                n.setAdjusted(true);
                dao.updateNotification(n);
            }
        }
    }

    public void startProcess(){
        while(!receiver.isEmpty()){
            process();
        }
    }

}
