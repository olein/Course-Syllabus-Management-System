
import java.util.Date;

public class MainSyllabus {
	
	private String name;
    private String course_no;
    private String credit;
    private String semester;
    private String syllabus;
    private String reference;
    private int version;
    
    
    public MainSyllabus(String name, String course_no, String credit, String semester, String syllabus, String reference,int version) {
        this.name = name;
        this.course_no = course_no;
        this.credit = credit;
        this.semester = semester;
        this.syllabus = syllabus;
        this.reference = reference;
        this.version = version;
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
    public String getSyllabus() {
        return syllabus;
    }
    public void setSyllabus(String syllabus) {
        this.syllabus = syllabus;
    }
    public String getReference() {
        return reference;
    }
    public void setReference(String reference) {
        this.reference = reference;
    }
    public int getVersion(){
    	return version;
    }
    public void setVersion(int version) {
    	this.version = version;
    }
    
}



