package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// depcy i/f (mandatory)
	private Coach sportsCoach;// another depcy i/f (optional)
	private long fees;//mandatory depcy

	// constructor based D.I
	public PublicSchool(long fees,Teacher myTeacher) {
		this.fees=fees;
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);
	}
	//setter based D.I
	public void setSportsCoach(Coach sportsCoach) {
		this.sportsCoach = sportsCoach;
		System.out.println("in set sports coach ");
	}
	
//B.L 
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();// depnt obj is using depcy !
	}


	//B.L
	@Override
	public void organizeSportsEvent() {
		System.out.println("organizing sports event here.....");
		System.out.println(sportsCoach.getDailyWorkout());// depnt obj is using depcy !
	}
	
	

	// custom init method
	public void anyInit() {
		System.out.println("in init " + subjectTeacher);
	}

	
	// custom destroy method
	public void anyDestroy() {
		System.out.println("in destroy " + subjectTeacher);
	}

	
	
}
