package com.test.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Boo {
public static void main(String[] args) {
	String str=" abc d 1234567890pqr 54897";
	Pattern pattern = Pattern.compile("\\w+([0-9]+)\\w+([0-9]+)");
	Matcher matcher = pattern.matcher(str);
	for(int i = 0 ; i < matcher.groupCount(); i++) {
	  matcher.find();
	  System.out.println(matcher.group());
	}
	
	
	String str2=" a234432bc3fdsd 1234sdf234567890pqr 54897";

	Pattern p2 = Pattern.compile("(\\d+)");
	Matcher m2 = p2.matcher(str2);
	while(m2.find())
	{
	    System.out.println(m2.group(1));
	}
	
	
	
	 String str3 = "abc d 1234567890pqr 54897";
	    StringBuilder myNumbers3 = new StringBuilder();
	    for (int i = 0; i < str3.length(); i++) {
	        if (Character.isDigit(str3.charAt(i))) {
	            myNumbers3.append(str3.charAt(i));
	            System.out.println(str3.charAt(i) + " is a digit.");
	        } else {
	            System.out.println(str.charAt(i) + " not a digit.");
	        }
	    }
	    System.out.println("Your numbers: " + myNumbers3.toString());
}
}
