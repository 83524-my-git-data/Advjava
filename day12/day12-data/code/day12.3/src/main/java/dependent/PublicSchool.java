package dependent;

import dependency.Coach;
import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// depcy i/f (mandatory)
	private Coach sportsCoach;// another depcy i/f (optional)
	private long fees;// mandatory depcy

	private PublicSchool(long fees, Teacher myTeacher) {
		this.fees = fees;
		this.subjectTeacher = myTeacher;
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

	// Factory method based D.I
	public static PublicSchool myFactoryMethod(long schoolFees, 
			Teacher myTeacher, Coach sportsTrainer) {
		System.out.println("in factory method"); // SC
		PublicSchool school = new PublicSchool(schoolFees, myTeacher);
		school.sportsCoach = sportsTrainer;
		return school;
	}

}
