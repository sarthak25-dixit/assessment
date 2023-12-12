package main.java;

import java.util.List;
import java.util.Map;
import java.util.Random;
public class BiasedEventSimulation {

	public static String simulateEvent(List<Map.Entry<Integer, Integer>> outcomes, int numberOfOccurrences) {
		// Method to simulate an event based on the given biased outcomes

		int[] occurrences = new int[outcomes.size()]; // Array to store the occurrences of each outcome
		Random random = new Random(); // Random number generator for simulating events

		for (int i = 0; i < numberOfOccurrences; i++) { // Loop through the specified number of occurrence

			int randomNumber = random.nextInt(100) + 1;
			int cumulativeProbability = 0; // Variable to keep track of cumulative probability

			for (int j = 0; j < outcomes.size(); j++) { // Loop through each outcome and check if the random number
								    // falls within its probability range
				cumulativeProbability += outcomes.get(j).getValue();

				if (randomNumber <= cumulativeProbability) { // If the random number is less than or equal to the
									     // cumulative probability, choose this outcome
					occurrences[j]++;
					break;
				}
			}
		}

		StringBuilder result = new StringBuilder(); // Build a string summarizing the results
		for (int i = 0; i < outcomes.size(); i++) {
			result.append("Outcome ").append(outcomes.get(i).getKey()).append(" appeared ").append(occurrences[i])
					.append(" times, ");
		}

		return result.toString();
	}

	// Sample unit test cases using JUnit

	public static void main(String[] args) {

		// Test Case 1: Simulating a biased six-faced dice
		List<Map.Entry<Integer, Integer>> biasedDice = List.of(Map.entry(1, 10), Map.entry(2, 30), Map.entry(3, 15),
				Map.entry(4, 15), Map.entry(5, 30), Map.entry(6, 0));
		System.out.println("Test Case 1: " + simulateEvent(biasedDice, 1000));

		// Test Case 2: Simulating a biased coin flip
		List<Map.Entry<Integer, Integer>> biasedCoin = List.of(Map.entry(1, 35), // Head
				Map.entry(2, 65) // Tail
		);
		System.out.println("Test Case 2: " + simulateEvent(biasedCoin, 1000));
	}
}
