package moblima.controller;
import moblima.model.AdminLogin;

/**
 * Controller for AdminLogin.
 */
public class AdminLoginController {
	private AdminLogin model;
	/**
	 * Constructor for AdminLoginController.
	 */
	public AdminLoginController() {
		this.model = new AdminLogin();
	}
	
	/**
	 * Verifies password for AdminLogin.
	 * @param password Password entered by user.
	 * @return Whether password is correct or not.
	 */
	public boolean verifyLogin(String password) {
		if(!password.equals(model.getPass())) {
			return false;
		}
		return true;
	}
}
