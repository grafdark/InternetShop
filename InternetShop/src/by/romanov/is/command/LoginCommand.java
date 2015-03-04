package by.romanov.is.command;

import javax.servlet.http.HttpServletRequest;

import by.romanov.is.messagedigest.MessageDigestPassword;
import by.romanov.is.resource.LanguageManager;
import by.romanov.is.resource.PageManager;
import by.romanov.is.service.GoodsService;
import by.romanov.is.service.UserService;
import static by.romanov.is.constants.Constants.*;

public class LoginCommand implements Command {

	public String execute(HttpServletRequest request) {
		MessageDigestPassword mdp = new MessageDigestPassword();

		String lang = (String) request.getSession().getAttribute(ATTR_LANGUAGE);
		String loginUser = request.getParameter(PARAM_LOGIN);
		String passwordUser = mdp.getHash(request.getParameter(PARAM_PASSWORD));
		UserService userService = new UserService();
		if (userService.checkUser(loginUser, passwordUser)) {
			if (!userService.checkBanUser(loginUser)) {
				request.getSession().setAttribute(PARAM_LOGIN, loginUser);
				GoodsService goodsService = new GoodsService();
				int numberPages = goodsService.takePageGoodsList();
				request.setAttribute(ATTR_PAGES, numberPages);
				request.setAttribute(ATTR_GOODS, goodsService.takeGoodsList(0));

				if (isRoleAdmin(loginUser, userService)) {
					request.getSession().setAttribute(ATTR_ROLE, ROLE_ADMIN);

					return PageManager.getProperty("page.admin-page-home");

				} else if (isRoleUser(loginUser, userService)) {
					request.getSession().setAttribute(ATTR_ROLE, ROLE_USER);
				}
				return PageManager.getProperty("page.catalog");
			} else {
				request.setAttribute(ATTR_USER_IS_BAN, LanguageManager
						.getProperty("message.user_is_ban", lang));
				return PageManager.getProperty("page.login");
			}
		} else {
			request.setAttribute(ATTR_USER_NOT_REGISTERED, LanguageManager
					.getProperty("message.user_not_registered", lang));
		}
		return PageManager.getProperty("page.login");
	}

	private boolean isRoleUser(String loginUser, UserService userService) {
		return userService.getRole(loginUser).equals(ROLE_USER);
	}

	private boolean isRoleAdmin(String loginUser, UserService userService) {
		return userService.getRole(loginUser).equals(ROLE_ADMIN);
	}
}
