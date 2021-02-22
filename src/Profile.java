import java.util.List;

public class Profile {
	// Your additions/changes below this line

	List<Grade> profileGrades;

	public Profile(List<Grade> g) {

		// Checking List<Grade> g has grades and that none of those grade are a fail
		if (g == null || g.isEmpty()) {
			throw new IllegalArgumentException();
		} else {
			for (Grade grade : g) {
				if (grade.classify() == Classification.Fail) {
					throw new IllegalArgumentException();
				}
			}
		}

		// Assigns list of grades to Profile
		this.profileGrades = g;
	}

	public Classification classify() {
		int firstCounter = 0;
		int upperSecondCounter = 0;
		int lowerSecondCounter = 0;
		int thirdCounter = 0;

		for (Grade grade : profileGrades) {
			if (grade.classify() == Classification.First) {
				firstCounter++;
			} else if (grade.classify() == Classification.UpperSecond) {
				upperSecondCounter++;
			} else if (grade.classify() == Classification.LowerSecond) {
				lowerSecondCounter++;
			} else if (grade.classify() == Classification.Third) {
				thirdCounter++;
			}
		}

		int totalGrades = firstCounter + upperSecondCounter + lowerSecondCounter + thirdCounter;
		
		if (firstCounter >= (totalGrades / 2)) {
			return Classification.First;
		} else if (upperSecondCounter >= (totalGrades / 2)) {
			return Classification.UpperSecond;
		} else if (lowerSecondCounter >= (totalGrades / 2)) {
			return Classification.LowerSecond;
		} else {
			return Classification.Third; //test
		}
		
	}

	public boolean isClear() {

		int otherCounter = 0;
		int thirdCounter = 0;

		
		for (Grade grade : profileGrades) {
			if (grade.classify() == Classification.Third) {
				thirdCounter++;
			} else {
				otherCounter++;
			}
		}

		int totalGrades = otherCounter + thirdCounter;

		if (thirdCounter > (totalGrades / 4)) {
			return false; // BORDERLINE
		} else {
			return true; // CLEAR
		}

	}
}
