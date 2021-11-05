package AidanAzkafaroDesonJmartFH;


/**
 * Write a description of interface FileParser here.
 *
 * @author (Aidan Azkafaro Deson)
 * @version (a version number or a date)
 */
public interface FileParser
{
   boolean read (String content);
   default Object write(){return null;};
   default Object newInstance (String content){return null;};
}
