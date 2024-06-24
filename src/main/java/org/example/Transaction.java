package org.example;

import java.util.Date;

public class Transaction {
    private String transactionId;

    private String sender;

    private String recipient;

    private double amount;

    private long timeStamp;

    public Transaction(String sender,String recipient,double amount){
        this.sender = sender;
        this.recipient = recipient;
        this.amount = amount;
        this.timeStamp = new Date().getTime();
        this.transactionId = calculateHash();
    }

    public String calculateHash(){
        String dataToHash = sender+recipient+Double.toString(amount)+timeStamp;
        return Util.applySha256(dataToHash);
    }

    public Boolean processTransaction(){
        return true;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
