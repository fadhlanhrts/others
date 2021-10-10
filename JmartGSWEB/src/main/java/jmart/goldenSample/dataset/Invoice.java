package jmart.goldenSample.dataset;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jmart.goldenSample.dbjson.Serializable;

public abstract class Invoice extends Serializable
{
    public enum Status { WAITING_CONFIRMATION, CANCELLED, ON_PROGRESS, ON_DELIVERY, DELIVERED, COMPLAINT, FINISHED, FAILED }

    public enum Rating { NONE, BAD, NEUTRAL, GOOD }

    public static class Record
    {
        public Status status;
        public Date date;
        public String message;
        public Record(Status status, String message)
        {
        	this.status  = status;
        	this.date    = new Date();
        	this.message = message;
        }
    }

    public int buyerId;
    public int productId;
    public int complaintId;
    public Rating rating;
    private ArrayList<Record> history;
    private InvoiceUpdateListener listener;

    protected Invoice(int buyerId, int productId)
    {
        this.buyerId     = buyerId;
        this.productId   = productId;
        this.complaintId = -1;
        this.rating      = Rating.NONE;
        this.history     = new ArrayList<Record>();
    }
    
    public abstract double getTotalPay();
    
    public void setInvoiceUpdateListener(InvoiceUpdateListener listener) { this.listener = listener; }
    
    public List<Record> getRecords() { return history; }
    
    public void updateRecord(Status status, String message)
    {
    	final Record record = new Record(status, message);
    	history.add(record);
    	if (listener != null && status == Status.WAITING_CONFIRMATION)
    		listener.onTransactionInit(this);
    	else if (listener != null && status == Status.CANCELLED || status == Status.FAILED || status == Status.FINISHED)
    		listener.onTransactionDismissed(this);
    }
    
    @JsonIgnore
    public Record getCurrentRecord()
    {
    	if (history.isEmpty())
    		return null;
    	return history.get(history.size() - 1);
    }
}