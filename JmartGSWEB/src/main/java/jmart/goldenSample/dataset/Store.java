package jmart.goldenSample.dataset;

import jmart.goldenSample.dbjson.Serializable;

public class Store extends Serializable
{
    public String name;
    public String address;
    public String phoneNumber;

    public Store(String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Store(Account account, String name, String address, String phoneNumber)
    {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }
}
