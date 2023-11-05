package com.calculator.expression.sopra;

import java.util.LinkedList;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractExpression {
	
	private Queue<Character> operatorsList;
	private Queue<Double> operandsList;
	private String number;
	private Pattern pattern;
	private Matcher matcher;
	
	public ExtractExpression() {
		operatorsList = new LinkedList<>();
		operandsList = new LinkedList<>();
		number = "";
		pattern = Pattern.compile("[0-9.]");
	}

	public OperatorsAndOperands extract(String input) {
		
		for (int i=0; i<input.length() ;i++) { //loop over input
			String c = String.valueOf(input.charAt(i)); //get each character of input
			matcher = pattern.matcher(c); 
			if (matcher.find()) { //check to see if its digits 
				number+=c; //add to numbers if its digit
			}
			else {
				operatorsList.add(c.charAt(0)); // store operator
				operandsList.add(Double.parseDouble(number)); //store the number
				number=""; //reset number
			}
		}
		operandsList.add(Double.parseDouble(number));
//		System.out.println(operandsList);
//		System.out.println(operatorsList);
		OperatorsAndOperands operatorsAndOperands = new OperatorsAndOperands(
				operatorsList, operandsList);
		return operatorsAndOperands;
	}
}
