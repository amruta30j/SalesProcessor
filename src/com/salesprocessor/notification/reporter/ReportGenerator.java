package com.salesprocessor.notification.reporter;

import com.salesprocessor.notification.model.Notification;

import java.util.List;

/**
 * Created by amrutaj on 07/05/2017.
 */
public interface ReportGenerator {

    String generateSummaryReport();

    void generateAdjustmentReport();

}
