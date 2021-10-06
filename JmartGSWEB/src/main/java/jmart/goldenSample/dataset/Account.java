package jmart.goldenSample.dataset;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jmart.goldenSample.dbjson.Serializable;

public class Account extends Serializable
{
    public static final String REGEX_EMAIL       = "(?!.\\.{2,})(?!\\.)[0-9A-z.&~]+@(?!-)[0-9A-z&*~.-]+";
    public static final String REGEX_PASSWORD    = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";

    public static final Pattern EMAIL_PATTERN    = Pattern.compile(REGEX_EMAIL);
    public static final Pattern PASSWORD_PATTERN = Pattern.compile(REGEX_EMAIL);

    public String name;
    public String email;
    public String password;

    public Account(String name, String email, String password)
    {
        if (EMAIL_PATTERN.matcher(email).matches())
            this.email = email;
        if (PASSWORD_PATTERN.matcher(password).matches())
            this.password = password;
        this.name = name;
    }
}