package hu.thesis.timetableplanner.form;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

public class EditUserForm {
	
	private static final String REGEXP_PASSWORD = "^(?=.*[a-zA-Z])(?=.*[0-9])(?=.*[-?#!_])[a-zA-Z0-9-?#!_]{3,}$";

	@NotNull @Size(min=1,max=128)
	private String userName;

	@NotNull @Size(min=1,max=128)
	private String emailAddress;
	
	@Size(min=8)
	@Pattern(regexp=REGEXP_PASSWORD)
	private String newPassword;
	
	@Size(min=8)
	@Pattern(regexp=REGEXP_PASSWORD)
	private String retypePassword;

	private List<String> userRoles;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public static String getRegexpPassword() {
		return REGEXP_PASSWORD;
	}

	public List<String> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<String> userRoles) {
		this.userRoles = userRoles;
	}
}
