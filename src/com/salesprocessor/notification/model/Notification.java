package com.salesprocessor.notification.model;

import java.util.function.DoubleBinaryOperator;

/**
 * Created by amrutaj on 07/05/2017.
 */
public class Notification {

    private  Product product;
    private  Double value;
    private  MessageType messageType;
    private  Operationtype operationtype;
    private  Double adjustment;
    private  boolean adjusted = false;

    //default constructor
    public Notification() {
    }

    //if the notification is of type message type 3
    //then the operation type has to be specified.
    public Notification(Operationtype operationtype, Double adjustment) {
        this.operationtype = operationtype;
        this.adjustment= adjustment;
    }

    public boolean getAdjusted() {
        return adjusted;
    }

    public void setAdjusted(boolean adj) {
        this.adjusted = adj;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public Operationtype getOperationtype() {
        return operationtype;
    }

    public void setOperationtype(Operationtype operationtype) {
        this.operationtype = operationtype;
    }

    public Double getAdjustment() {
        return adjustment;
    }

    public void setAdjustment(Double adj) {
        this.adjustment = adj;
    }

    public static enum MessageType {

        MESSAGE_TYPE_1("MessageType1"),
        MESSAGE_TYPE_2("MessageType2"),
        MESSAGE_TYPE_3("MessageType3");

        private final String messageType;

        private MessageType(String messageType) {
            this.messageType = messageType;
        }

        public String getMessageType() {
            return messageType;
        }
    }

    public static enum Operationtype implements DoubleBinaryOperator{

        ADD((x, y) -> (x + y), "Add"),
        SUBTRACT((x, y) -> (x - y), "Subtract"),
        MULTIPLY((x, y) -> (x * y), "Multiply"),
        DIVIDE((x, y) -> (x / y), "Divide");

        private final DoubleBinaryOperator function;
        private final String Op;


        Operationtype(DoubleBinaryOperator function, String Op) {
            this.function = function;
            this.Op = Op;
        }

        public DoubleBinaryOperator getFunction() {
            return function;
        }

        public String getOp() {
            return Op;
        }

        @Override
        public double applyAsDouble(double x, double y) {
            return function.applyAsDouble(x,y);
        }
    }
}
