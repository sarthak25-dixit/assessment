package com.test.Task2OnlineSales;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Task2OnlineSalesApplicationTests {

	 @Test // Test the evaluateExpression method for different mathematical expressions
	    void testEvaluateExpression() { // Tested all the expression given in the question
		 
	        assertEquals("32", Task2OnlineSalesApplication.evaluateExpression("2 * 4 * 4"));
	        assertEquals("2.5", Task2OnlineSalesApplication.evaluateExpression("5 / (7 - 5)"));
	        assertEquals("3", Task2OnlineSalesApplication.evaluateExpression("sqrt(5^2 - 4^2)"));
	        assertEquals("5", Task2OnlineSalesApplication.evaluateExpression("sqrt(-3^2 - 4^2)"));
	    }

}
