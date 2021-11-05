package MelchiorJmartFH;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Store extends Recognizable {
	public static final String REGEX_PHONE = "^([0-9]{9,12})$";
	public static final String REGEX_NAME = "[A-Z]([a-z|A-Z]{3,19})";
	public String name;
	public String address;
	public String phoneNumber;
	public double balance;
	int var_1;

	public Store(String name, String address, String phoneNumber, double balance) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.balance = balance;

	}

	public String toString() {
		return "name : " + this.name + "\n address : " + this.address + "\n phoneNumber : " + this.phoneNumber;
	}

	public boolean validate() {
		Pattern pattern1 = Pattern.compile(REGEX_PHONE);
		Matcher matcher1 = pattern1.matcher(phoneNumber);
		boolean matchFound1 = matcher1.find();

		Pattern pattern2 = Pattern.compile(REGEX_NAME);
		Matcher matcher2 = pattern2.matcher(name);
		boolean matchFound2 = matcher2.find();

		return matchFound1 & matchFound2;
	}

}
