package source;

import java.util.List;

public class Editor {
	private String firstName;
	private String lastName;
	private String username;
	private final String password;
	private Role role;
	
	

	public Editor(String firstName, String lastName, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.role = Role.EDITOR;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public Role getRole() {
		return role;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public int hashCode() {
		return 31 * firstName.hashCode() + 17 * lastName.hashCode() + 13 * password.hashCode() + 7 * role.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		Editor editor = (Editor) obj;
		if (this == obj)
			return true;

		if (obj == null)
			return false;

		if (!(obj instanceof Editor))
			return false;
		if (!editor.username.equals(username)) {
			return false;
		} else if (!editor.firstName.equals(firstName)) {
			return false;
		} else if (!editor.lastName.equals(lastName)) {
			return false;
		} else if (!editor.password.equals(password)) {
			return false;
		} else if (editor.role != role) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Editor [first name =" + firstName + ", last name=" + lastName + ", username=" + username + "]";
	}

}
