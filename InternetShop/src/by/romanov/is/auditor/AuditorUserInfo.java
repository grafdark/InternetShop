package by.romanov.is.auditor;

import org.apache.log4j.Logger;

public class AuditorUserInfo {
	private static final Logger LOGGER = Logger
			.getLogger(AuditorUserInfo.class);

	public boolean auditorLoginUser(String loginUser) {
		if (!(loginUser != null && loginUser.matches(Expressions.EXP_LOGIN))) {
			LOGGER.error("incorrect login");
			return false;
		}
		return true;
	}

	public boolean auditorPassword(String password) {
		if (!(password != null && password.matches(Expressions.EXP_PASSWORD))) {
			LOGGER.error("incorrect password");
			return false;
		}
		return true;
	}

	public boolean auditorLastName(String lastName) {
		if (!(lastName != null && lastName.matches(Expressions.EXP_LAST_NAME))) {
			LOGGER.error("incorrect last name");
			return false;
		}
		return true;
	}

	public boolean auditorFirstName(String firstName) {
		if (!(firstName != null && firstName.matches(Expressions.EXP_LAST_NAME))) {
			LOGGER.error("incorrect first name");
			return false;
		}
		return true;
	}

	public boolean auditorTelephone(String telephone) {
		if (!(telephone != null && telephone.matches(Expressions.EXP_TELEPHONE))) {
			LOGGER.error("incorrect telephone");
			return false;
		}
		return true;
	}

	public boolean auditorEmail(String email) {
		if (!(email != null && email.matches(Expressions.EXP_EMAIL))) {
			LOGGER.error("incorrect email");
			return false;
		}
		return true;
	}

}
