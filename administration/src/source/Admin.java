package source;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Admin {

	private final String firstName;
	private final String lastName;
	private final String username;
	private final String password;
	private final Role role = Role.ADMIN;
	List<Editor> editors = new ArrayList<Editor>();

	public Admin(String firstName, String lastName, String username, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
	}

	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}
	
	public void showEditors() {
		System.out.println(editors);
	}

	public void showEditor(String username) {
		for (Editor editorMember : editors) {
			if (editorMember.getUsername().equals(username)) {
				System.out.println(editorMember);
				break;
			}
		}
	}

	public int findEditorsPosition(String username) {
		int position = 0;
		for (Editor editorMember : editors) {
			if (username.equals(editorMember.getUsername()))
				return position;
			else
				position++;

		}
		return -1;
	}

	public boolean usernameExists(String username) {
		for (Editor editorMember : editors) {
			if (editorMember.getUsername().equals(username))
				return true;
		}
		return false;
	}

	public String enterUsername() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter editors username: ");
		String username;
		do {
			username = sc.next();
			if (usernameExists(username))
				System.out.println("Username is taken, change it. ");
			else
				break;
		} while (true);
		return username;
	}

	public String enterPassword() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter editors password: ");
		String pass;
		do {
			pass = sc.next();
			if (!validPassword(pass))
				System.out.println("Password cannot start with digit, but has to contain at least one. ");
			else
				break;
		} while (true);
		return pass;
	}

	private boolean validPassword(String pass) {
		if (!Character.isLetter(pass.charAt(0)))
			return false;
		for (int i = 1; i < pass.length(); i++) {
			if (Character.isDigit(pass.charAt(i)))
				return true;
		}
		return false;
	}

	private void validatePassword(String password) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter password again: ");
		while (true) {
			String repeatedPass = sc.next();
			if (repeatedPass.equals(password))
				break;
			else
				System.out.println("Password you entered is not the same as previous\n Please enter it again.");
		}

	}

	public void insert() {
		Scanner sc = new Scanner(System.in);
		String username = enterUsername();
		String password = enterPassword();
		validatePassword(password);
		System.out.println("Enter editors first name: ");
		String firstName = sc.next();
		System.out.println("Enter editors last name: ");
		String lastName = sc.next();

		Editor editor = new Editor(firstName, lastName, username, password);
		editors.add(editor);

	}

	public void change(String username) {
		if (!usernameExists(username)) {
			System.out.println("Editor doesn't exist.");
		} else {
			int position = findEditorsPosition(username);
			Editor updatedEditor = editors.get(position);
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter new first name");
			updatedEditor.setFirstName(sc.next());
			System.out.println("Enter new last name");
			updatedEditor.setLastName(sc.next());
			editors.set(position, updatedEditor);
			System.out.println(username + " is updated." );

		}
	}

	public void deleteEditor(String username) {
		for (Editor editorMember : editors) {
			if (editorMember.getUsername().equals(username)) {
				editors.remove(editorMember);
				break;
			}
		}
	}

	public List<Editor> getEditors() {
		return editors;
	}

}
