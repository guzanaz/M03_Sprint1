/**
 * 
 */
package pkgClassesVirtualio;

/**
 * @author Daniela
 *
 */
public class StudentUser {
	private int user_id;
	private String user_name;
	
	public StudentUser(String user_name, int user_id) {
		this.user_id = user_id;
		this.user_name = user_name;
	}
	
	public int getUid() {
		return user_id;
	}
	
	public String getUname() {
		return user_name;
	}
}
