package com.calculator.sopra;

import java.util.Scanner;

import com.calculator.expression.sopra.ExtractExpression;
import com.calculator.expression.sopra.OperatorsAndOperands;
import com.calculator.expression.sopra.SolveExpression;
//import com.calculator.sopra.calculation.Calculator;

public class UserInput {

	protected void getUserInput() {
		boolean keepLooping = true;
		System.out.println("========================================");
		System.out.println("WHAT TYPE OF CALCULATOR YOU WANT TO USE:");
		System.out.println("1. Expression Based Basic Calculator");
		System.out.println("2. User Input Based Basic Calculator");
		System.out.println("3. To Exit");
		System.out.println("========================================");
		Scanner sc = new Scanner(System.in);
		String choice;
		do {
			choice = sc.nextLine();
			if (choice.equals("1")) { // Option 1
				String input = getExpressionInput(sc);
				if (Validations.myValidations(input)) {
					ExtractExpression extExpression = new ExtractExpression();;
					SolveExpression expLogic = new SolveExpression();
					OperatorsAndOperands operatorsAndOperands = extExpression.extract(input);

					System.out.println("RESULT= "+expLogic.logic(
							operatorsAndOperands.getOperatorsList(), 
							operatorsAndOperands.getOperandsList()));
				}
				else {
					System.out.println("Please try again.");
				}
			}
			else if (choice.equals("2")) { // Option 2
				String input = getUserBasedInput(sc);
				if (!input.equals("ERROR")) {	

					ExtractExpression extExpression = new ExtractExpression();;
					SolveExpression expLogic = new SolveExpression();

					OperatorsAndOperands operatorsAndOperands = extExpression.extract(input);

					System.out.println("RESULT= "+expLogic.logic(
							operatorsAndOperands.getOperatorsList(), 
							operatorsAndOperands.getOperandsList()));

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
				System.out.println("You have entered incorrect option.\nTry Again.");
			}
			System.out.println();
			System.out.println("========================================");
			System.out.println("WHAT TYPE OF CALCULATOR YOU WANT TO USE:");
			System.out.println("1. Expression Based Basic Calculator");
			System.out.println("2. User Input Based Basic Calculator");
			System.out.println("3. To Exit");
			System.out.println("========================================");
		}

		while(keepLooping);
	}
	private static String getExpressionInput(Scanner sc) {
		String input;
		System.out.println("ENTER THE EXPRESSION TO THE CALCULATOR:");
		System.out.println("You can perform add(+),sub(-),mul(*),div(/)");
		input = sc.nextLine();
		System.out.println("\nYOU HAVE ENTERED: "+input);
		return input;
	}
	private static String getUserBasedInput(Scanner sc) {
		String num1;
		String num2;
		String operation;
		System.out.println("ENTER FIRST NUMBER");
		num1 = sc.nextLine();
		System.out.println("ENTER OPERATION TO PERFORM ('+','-','*','/'):");
		operation = sc.nextLine();
		System.out.println("ENTER SECOND NUMBER");
		num2 = sc.nextLine();
		System.out.println("\nYOU ARE TRYING: "+num1+operation+num2);
		if (Validations.checkInput(num1,num2,operation)) {
			return num1+operation+num2;
		}
		return "ERROR";
	}
}
