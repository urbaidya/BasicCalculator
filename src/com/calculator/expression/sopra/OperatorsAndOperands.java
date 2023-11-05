package com.calculator.expression.sopra;

import java.util.Queue;

public class OperatorsAndOperands {

	private Queue<Character> operatorsList;
	private Queue<Double> operandsList;
	public OperatorsAndOperands(Queue<Character> operatorsList, Queue<Double> operandsList) {
		this.operatorsList = operatorsList;
		this.operandsList = operandsList;
	}
	public Queue<Character> getOperatorsList() {
		return operatorsList;
	}
	public Queue<Double> getOperandsList() {
		return operandsList;
	}
}
