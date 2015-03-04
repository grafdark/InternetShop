package by.romanov.is.tags;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.log4j.Logger;

import by.romanov.is.resource.PageManager;
import static by.romanov.is.constants.Constants.*;

@SuppressWarnings("serial")
public class CustomButtonTag extends TagSupport {
	private static final Logger LOGGER = Logger
			.getLogger(CustomButtonTag.class);

	private String role;

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int doStartTag() throws JspException {
		try {
			if (ROLE_ADMIN.equalsIgnoreCase(role)) {
				pageContext.include(PageManager
						.getProperty("page.buttons-header-admin"));
			} else if (ROLE_USER.equalsIgnoreCase(role)) {
				pageContext.include(PageManager
						.getProperty("page.buttons-header-user"));
			} else {
				pageContext.include(PageManager.getProperty("page.buttons"));
			}

		} catch (IOException e) {
			LOGGER.error(e);
		} catch (ServletException e) {
			LOGGER.error(e);
		}
		return SKIP_BODY;
	}
}
