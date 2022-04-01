package com.grit.javawebservice.beans;

public class CalculatorBean {

	private String pattern = "{ \"Result\":\"%s\"}";
	private final String inputError = "[ \" Please write correct input value \" ]";

	public CalculatorBean() {
	}

	public String Substraction(String nr1, String nr2) {

		String result = "";
		try {
			result = String.format(pattern, Integer.valueOf(nr1) - Integer.valueOf(nr2));
		} catch (NumberFormatException e) {
			result = inputError;
		}
		return result;
	}

	public String Addition(String nr1, String nr2) {
		String result = "";

		try {
			result = String.format(pattern, Integer.valueOf(nr1) + Integer.valueOf(nr2));
		} catch (NumberFormatException e) {
			result = inputError;
		}

		return result;

	}

	public String Multiplication(String nr1, String nr2) {
		String result = "";

		try {
			result = String.format(pattern, Integer.valueOf(nr1) * Integer.valueOf(nr2));
		} catch (NumberFormatException e) {
			result = inputError;
		}

		return result;
	}

}
