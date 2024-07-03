package dependent;

import dependency.Teacher;

public class PublicSchool implements School {
	private Teacher subjectTeacher;// depcy i/f

	// constructor based D.I
	public PublicSchool(Teacher myTeacher) {
		this.subjectTeacher = myTeacher;
		System.out.println("In constructor - " + getClass() + " " + subjectTeacher);
	}

	@Override
	public void manageAcademics() {
		System.out.println("Managing academics here -");
		subjectTeacher.teach();// depnt obj is using depcy !
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
