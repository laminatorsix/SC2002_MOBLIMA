package moblima.model;

/**
 * Represents Admin Login.
 */
public class AdminLogin {
	private String password = "Admin123";
	
	/**
	 * Verifies a password.
	 * @param pass Password entered.
	 * @return Whether the password is correct or not.
	 */
	public boolean checkPass(String pass) {
		if(pass == password) {
			return true;
		}
		return false;
	}
	
	public String getPass() {
		return password;
	}
	
	public String setPass() {
		return password;
	}
}
