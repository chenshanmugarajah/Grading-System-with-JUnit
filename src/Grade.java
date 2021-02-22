public class Grade {
	private final int points;

	public int getPoints() {
		return points;
	}

	public Grade(int p) throws IllegalArgumentException {
		if(p<1 || p>20) 
			throw new IllegalArgumentException();
		points = p;
	}
	
	// Your additions/changes below this line

	public Classification classify() {
		if (points >= 1 && points <= 4) {
			return Classification.First;
		} else if (points >= 5 
				&& points <= 8) {
			return Classification.UpperSecond;
		} else if (points >= 9 
				&& points <= 12) {
			return Classification.LowerSecond;
		} else if (points >= 13 
				&& points <= 16) {
			return Classification.Third;
		} else {
			return Classification.Fail;
		}
	}
	
	public static Grade fromPercentage(int g) throws IllegalArgumentException {
		if (g >= 79 && g <= 100) {
			return new Grade(1);
		} else if (g >= 76 && g <= 78) {
			return new Grade(2);
		} else if (g >= 73 && g <= 77) {
			return new Grade(3);
		} else if (g >= 70 && g <= 72) {
			return new Grade(4);
		} else if (g >= 67 && g <= 69) {
			return new Grade(5);
		} else if (g >= 65 && g <= 66) {
			return new Grade(6);
		} else if (g >= 62 && g <= 64) {
			return new Grade(7);
		} else if (g >= 60 && g <= 61) {
			return new Grade(8);
		} else if (g >= 57 && g <= 59) {
			return new Grade(9);
		} else if (g >= 55 && g <= 56) {
			return new Grade(10);
		} else if (g >= 52 && g <= 54) {
			return new Grade(11);
		} else if (g >= 50 && g <= 51) {
			return new Grade(12);
		} else if (g >= 47 && g <= 49) {
			return new Grade(13);
		} else if (g >= 45 && g <= 46) {
			return new Grade(14);
		} else if (g >= 42 && g <= 44) {
			return new Grade(15);
		} else if (g >= 40 && g <= 41) {
			return new Grade(16);
		} else if (g >= 35 && g <= 39) {
			return new Grade(17);
		} else if (g >= 30 && g <= 34) {
			return new Grade(18);
		} else if (g >= 0 && g <= 29) {
			return new Grade(19);
		} else if (g == -1) {
			return new Grade(20);
		} else {
			throw new IllegalArgumentException();
		}
	}
}

