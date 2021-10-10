package jmart.goldenSample.dataset;

import jmart.goldenSample.dbjson.Serializable;

public class Store extends Serializable
{
	public static final String REGEX_PHONE = "^\\d{9,12}$";
    public static final String REGEX_NAME  = "^[A-Z](?!.*(\\s)\\1).{4,20}$";
    
    public String name;
    public String address;
    public String phoneNumber;
    public double balance;

    public Store(String name, String address, String phoneNumber, double balance)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
}
