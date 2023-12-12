package com.test.Task2OnlineSales;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Task2OnlineSalesApplication {

	private static final String API_BASE_URL = "https://api.mathjs.org/v4/"; // Base URL for the math expression
										 // evaluation API

	public static void main(String[] args) throws IOException { // Main method to take user input and display results
		SpringApplication.run(Task2OnlineSalesApplication.class, args);

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in)); // Create a buffered reader to read user input from the
						         				      // console

		try {
			String expression;
			while (true) {
				System.out.print("Enter expression (type 'end' to finish): "); // Continue taking expressions until the
											       // user enters 'end'
				expression = reader.readLine();
				if (expression.equals("end")) {
					break;
				}

				String result = evaluateExpression(expression); // Evaluate the expression using the API and display the
									        // result
				System.out.println(expression + " => " + result);
			}
		} catch (Exception e) { // Handle exceptions that may occur during input or evaluation
			e.printStackTrace();
			
		}
	}

	public static String evaluateExpression(String expression) { // Method to evaluate a mathematical expression using
								     // the API
		try {
			URL url = new URL(API_BASE_URL + "?expr=" + expression); // Construct the URL for the API request
			HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection to the API
			connection.setRequestMethod("GET");

			BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream())); // Read the
																											// response
																											// from the
																											// API
			String line;
			StringBuilder response = new StringBuilder();

			while ((line = reader.readLine()) != null) {
				response.append(line);
			}
			reader.close();

			connection.disconnect(); // Disconnect the connection after reading the response
			return response.toString();
		} catch (Exception e) {
			e.printStackTrace(); // Handle exceptions, such as network errors or API issues
			return "Error evaluating expression";
		}
	}
}
