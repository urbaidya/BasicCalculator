package com.sopra.calculator.services;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Validations {

	protected static boolean myValidations(String input) {
		
		// The expression entered can't be empty or spaces
		if (input.trim().equals("")) {
			System.out.println("It is Spaces or Empty expression.");
			return false;
		}
		
		// Only digits and +,-,*,/,. are allowed
		Pattern pattern = Pattern.compile("[^0-9+\\-*/.]");
		Matcher matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Illegal Character/s in the expression you have entered.");
			return false;
		}
		
		// +,-,*,/ can't be start or end of the expression
		pattern = Pattern.compile("[^0-9]+$");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Issue in the expression. \nLast character can't be an operator.");
			return false;
		}
		pattern = Pattern.compile("^[^0-9]+");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Issue in the expression. \nFirst character can't be an operator.");
			return false;
		}
		
		// Multiple operators together in the input
		pattern = Pattern.compile("\\+{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '+' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\-{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '-' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\*{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '*' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\/{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '/' together in the expression.");
			return false;
		}
		pattern = Pattern.compile("\\.{2,}");
		matcher = pattern.matcher(input);
		if (matcher.find()) {
			System.out.println("Multiple '.' together in the expression.");
			return false;
		}
		return true;
	}

	protected static boolean checkInput(String num1, String num2, String operation) {
		Pattern pattern = Pattern.compile("[^0-9.]");
		Matcher matcher = pattern.matcher(num1);
		if (matcher.find()) {
			System.out.println("First Number entered is not a Number.");
			return false;
		}
		matcher = pattern.matcher(num2);
		if (matcher.find()) {
			System.out.println("Second Number entered is not a Number.");
			return false;
		}
		pattern = Pattern.compile("[^+\\-*/]");
		matcher = pattern.matcher(operation);
		if (matcher.find()) {
			System.out.println("Incorrect Operation Entered.");
			return false;
		}
		return true;
	}
}
