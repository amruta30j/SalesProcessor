package com.salesprocessor.notification.reporter;

import com.salesprocessor.notification.dao.NotificationDAO;
import com.salesprocessor.notification.model.Notification;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class ReportGeneratorImpl implements ReportGenerator {


    private  NotificationDAO notificationDAO;
    public ReportGeneratorImpl(NotificationDAO notificationDAO) {
        this.notificationDAO = notificationDAO;
    }

    @Override
    public String generateSummaryReport() {

        //Collect all different products in map and sum their value
        // Map of ProductName(String) and Value(Double)
        Map<String, Double> productValueMap = new HashMap<String, Double>();

        List<Notification> allNotifications = notificationDAO.getAllNotifications();

        for(Notification n : allNotifications){
            Double sumValue = productValueMap.get(n.getProduct().getProductNmae());

            if(sumValue == null) {
                sumValue = 0.0;
            }

            sumValue += n.getValue();

            productValueMap.put(n.getProduct().getProductNmae(), sumValue);

        }

        return productValueMap.toString();
    }

    @Override
    public void generateAdjustmentReport() {
        //Collect all different products in map
        // find only the sales that have adjustment applied
        List<Notification> allNotifications = notificationDAO.getAllNotifications();

        String report = "";
        Double adjustmentValue=0.0D;
        System.out.println("Logging a report of the adjustments for a notification..........");
        for(Notification n : allNotifications){
            if(n.getAdjusted())
            {
                report=n.getProduct().getProductNmae();
                if(n.getAdjustment()!=null && n.getAdjustment()>0.0D)
                adjustmentValue=n.getAdjustment();
                System.out.println("Product Name :"+report+ ",  adjustment made :"+adjustmentValue +". value after " +
                        "adjustment made :" +n.getValue());
            }

        }

    }
}
