package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import java.util.stream.Stream;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;


class TestDemoJUnitTest {
	private TestDemo testDemo;
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	void assertThatTwoPositiveNumbersAreAddedCorrectly
	(int a, int b, int expected, boolean expectException){
		
		if (!expectException) {
			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);
		}else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
		
	}
	
	
	static Stream<Arguments> argumentsForAddPositive() {
		
		
		return Stream.of(
		Arguments.of(2, 4, 6, false),
		Arguments.of(8, 4, 12, false),
		Arguments.of(-3, -4, -7, true),
		Arguments.of(-1, 4, 3, true),
		Arguments.of(9, -7, 2, true),
		Arguments.of(0, 0, 0, true)
				);
	}
	//Step 2-1
	
	@Test
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {

		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40,50)).isEqualTo(90);
		assertThat(testDemo.addPositive(8, 41)).isEqualTo(49);
		assertThat(testDemo.addPositive(245, 98)).isEqualTo(343);
		
	}
	//Step 3
	//I created a simple method that tests that the value returned is the correct data type
	
	@Test
	void assertThatSumOfPairsIsAnInteger() {
		
		assertThat(testDemo.addPositive(3, 5)).isInstanceOf(Integer.class);
	
		
	}
	
	
	@Test
	void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();
		
		int fiveSquared = mockDemo.randomNumberSquared();
		assertThat(fiveSquared).isEqualTo(25);
	}


}
