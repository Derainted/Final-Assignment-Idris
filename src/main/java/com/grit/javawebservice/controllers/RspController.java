package com.grit.javawebservice.controllers;

import java.util.ArrayList;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grit.javawebservice.beans.RspBean;

@RestController
public class RspController {

private static RspBean game = new RspBean();
	
	@RequestMapping(method = { RequestMethod.POST }, path = "/rps")
	public static String rps(String userInput) {
		
		System.out.println(userInput);
		
		ArrayList<String> compInput = new ArrayList<String>();
		compInput.add("rock");
		compInput.add("paper");
		compInput.add("scissor");
		
           // generating the index using Math.random()
            int index = (int)(Math.random() * compInput.size());
            String compchoice = compInput.get(index);
        
		
		if(userInput.equals(compchoice)) {
			game.addResult("tie");
			return "tie";
		}else if(userInput.equals("rock") && compchoice.equals(compInput.get(2))) {
			game.addResult("loss");
			return "you lose";
		}else if(userInput.equals("rock") && compchoice.equals(compInput.get(1))) {
			game.addResult("win");
			return "you win";
		}else if(userInput.equals("paper") && compchoice.equals(compInput.get(2))) {
			game.addResult("win");
			return "you win";
		}else if(userInput.equals("paper") && compchoice.equals(compInput.get(0))) {
			game.addResult("loss");
			return "you lose";
		}
		else if(userInput.equals("scissor") && compchoice.equals(compInput.get(1))) {
			game.addResult("win");
			return "you win";
		}
		else if(userInput.equals("scissor") && compchoice.equals(compInput.get(0))) {
			game.addResult("loss");
			return "you lose";
		}else {
			return "something went wrong";
		}
		
		
	}
	
	@RequestMapping(value = "/rps", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showMatches() { 
		String result = "";
	
		result += game.toJsonString() + ",";
		
		if (result.length() > 2){
			result = result.substring(0, result.length() - 1);
		}
		
		result = "{ \"Games\":  [" + result + "] }";
		
		return result;
		
	}


}
