package com.calculator.expression.sopra;

import java.util.LinkedList;

import com.calculator.sopra.calculation.Calculator;

public class SolveExpression {
	
	private Calculator calculator;
	private double result;
	private double nextOperand;
	
	public SolveExpression(){
		calculator = new Calculator();
		nextOperand = 0;
	}
	
	public double logic(LinkedList<Character> operatorsList, LinkedList<Double> operandsList) {
		result=operandsList.remove();
		
		for (char operator: operatorsList) { //looping over all operators list
			nextOperand = operandsList.remove();
			
			//call the function to resolve each operator
			result = calculator.calculate(result, nextOperand, operator);
		}
		return result;
	}
}
