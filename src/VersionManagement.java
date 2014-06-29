import java.util.Date;


public class VersionManagement {

	private String user_name;
	private String comment;
	private String subject;
	private int version;
	private Date date;
	
	public VersionManagement(String user_name, String comment, String subject, int version, Date date) {
        this.user_name = user_name;
        this.comment = comment;
        this.subject = subject;
        this.version = version;
        this.date = date;
    }
	
	public String getUserName(){
        return user_name;
    }
    public void setUserName(String user_name) {
        this.user_name = user_name;
    }
    public String getComment(){
    return comment;
}
public void setComment(String comment){
    this.comment = comment;
}

public String getSubject(){
return subject;
}
public void setSubject(String subject){
this.subject = subject;
}

public int getVersion(){
return version;
}
public void setVersion(int version) {
this.version = version;
}

public Date getDate(Date date){
return date;
}
public void setDate(Date date) {
this.date = date;
}
}
