package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of class Transaction here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public interface Transactor 
{
    public abstract boolean validate();
    public abstract Invoice perform();  
    
}
