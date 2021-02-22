
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest { 
	
	@Test
	void lowInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(-2);
		});
	}
	
	@Test
	void highInput() {
		assertThrows(IllegalArgumentException.class, () -> {
			Grade grade = new Grade(22);
		});
	}
	
	@Test
	void goodInput() {
		
		int expectedPoints = 3;
		int inputPoints = 3;
		
		Grade grade = new Grade(inputPoints); 
		assertEquals(expectedPoints, grade.getPoints());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(inputPoints);
		});
	}
	
	@Test
	void classifyFirstTest() {
		Grade firstGrade = new Grade(1);
		
		assertEquals(Classification.First, firstGrade.classify());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(1);
		});
	}
	
	@Test
	void classifyUpperSecondTest() {
		Grade upperSecondGrade = new Grade(5);
		
		assertEquals(Classification.UpperSecond, upperSecondGrade.classify());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(5);
		});
	}
	
	@Test
	void classifyLowerSecondTest() {
		Grade lowerSecondGrade = new Grade(9);
		
		assertEquals(Classification.LowerSecond, lowerSecondGrade.classify());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(9);
		});
	}
	
	@Test
	void classifyThirdTest() {
		Grade thirdGrade = new Grade(13);
		
		assertEquals(Classification.Third, thirdGrade.classify());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(13);
		});
	}

	@Test
	void classifyFailTest() {
		Grade failGrade = new Grade(17);

		assertEquals(Classification.Fail, failGrade.classify());
		
		assertDoesNotThrow(() -> {
			Grade grade1 =  new Grade(17);
		});
	}
	
	@Test
	void lowFromPecentageTest() {
		
		int lowPercentage = -2; // lower than -1 is out of range and should throw exception
		
		assertThrows(IllegalArgumentException.class, () -> {
			Grade.fromPercentage(lowPercentage);
		});
	}
	
	@Test
	void highFromPecentageTest() {
		
		int highPercentage = 101; //higher than 100 is out of range and should throw exception
		
		assertThrows(IllegalArgumentException.class, () -> {
			Grade.fromPercentage(highPercentage);
		});
	}
	
	@ParameterizedTest
	@CsvSource({"1,79", "2,76", "3,73", "4,70", "5,67", "6,65", "7,62","8,60", "9,57", "10,55", "11,52", "12,50", "13,47", "14,45", "15,42", "16,40", "17,35", "18,30", "19,1", "20,-1"})
	void allPointsValuesTest(int expected, int input) {
		
		Grade grade = Grade.fromPercentage(input);
		
		assertEquals(expected, grade.getPoints());
		
		assertDoesNotThrow(() -> {
			Grade grade1 = Grade.fromPercentage(input);
		}); 
	}
	
	@Test
	void point1() {
		int g = 85;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(1, grade.getPoints());
	}
	
	@Test
	void point2() {
		int g = 76;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(2, grade.getPoints());
	}
	
	@Test
	void point3() {
		int g = 73;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(3, grade.getPoints());
	}
	
	@Test
	void point4() {
		int g = 70;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(4, grade.getPoints());
	}
	
	@Test
	void point5() {
		int g = 67;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(5, grade.getPoints());
	}
	
	@Test
	void point6() {
		int g = 65;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(6, grade.getPoints());
	}
	
	@Test
	void point7() {
		int g = 62;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(7, grade.getPoints());
	}
	
	@Test
	void point8() {
		int g = 60;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(8, grade.getPoints());
	}
	
	@Test
	void point9() {
		int g = 57;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(9, grade.getPoints());
	}
	
	@Test
	void point10() {
		int g = 55;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(10, grade.getPoints());
	}
	
	@Test
	void point11() {
		int g = 52;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(11, grade.getPoints());
	}
	
	@Test
	void point12() {
		int g = 50;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(12, grade.getPoints());
	}
	
	@Test
	void point13() {
		int g = 47;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(13, grade.getPoints());
	}
	
	@Test
	void point14() {
		int g = 45;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(14, grade.getPoints());
	}
	
	@Test
	void point15() {
		int g = 42;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(15, grade.getPoints());
	}
	
	@Test
	void point16() {
		int g = 40;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(16, grade.getPoints());
	}
	
	@Test
	void point17() {
		int g = 35;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(17, grade.getPoints());
	}
	
	@Test
	void point18() {
		int g = 30;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(18, grade.getPoints());
	}
	
	@Test
	void point19() {
		int g = 0;
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(19, grade.getPoints());
	}
	
	@Test
	void point20() {
		int g = -1; //non participation g
		Grade grade = Grade.fromPercentage(g);
		
		assertEquals(20, grade.getPoints());
	}
	
}
