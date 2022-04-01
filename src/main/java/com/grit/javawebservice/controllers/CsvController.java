package com.grit.javawebservice.controllers;

import java.io.IOException;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.grit.javawebservice.beans.CsvBean;

@RestController
public class CsvController {

	//@RequestMapping(value = "/showCsvFile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	//public void showCsvFile(HttpServletResponse response) throws IOException {
	//	var csvFile = new ClassPathResource("sample.csv");

	//	response.setContentType(MediaType.TEXT_PLAIN_VALUE);
	//	StreamUtils.copy(csvFile.getInputStream(), response.getOutputStream());
	//}

	@RequestMapping(value = "/showcsvfile", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public String showCsvFileScanner() throws IOException {
		CsvBean myReader = new CsvBean();

		String text = myReader.readFile("sample.csv");
		return text;
	}

}
