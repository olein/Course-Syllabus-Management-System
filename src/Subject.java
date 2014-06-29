public class Subject {

	private String name;
	private String course_no;
	private String credit;
	private String semester;
	private String status;
	private String reference;
	private int last_version;

	public Subject(String name, String course_no, String credit,
			String semester, String status, String reference,
			int last_version) {
		this.name = name;
		this.course_no = course_no;
		this.credit = credit;
		this.semester = semester;
		this.status = status;
		this.reference = reference;
		this.last_version = last_version;
	}

	public String getCourseNo() {
		return course_no;
	}

	public void setCourseNo(String course_no) {
		this.course_no = course_no;
	}

	public String getCredit() {
		return credit;
	}

	public void setCredit(String credit) {
		this.credit = credit;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public int getLastVersion() {
		return last_version;
	}

	public void setLastVersion(int last_version) {
		this.last_version = last_version;
	}

}
