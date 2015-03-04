package by.romanov.is.entity;

public class User {
	private int id;
	private String login;
	private String access;
	private String password;
	private String lastName;
	private String firstName;
	private String email;
	private String telephone;

	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public String getAccess() {
		return access;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public void setAccess(String access) {
		this.access = access;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", access=" + access
				+ ", password=" + password + ", last_name=" + lastName
				+ ", first_name=" + firstName + ", email=" + email
				+ ", telephone=" + telephone + "]";
	}

}
