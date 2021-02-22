
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ProfileTest { 

	@Test
	void constructorEmptyListTest() {

		List<Grade> grades = new ArrayList<Grade>();

		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(grades);
		});
	}

	@Test
	void constructorFailGradeTest() {

		Grade grade1 = new Grade(1);
		Grade grade2 = new Grade(8);
		Grade grade3 = new Grade(13);
		Grade grade4 = new Grade(17);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(grades);
		});
	}

	@Test
	void constructorNullListTest() {

		List<Grade> grades = null;

		assertThrows(IllegalArgumentException.class, () -> {
			Profile profile = new Profile(grades);
		});
	}

	@Test
	void classification1Test() {

		Grade grade1 = new Grade(1); //first
		Grade grade2 = new Grade(1); //first
		Grade grade3 = new Grade(13); //third
		Grade grade4 = new Grade(13); //third
		
		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		//profile should be Classification.First and .isClear() should return false since there are two Third grades
		if (profile.classify() != Classification.First || profile.isClear() != false) {
			fail("Should be first and not clear");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
	}

	@Test
	void classification2Test() {

		Grade grade1 = new Grade(1);
		Grade grade2 = new Grade(1);
		Grade grade3 = new Grade(1);
		Grade grade4 = new Grade(13);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		// should be first and not clear
		if (profile.classify() != Classification.First || profile.isClear() != true) {
			fail("Should be first and clear");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
	}

	@Test
	void classification3Test() {

		Grade grade1 = new Grade(6);
		Grade grade2 = new Grade(6);
		Grade grade3 = new Grade(13);
		Grade grade4 = new Grade(13);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		// should be first and not clear
		if (profile.classify() != Classification.UpperSecond || profile.isClear() != false) {
			fail("Should be upperSecond and not clear");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
	}

	@Test
	void classification4Test() {

		Grade grade1 = new Grade(6);
		Grade grade2 = new Grade(6);
		Grade grade3 = new Grade(6);
		Grade grade4 = new Grade(13);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		// should be first and not clear
		if (profile.classify() != Classification.UpperSecond || profile.isClear() != true) {
			fail("Should be upperSecond and clear");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
	}

	@Test
	void classification5Test() {

		Grade grade1 = new Grade(9);
		Grade grade2 = new Grade(9);
		Grade grade3 = new Grade(9);
		Grade grade4 = new Grade(9);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		// should be first and not clear
		if (profile.classify() != Classification.LowerSecond) {
			fail("Should be lowerSecond");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
	}

	@Test
	void classification6Test() {

		Grade grade1 = new Grade(13);
		Grade grade2 = new Grade(13);
		Grade grade3 = new Grade(13);
		Grade grade4 = new Grade(13);

		List<Grade> grades = Arrays.asList(grade1, grade2, grade3, grade4);

		Profile profile = new Profile(grades);

		// should be first and not clear
		if (profile.classify() != Classification.Third) {
			fail("Should be third");
		}
		
		assertDoesNotThrow(() -> {
			Profile profile1 = new Profile(grades);
		});
		
	}

}
