import java.util.ArrayList;
import java.util.List;

public class Degree {
	// Your additions/changes below this line
	
	public List<Grade> year2;
	public List<Grade> year3;
	
	public Degree(List<Grade> year2, List<Grade> year3) { 
		
		//if null or fail throw exception
		if (year2 == null || year3 == null) {
			throw new IllegalArgumentException();
		} else {
			for (Grade grade : year2) {
				if (grade.classify() == Classification.Fail || year2.size() != 4) {
					throw new IllegalArgumentException();
				}
			}
			for (Grade grade1 : year3) {
				if (grade1.classify() == Classification.Fail || year3.size() != 4) {
					throw new IllegalArgumentException();
				}
			}
		}
		
		this.year2 = year2;
		this.year3 = year3;
	} 
		
	public Classification classify() {
		
		//year 2 and 3 grades
		List<Grade> profileGrades5 = new ArrayList<>();
		profileGrades5.addAll(year2);
		profileGrades5.addAll(year3);
		Profile p5 = new Profile(profileGrades5);
		
		//year 3 grades only
		List<Grade> profileGrades6 = year3;		 
		Profile p6 = new Profile(profileGrades6);
		
		if(p5.classify() == p6.classify()) {
			return p5.classify(); //If classification is the same
		} else if((p5.classify() == Classification.First && p6.classify() == Classification.UpperSecond) && p5.isClear()) {
			return Classification.First; //if p5 better than p6
		} else if((p6.classify() == Classification.First && p5.classify() == Classification.UpperSecond) && p6.isClear()) {
			return Classification.First; //if p6 better than p5
		} else if((p5.classify() == Classification.UpperSecond && p6.classify() == Classification.LowerSecond) && p5.isClear()) {
			return Classification.UpperSecond;
		} else if((p6.classify() == Classification.UpperSecond && p5.classify() == Classification.LowerSecond) && p6.isClear()) {
			return Classification.UpperSecond;
		} else if((p5.classify() == Classification.LowerSecond && p6.classify() == Classification.Third)) {
			return Classification.LowerSecond;
		} else if((p6.classify() == Classification.LowerSecond && p5.classify() == Classification.Third)) {
			return Classification.LowerSecond;
		} else {
			return Classification.Discretion;
		}
	}
}
