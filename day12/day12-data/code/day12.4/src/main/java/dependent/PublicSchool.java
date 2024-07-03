package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// depcy i/f (mandatory)
	private Coach sportsCoach;// another depcy i/f (optional)

	public PublicSchool() {
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);
	}

//B.L 
	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();// depnt obj is using depcy !
	}

	// B.L
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
	//setter Based D.I

	public void setSubjectTeacher(Teacher subjectTeacher) {
		System.out.println("in set teacher");
		this.subjectTeacher = subjectTeacher;
	}

	public void setSportsCoach(Coach sportsCoach) {
		System.out.println("in set sports coach");
		this.sportsCoach = sportsCoach;
	}
	


}
