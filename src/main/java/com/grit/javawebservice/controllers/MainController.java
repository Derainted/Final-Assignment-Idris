package com.grit.javawebservice.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController implements ErrorController {

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = MediaType.TEXT_HTML_VALUE)
	public String root() {
		String index = "";
		index += "<html><head><title>Api Documentation</title></head>";
		index += "<body>";
		index += "<h2>API documentation for java web service final assignment</h2>";
		index += "<h3>1 - Calculator Project</h3>";
		index += "<h3>Instructions to use calculator are down below.</h3>";
		index += "<h5>For Addition: http://localhost:8080/calc/plus?nr1=2&nr2=2</h5>";
		index += "<h5>For Substraction: http://localhost:8080/calc/minus?nr1=2&nr2=2</h5>";
		index += "<h5>For Multiplication: http://localhost:8080/calc/times?nr1=2&nr2=2</h5>";
		index += "<form action=\"http://localhost:8080/calc\"  ";
		index += "method=\"POST\">";
		index += "Value 1: <input type=\"text\" name=\"nr1\">";
		index += "Value 2: <input type=\"text\" name=\"nr2\">";
		index += "<input type=\"submit\" value=\"add\">";
		index += "</form>";
		index += "<ul>";
		index += " <li><a href=\"/calc\">Use Calculator</a></li> ";
		index += "</ul>";
		index += "<h3>2 - RSP Project</h3>";
		index += "<h5>Use rsp.html inside resourse folder to play RSP game</h5>";
		index += "<ul>";
		index += " <li><a href=\"/rps\">Here can you see the total score for RSP game.</a></li> ";
		index += "</ul>";
		index += "<h3>3 - CSV file to JSON</h3>";
		index += " <li><a href=\"/showcsvfile\">Here can you look at CSV's JSON version.</a></li> ";
		index += "<h3>4 - Images</h3>";
		index += "<h5>I have uploaded 3 different png pictures and by refreshing the page you can see a new different pic.</h5>";
		index += " <li><a href=\"/images\">Here can you look at them</a></li> ";
		index += "</body></html>";
	
		
		return index;
	}

	
	
	private static final String PATH = "/error";

	@RequestMapping(value = PATH, produces = MediaType.TEXT_HTML_VALUE)
	public String error() {
		return "Opps something went wrong please check URL and try again" + root() ;
	}

	public String getErrorPath() {
		
		return PATH;
	}


}
