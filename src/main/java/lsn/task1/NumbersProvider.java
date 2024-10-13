package lsn.task1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class NumbersProvider {

	protected static void provideNumbersAndProcess() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter integers separated by commas (press Enter when done):");
		String input = scanner.nextLine();

		String cleanedInput = input.replaceAll("[^0-9,]", "");

		List<Integer> inputList = Arrays.stream(cleanedInput.split(",")).map(String::trim).filter(s -> !s.isEmpty()).map(Integer::parseInt)
				.collect(Collectors.toList());

		DistinctElementsWithStats stats = DistinctElementsWithStats.sortDistinctListWithStats(inputList);

		System.out.println("Original List: " + inputList);
		System.out.println("Sorted Distinct List: " + stats.getSortedDistinctList());
		System.out.println("Number of elements: " + stats.getTotalElements());
		System.out.println("Number of distinct elements: " + stats.getTotalDistinctElements());
		System.out.println("Minimum value: " + stats.getMinValue());
		System.out.println("Maximum value: " + stats.getMaxValue());

		scanner.close();
	}
}
