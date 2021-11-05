package MelchiorJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account extends Recognizable {
	public String name;
	public String email;
	public String password;
	public double balance;
	public Store store;
	public static final String REGEX_EMAIL = "^\\w+([.&`~-]?\\w+)*@\\w+([.-]?\\w+)+$";
	public static final String REGEX_PASSWORD = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d][^-\\s]{8,}$";

	public boolean validate() {
		Pattern pattern1 = Pattern.compile(REGEX_EMAIL);
		Matcher matcher1 = pattern1.matcher(email);
		boolean matchFound1 = matcher1.find();

		Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
		Matcher matcher2 = pattern2.matcher(password);
		boolean matchFound2 = matcher2.find();

		return matchFound1 & matchFound2;
	}

	public Account(int id, String name, String email, String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}

	

}
