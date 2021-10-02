package goldenSample;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable implements FileParser {
    public static final String REGEX_EMAIL = "(?!.\\.{2,})(?!\\.)[0-9A-z.&~]+@(?!-)[0-9A-z&*~.-]+";
    public static final String REGEX_PASSWORD = "(?=^.{8,}$)((?=.*\\d)|(?=.*\\W+))(?![.\\n])(?=.*[A-Z])(?=.*[a-z]).*$";
    public String name;
    public String email;
    public String password;

    public Account(int id, String name, String email, String password) {
        super(id);
        this.name = name;
        this.email = email;
        this.password = password;
    }

    @Override
    public boolean read(String content) {
        // TODO Auto-generated method stub
        return false;
    }


    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher2 = pattern2.matcher(password);
        return matcher.find() && matcher2.find();
    }

}