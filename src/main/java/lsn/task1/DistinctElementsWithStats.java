package lsn.task1;

import java.util.List;
import java.util.NoSuchElementException;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DistinctElementsWithStats {

	private int totalElements;
	private List<Integer> sortedDistinctList;
	private int totalDistinctElements;
	private int minValue;
	private int maxValue;

	public static DistinctElementsWithStats sortDistinctListWithStats(List<Integer> inputList) {

		if (inputList.isEmpty()) {
			return new DistinctElementsWithStats(0, List.of(), 0, 0, 0);
		}

		List<Integer> sortedDistinctList = inputList.stream().distinct().sorted().toList();

		int totalElements = inputList.size();
		int totalDistinctElements = sortedDistinctList.size();
		int minValue = sortedDistinctList.stream().min(Integer::compareTo).orElseThrow(NoSuchElementException::new);
		int maxValue = sortedDistinctList.stream().max(Integer::compareTo).orElseThrow(NoSuchElementException::new);

		return new DistinctElementsWithStats(totalElements, sortedDistinctList, totalDistinctElements, minValue, maxValue);
	}
}
