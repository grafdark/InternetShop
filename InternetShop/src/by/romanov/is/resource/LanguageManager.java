package by.romanov.is.resource;

import java.util.Locale;
import java.util.ResourceBundle;

public class LanguageManager {

	private LanguageManager() {

	}

	public static String getProperty(String key, String lang) {

		Locale locale = new Locale(lang);
		ResourceBundle resourceBundle = ResourceBundle.getBundle(
				"resource.pagecontent", locale);
		return resourceBundle.getString(key);

	}
}
