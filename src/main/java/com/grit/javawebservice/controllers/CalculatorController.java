package com.grit.javawebservice.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grit.javawebservice.beans.CalculatorBean;

@RestController
public class CalculatorController {

	private CalculatorBean calculation = new CalculatorBean();

	@RequestMapping(value = "calc", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String root() {
		String result = "";
		result += "<html><head><title>Calculator</title></head>";
		result += "<body>";
		result += "<h2>Calculator</h2>";
		result += "<h4>For Addition: http://localhost:8080/calc/plus?nr1=2&nr2=2</h4>";
		result += "<h4>For Substraction: http://localhost:8080/calc/minus?nr1=2&nr2=2</h4>";
		result += "<h4>For Multiplication: http://localhost:8080/calc/times?nr1=2&nr2=2</h4>";
		result += "<form action=\"http://localhost:8080/calc\"  ";
		result += "method=\"POST\">";
		result += "Värde 1: <input type=\"text\" name=\"nr1\">";
		result += "Värde 2: <input type=\"text\" name=\"nr2\">";
		result += "<input type=\"submit\" value=\"add\">";
		result += "</form>";
		result += "</body></html>";
		return result;
	}
	
	

	// Addition
	@RequestMapping(value = {"/calc/plus", "/calc"}, produces = MediaType.APPLICATION_JSON_VALUE, method = { RequestMethod.GET, RequestMethod.POST})
	public String add(String nr1, String nr2) {
		return calculation.Addition(nr1, nr2);
	}

	// Subtraction
	@RequestMapping(value = "/calc/minus", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String sub(String nr1, String nr2) {
		return calculation.Substraction(nr1, nr2);
	}

	// Multiplication
	@RequestMapping(value = "/calc/times", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String mult(String nr1, String nr2) {
		return calculation.Multiplication(nr1, nr2);
	}

}


