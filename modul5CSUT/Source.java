package modul5CSUT;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

import com.NetlabUT.NetlabTestApp;

public class Source 
{
	public static void main(String[] args) throws Throwable
	{
		ArrayList<String> packages = new ArrayList<>(20);
		File file = new File(System.getProperty("user.dir") + "/TestedPackages.txt");
		Scanner reader = new Scanner(file);
		reader.forEachRemaining(string -> packages.add(string));
		NetlabTestApp.runReflect(Source.class, "Modul 5 CS", packages.toArray(new String[0]));
	}
}