package jmart.goldenSample.dataset;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

import jmart.goldenSample.dbjson.Serializable;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL       = "(?!.\\.{2,})(?!\\.)[0-9A-z.&~]+@(?!-)[0-9A-z&*~.-]+";
    public static final String REGEX_PASSWORD    = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public static final Pattern EMAIL_PATTERN    = Pattern.compile(REGEX_EMAIL);
    public static final Pattern PASSWORD_PATTERN = Pattern.compile(REGEX_PASSWORD);
    
    private static final char[] HEX_ARRAY        = "0123456789ABCDEF".toCharArray();

    public String name;
    public String email;
    public String password;

    public Account(String name, String email, String password) throws Throwable, NoSuchAlgorithmException
    {
    	// rules
        if (!EMAIL_PATTERN.matcher(email).matches())
        	throw new Throwable();
        else if (!PASSWORD_PATTERN.matcher(password).matches())
        	throw new Throwable();
    	// hash password
    	MessageDigest sha256 = MessageDigest.getInstance("SHA-256");
    	byte[] hash   = sha256.digest(password.getBytes(StandardCharsets.UTF_8));
    	// assign value
    	this.password = bytesToHex(hash);
    	this.name     = name;
    	this.email    = email;
    }
    
    public static String bytesToHex(byte[] bytes)
    {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++)
        {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2]     = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }
}