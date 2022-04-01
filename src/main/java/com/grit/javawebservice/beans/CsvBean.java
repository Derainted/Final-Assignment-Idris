package com.grit.javawebservice.beans;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;

public class CsvBean {

	public String readFile(String fileName) throws FileNotFoundException, IOException {

		var csvFile = new ClassPathResource(fileName);

		String beginning = "[";
		
		String ending = "]";
		
		String braces = "{";
		
		String endBraces = "}";
		
		String separetor = ",";
		
		String backSlash = "\"";

		
		
		
		// 
		String result = beginning;
		int parseCSVtoJSON = 0;
		
		ArrayList<String> JSONkeys = new ArrayList<String>();
		
		ArrayList<String> JSONvalues = new ArrayList<String>();

		try (Scanner myScanner = new Scanner(csvFile.getFile())) {
			while (myScanner.hasNextLine()) {
				switch (parseCSVtoJSON) {
				case 0:
					JSONkeys = getJSONkeys(myScanner.nextLine());
					parseCSVtoJSON = 1;
					break;
					
				case 1:
					JSONvalues = getJSONValues(myScanner.nextLine());
					result += braces;

					for (int i = 0; i < JSONkeys.size(); i++) {
						result += backSlash + JSONkeys.get(i) + backSlash + ":" + //
								backSlash + JSONvalues.get(i) + backSlash;

						if (i < JSONkeys.size() - 1)
							result += separetor;
					}
					result += endBraces;

					if (myScanner.hasNextLine())
						result += separetor;
					break;

				default:
					break;
				}
			}
			result += ending;

		} catch (FileNotFoundException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		return result;
	}

	
	
	
	
	
	
	
	
	private String processLine(String textLine) {
		String result = "";

		Scanner rowScanner = new Scanner(textLine);
		rowScanner.useDelimiter(",");

		while (rowScanner.hasNext()) {
			result += rowScanner.next() + " :: ";
		}

		rowScanner.close();

		return result;
	}

	private ArrayList<String> getJSONkeys(String CSVString) {

		ArrayList<String> JSONkeys = new ArrayList<String>();

		Scanner rowScanner = new Scanner(CSVString);
		rowScanner.useDelimiter(",");

		while (rowScanner.hasNext()) {
			JSONkeys.add(rowScanner.next());
		}

		rowScanner.close();

		return JSONkeys;
	}

	private ArrayList<String> getJSONValues(String CSVString) {

		ArrayList<String> JSONvalues = new ArrayList<String>();

		Scanner rowScanner = new Scanner(CSVString);
		rowScanner.useDelimiter(",");

		while (rowScanner.hasNext()) {
			JSONvalues.add(rowScanner.next());
		}
		rowScanner.close();
		return JSONvalues;
	}

	private String connectJSONKeysValues(ArrayList<String> JSONkeys, ArrayList<String> JSONvalues) {
		String JSONkeyValues = null;

		for (int i = 0; i < JSONkeys.size(); i++) {

			JSONkeyValues += JSONkeys.get(i) + ":" + JSONvalues.get(i);

		}

		return JSONkeyValues;
	}

	
	
	
	
	private String JSONparser(String CSVstring) {
		String resultJSON = "";
		ArrayList<String> keys = new ArrayList<String>();
		String CSVseparator = ",";
		String JSONseparator = ",";
		String JSONstart = "\"[";
		String JSONend = "\"]";
		String JSONstartKeyValuePair = "{";
		String JSONendKeyValuePair = "}";

		return resultJSON;
	}
}
