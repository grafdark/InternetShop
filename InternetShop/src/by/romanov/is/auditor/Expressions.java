package by.romanov.is.auditor;

public class Expressions {
	public final static String EXP_LOGIN = "^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
	public final static String EXP_TELEPHONE = "((-?[0-9][0-9][0-9][0-9][0-9][0-9][0-9]))";
	public final static String EXP_FIRST_NAME="^[à-ÿÀ-ß¸¨a-zA-Z0-9]+$";
	public final static String EXP_LAST_NAME="^[à-ÿÀ-ß¸¨a-zA-Z0-9]+$";
	public final static String EXP_EMAIL="^[-\\w.]+@([A-z0-9][-A-z0-9]+\\.)+[A-z]{2,4}$";
	public final static String EXP_PASSWORD="^[a-zA-Z][a-zA-Z0-9-_\\.]{1,20}$";
}
