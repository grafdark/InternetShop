package by.romanov.is.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class LanguageListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		event.getSession().setAttribute("language", "ru");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		event.getSession().removeAttribute("language");
	}
}
