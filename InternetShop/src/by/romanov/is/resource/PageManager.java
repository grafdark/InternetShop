package by.romanov.is.resource;

import java.util.ResourceBundle;

public class PageManager {
	private final static ResourceBundle resource_bundle = ResourceBundle
			.getBundle("resource.path");

	private PageManager() {
	}

	public static String getProperty(String key) {
		return resource_bundle.getString(key);
	}
}
