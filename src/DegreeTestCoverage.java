import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

public class DegreeTestCoverage {

	@Test
	void failGradesTest() {
		
		Grade grade1 = new Grade(18); //fail grade
		Grade grade2 = new Grade(6);
		Grade grade3 = new Grade(13);
		Grade grade4 = new Grade(13);
		
		List<Grade> year3 = Arrays.asList(grade1, grade2, grade3, grade4);
		
		Grade grade5 = new Grade(6);
		Grade grade6 = new Grade(6);
		Grade grade7 = new Grade(13);
		Grade grade8 = new Grade(13);
		
		List<Grade> year2 = Arrays.asList(grade5, grade6, grade7, grade8);
		
		assertThrows(IllegalArgumentException.class, () -> {
			Degree degree = new Degree(year2, year3);
		});
		
	}
	
	@Test
	void firstDegreeTest() {
		Grade grade1 = new Grade(1);
		Grade grade2 = new Grade(2);
		Grade grade3 = new Grade(5);
		Grade grade4 = new Grade(1);
		
		List<Grade> year3 = Arrays.asList(grade1, grade2, grade3, grade4); 
		
		Grade grade5 = new Grade(5);
		Grade grade6 = new Grade(5);
		Grade grade7 = new Grade(5);
		Grade grade8 = new Grade(5);
		
		List<Grade> year2 = Arrays.asList(grade5, grade6, grade7, grade8);
		
		Degree degree = new Degree(year2, year3);
		
		//year3 grades swapped with year2 grades to complete get complete coverage
		assertEquals(degree.classify(), Classification.First);
	}
	
	@Test
	void upperSecondDegreeTest() {
		Grade grade1 = new Grade(5);
		Grade grade2 = new Grade(5);
		Grade grade3 = new Grade(9);
		Grade grade4 = new Grade(5);
		
		List<Grade> year3 = Arrays.asList(grade1, grade2, grade3, grade4);
		
		Grade grade5 = new Grade(9);
		Grade grade6 = new Grade(9);
		Grade grade7 = new Grade(9);
		Grade grade8 = new Grade(9);
		
		List<Grade> year2 = Arrays.asList(grade5, grade6, grade7, grade8);
		
		Degree degree = new Degree(year2, year3);
		
		//year3 grades swapped with year2 grades to complete get complete coverage
		assertEquals(degree.classify(), Classification.UpperSecond);
	}
	
	@Test
	void lowerSecondDegreeTest() {
		Grade grade1 = new Grade(9);
		Grade grade2 = new Grade(9);
		Grade grade3 = new Grade(13);
		Grade grade4 = new Grade(9);
		
		List<Grade> year3 = Arrays.asList(grade1, grade2, grade3, grade4);
		
		Grade grade5 = new Grade(13);
		Grade grade6 = new Grade(13);
		Grade grade7 = new Grade(13);
		Grade grade8 = new Grade(13);
		
		List<Grade> year2 = Arrays.asList(grade5, grade6, grade7, grade8);
		
		Degree degree = new Degree(year2, year3);
		
		//year3 grades swapped with year2 grades to complete get complete coverage
		assertEquals(degree.classify(), Classification.LowerSecond);
	}
}
