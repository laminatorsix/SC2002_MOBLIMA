package moblima.controller;
import moblima.model.AdminLogin;

/**
 * Controller for AdminLogin.
 */
public class AdminLoginController {
	private AdminLogin model;
	/**
	 * Constructor for AdminLoginController.
	 * @param model 
	 */
	public AdminLoginController(AdminLogin model) {
		this.model = model;
	}
	
	/**
	 * Verifies password for AdminLogin.
	 * @param password Password entered by user.
	 * @return Whether password is correct or not.
	 */
	public boolean verifyLogin(String password) {
		if(password != model.getPass()) {
			return false;
		}
		return true;
	}
}
