package com.calculator.sopra;

import java.util.Scanner;

import com.calculator.expression.sopra.ExtractExpression;

public class UserInput {

	protected void getUserInput() {
		boolean keepLooping = true;
		System.out.println("WHAT TYPE OF CALCULATOR YOU WANT TO USE:");
		System.out.println("1. Expression Based Basic Calculator");
		System.out.println("2. User Input Based Basic Calculator");
		System.out.println("3. To Exit");
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			choice = sc.nextLine();
			if (choice.equals("1")) { // Option 1
				String input = getExpressionInput(sc);
				if (Validations.myValidations(input)) {
					ExtractExpression extExpression = new ExtractExpression();
					System.out.println("RESULT= "+extExpression.extract(input));
				}
				else {
					System.out.println("Please try again.");
				}
			}
			else if (choice.equals("2")) { // Option 2
				String input = getUserBasedInput(sc);
				if (!input.equals("ERROR")) {
					if (Validations.myValidations(input)) {
						ExtractExpression extExpression = new ExtractExpression();
						System.out.println("RESULT= "+extExpression.extract(input));
					}
					else {
						System.out.println("Please try again.");
					}
				}
				else {
					System.out.println("Please try again.");
				}
			}
			else if (choice.equals("3")) {
				System.out.println("SEE YOU AGAIN.. !!");
				break;
			}
			else {
				System.out.println("You have entered incorrect option.");
			}
			System.out.println();
			System.out.println("WHAT TYPE OF CALCULATION YOU WANT TO DO:");
			System.out.println("1. Expression Based Basic Calculator");
			System.out.println("2. User Input Based basic Calculator");
			System.out.println("3. To Exit");
			System.out.println();
		}

		while(keepLooping);
	}
	private static String getExpressionInput(Scanner sc) {
		String input;
		System.out.println("ENTER THE EXPRESSION TO THE CALCULATOR\n");
		input = sc.nextLine();
		return input;
	}
	private static String getUserBasedInput(Scanner sc) {
		String num1;
		String num2;
		String operation;
		System.out.println("ENTER FIRST NUMBER");
		num1 = sc.nextLine();
		System.out.println("ENTER SECOND NUMBER");
		num2 = sc.nextLine();
		System.out.println("ENTER OPERATION TO PERFORM (+,-,*,/):");
		operation = sc.nextLine();
		System.out.println("\nYOU ARE TRYING: "+num1+operation+num2);
		if (Validations.checkInput(num1,num2,operation)) {
			return num1+operation+num2;
		}
		return "ERROR";
	}
}
