import java.util.List;

import org.junit.jupiter.api.Test;

import lsn.task1.DistinctElementsWithStats;

import static org.assertj.core.api.Assertions.assertThat;

public class DistinctElementsWithStatsTest {

	@Test
	public void sortDistinctListWithStats_WithStats_ShouldReturnCorrectStats() {
		// Given
		List<Integer> inputNumbers = List.of(1, 2, 2, 3, 4, 5, 5, 6, 7, 8, 9, 10, 10, 10);

		// When
		DistinctElementsWithStats stats = DistinctElementsWithStats.sortDistinctListWithStats(inputNumbers);

		// Then
		assertThat(stats.getSortedDistinctList()).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		assertThat(stats.getTotalElements()).isEqualTo(14);
		assertThat(stats.getTotalDistinctElements()).isEqualTo(10);
		assertThat(stats.getMinValue()).isEqualTo(1);
		assertThat(stats.getMaxValue()).isEqualTo(10);
	}

	@Test
	public void sortDistinctListWithStats_ShouldHandleEmptyListWithStats() {
		// Given
		List<Integer> inputNumbers = List.of();

		// When
		DistinctElementsWithStats stats = DistinctElementsWithStats.sortDistinctListWithStats(inputNumbers);

		// Then
		assertThat(stats.getSortedDistinctList()).isEmpty();
		assertThat(stats.getTotalElements()).isEqualTo(0);
		assertThat(stats.getTotalDistinctElements()).isEqualTo(0);
	}

	@Test
	public void sortDistinctListWithStats_ShouldHandleSingleElementListWithStats() {
		// Given
		List<Integer> inputNumbers = List.of(42);

		// When
		DistinctElementsWithStats stats = DistinctElementsWithStats.sortDistinctListWithStats(inputNumbers);

		// Then
		assertThat(stats.getSortedDistinctList()).containsExactly(42);
		assertThat(stats.getTotalElements()).isEqualTo(1);
		assertThat(stats.getTotalDistinctElements()).isEqualTo(1);
		assertThat(stats.getMinValue()).isEqualTo(42);
		assertThat(stats.getMaxValue()).isEqualTo(42);
	}

	@Test
	public void sortDistinctListWithStats_WithStats_ShouldHandleNegativeValues() {
		// Given
		List<Integer> inputNumbers = List.of(-1, -2, -2, -3, -4, -5, -5, -6, -7);

		// When
		DistinctElementsWithStats stats = DistinctElementsWithStats.sortDistinctListWithStats(inputNumbers);

		// Then
		assertThat(stats.getSortedDistinctList()).containsExactly(-7, -6, -5, -4, -3, -2, -1);
		assertThat(stats.getTotalElements()).isEqualTo(9);
		assertThat(stats.getTotalDistinctElements()).isEqualTo(7);
		assertThat(stats.getMinValue()).isEqualTo(-7);
		assertThat(stats.getMaxValue()).isEqualTo(-1);
	}
}
