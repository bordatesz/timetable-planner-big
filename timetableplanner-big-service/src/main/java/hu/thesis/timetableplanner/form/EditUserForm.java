package hu.thesis.timetableplanner.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class EditUserForm {
	
	private static final String REGEXP_PASSWORD = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[-?#!_])[a-zA-Z0-9-?#!_]{3,}$";

	@NotNull @Size(min=1,max=128)
	private String userName;

	@NotNull @Size(min=1,max=128)
	private String emailAdress;
	
	@Size(min=8)
	@Pattern(regexp=REGEXP_PASSWORD)
	private String newPassword;
	
	@Size(min=8)
	@Pattern(regexp=REGEXP_PASSWORD)
	private String retypePassword;

	private boolean admin;

	private boolean lecturer;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAdress() {
		return emailAdress;
	}

	public void setEmailAdress(String emailAdress) {
		this.emailAdress = emailAdress;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getRetypePassword() {
		return retypePassword;
	}

	public void setRetypePassword(String retypePassword) {
		this.retypePassword = retypePassword;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public static String getRegexpPassword() {
		return REGEXP_PASSWORD;
	}


	public boolean isLecturer() {
		return lecturer;
	}

	public void setLecturer(boolean lecturer) {
		this.lecturer = lecturer;
	}
}
