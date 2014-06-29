
public class UserAccount {

	private String user_name;
    private String password;
    private String type;
    private String access_level;
    
    public UserAccount(String user_name, String password, String type, String access_level) {
        this.user_name = user_name;
        this.password = password;
        this.type = type;
        this.access_level = access_level;
 }
    
    public String getUserName() {
        return user_name;
    }
    public void setUserName(String user_name) {
        this.user_name = user_name;
    } 
	
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    } 
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    } 
    
    public String getAccessLevel() {
        return access_level;
    }
    public void setAccessLevel(String access_level) {
        this.access_level = access_level;
    } 
}
