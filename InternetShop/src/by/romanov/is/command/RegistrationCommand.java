package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import by.romanov.is.auditor.AuditorUserInfo;
import by.romanov.is.database.impl.GoodsDAOimpl;
import by.romanov.is.entity.User;
import by.romanov.is.exception.CustomException;
import by.romanov.is.messagedigest.MessageDigestPassword;
import by.romanov.is.resource.LanguageManager;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.UserService;
import static by.romanov.is.constants.Constants.*;

public class RegistrationCommand implements Command {
	private static final Logger LOGGER = Logger.getLogger(GoodsDAOimpl.class);

	@Override
	public String execute(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);

		try {
			UserService userService = new UserService();
			User user = isRegisterInfo(request);
			boolean flag = userService.registrUser(user);

			if (flag) {
				request.getSession().setAttribute(ATTR_LOGIN, user.getLogin());
				request.getSession().setAttribute(ATTR_ROLE, user.getAccess());
				return PageManager.getProperty("page.registration-ready");
			} else {
				return PageManager.getProperty("page.registration");
			}
		} catch (CustomException e) {
			LOGGER.error("the user can not be registered", e);
			request.setAttribute(ATTR_USER_EXIST,
					LanguageManager.getProperty("message.user_exist", lang));
			return PageManager.getProperty("page.registration");
		}
	}

	private User isRegisterInfo(HttpServletRequest request) {
		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);
		MessageDigestPassword mdp = new MessageDigestPassword();
		User user = new User();
		AuditorUserInfo auditor = new AuditorUserInfo();
		String login = request.getParameter(PARAM_LOGIN);
		String password = request.getParameter(PARAM_PASSWORD);
		String lastName = request.getParameter(PARAM_LAST_NAME);
		String firstName = request.getParameter(PARAM_FIRST_NAME);
		String email = request.getParameter(PARAM_EMAIL);
		String telephone = request.getParameter(PARAM_TELEPHONE);
		if (auditor.auditorLoginUser(login)) {
			user.setLogin(login);
			user.setAccess(ATTR_USER);
		} else {
			request.setAttribute(ATTR_INCORRECT_LOGIN,
					LanguageManager.getProperty("message.incorrect_login", lang));
		}
		if (auditor.auditorPassword(password)) {
			user.setPassword(mdp.getHash(password));
		} else {
			request.setAttribute(ATTR_INCORRECT_PASSWORD,
					LanguageManager.getProperty("message.incorrect_password", lang));
		}
		if (auditor.auditorEmail(email)) {
			user.setEmail(email);
		} else {
			request.setAttribute(ATTR_INCORRECT_EMAIL,
					LanguageManager.getProperty("message.incorrect_email", lang));
		}

		if (auditor.auditorFirstName(firstName)) {
			user.setFirstName(firstName);
		} else {
			request.setAttribute(ATTR_INCORRECT_FIRSTNAME,
					LanguageManager.getProperty("message.incorrect_firstname", lang));
		}

		if (auditor.auditorLastName(lastName)) {
			user.setLastName(lastName);
		} else {
			request.setAttribute(ATTR_INCORRECT_LASTNAME,
					LanguageManager.getProperty("message.incorrect_lastname", lang));
		}

		if (auditor.auditorTelephone(telephone)) {
			user.setTelephone(telephone);
		} else {
			request.setAttribute(ATTR_INCORRECT_TELEPHONE,
					LanguageManager.getProperty("message.incorrect_telephone", lang));
		}
		return user;
	}
}
