package com.salesprocessor.notification.test;

import com.salesprocessor.notification.dao.NotificationDAO;
import com.salesprocessor.notification.dao.NotificationDAOImpl;
import com.salesprocessor.notification.model.Notification;
import com.salesprocessor.notification.model.Product;
import com.salesprocessor.notification.processor.NotificationProcessor;
import com.salesprocessor.notification.receiver.NotificationReceiver;
import com.salesprocessor.notification.receiver.NotificationReceiverImpl;
import com.salesprocessor.notification.reporter.ReportGenerator;
import com.salesprocessor.notification.reporter.ReportGeneratorImpl;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by amrutaj on 09/05/2017.
 */
public class NotificationProcessorTest {

    private NotificationReceiver notificationReceiver;

    private NotificationDAO notificationDAO;

    private ReportGenerator reportGenerator;

    private NotificationProcessor processor;


    @Before
    public void setUp() throws Exception {

        notificationReceiver= new NotificationReceiverImpl();
        notificationDAO = new NotificationDAOImpl();
        reportGenerator = new ReportGeneratorImpl(notificationDAO);
        processor= new NotificationProcessor(notificationReceiver,reportGenerator,notificationDAO);

        //NotificationMessage -- MessageType1
        Notification notificationMessageType1 = new Notification();
        Product product1 = new Product();
        product1.setProductNmae("Apple");
        product1.setProductPrice(20.0);
        product1.setProductQuantity(2);
        notificationMessageType1.setProduct(product1);
        notificationMessageType1.setMessageType(Notification.MessageType.MESSAGE_TYPE_1);

        //NotificationMessage -- MessageType2
        Notification notificationMessageType2 = new Notification();
        Product product2 = new Product();
        product2.setProductNmae("Apple");
        product2.setProductPrice(20.0);
        notificationMessageType2.setProduct(product2);
        notificationMessageType2.setValue(40.0);
        notificationMessageType2.setMessageType(Notification.MessageType.MESSAGE_TYPE_2);

        //NotificationMessage -- MessageType3
        Notification notificationMessageType3 = new Notification(Notification.Operationtype.ADD, 50.0);
        Product product3 = new Product();
        product3.setProductNmae("Apple");
        product3.setProductPrice(20.0);
        product3.setProductQuantity(2);
        notificationMessageType3.setProduct(product3);
        notificationMessageType3.setMessageType(Notification.MessageType.MESSAGE_TYPE_3);

        //NotificationMessage -- MessageType1
        Notification notificationMessageType4 = new Notification();
        Product product4 = new Product();
        product4.setProductNmae("Banana");
        product4.setProductPrice(20.0);
        product4.setProductQuantity(2);
        notificationMessageType4.setProduct(product4);
        notificationMessageType4.setMessageType(Notification.MessageType.MESSAGE_TYPE_1);


        /*Test set of notifications for firrst 10 messages.*/
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType4);
        /************************************************************/

        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType1);
        notificationReceiver.putNotification(notificationMessageType2);
        notificationReceiver.putNotification(notificationMessageType3);
        notificationReceiver.putNotification(notificationMessageType4);


    }

    @After
    public void tearDown() throws Exception {
        notificationReceiver=null;
        notificationDAO=null;
        reportGenerator=null;
        processor=null;

    }
    @Test
    public void startProcess() throws Exception {
        processor.startProcess();
    }


}