package source;

import java.util.ArrayList;
import java.util.List;

public class Editor {
	static List<Editor> editors = new ArrayList<Editor>();
	private String ime;
	private String prezime;
	private String username;
	private String password;
	private Role role;
	
	public Editor(String ime, String prezime, String username, String password, Role role) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public static List<Editor> getEditors() {
		return editors;
	}

	public static void setEditors(List<Editor> editors) {
		Editor.editors = editors;
	}

	public String getIme() {
		return ime;
	}

	public String getPrezime() {
		return prezime;
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
	
	public void setIme(String ime) {
		this.ime = ime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		return 31*ime.hashCode()+17*prezime.hashCode()+13*password.hashCode() + 7*role.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		Editor editor = (Editor) obj;
		if(this==obj) 
			return true;
		
		if(obj==null)
			return false;
		
		if(! (obj instanceof Editor))
			return false;
		if(!editor.username.equals(username)){
			return false;
		}else if(!editor.ime.equals(ime)) {
			return false;
		}else if(!editor.prezime.equals(prezime)) {
			return false;
		}else if(!editor.password.equals(password)) {
			return false;
		}else if(editor.role!=role) {
			return false;
		}
		return true;
	}
	
	
	@Override
	public String toString() {
		return "Editor [ime=" + ime + ", prezime=" + prezime + ", username=" + username + ", password=" + password
				+ ", role=" + role + "]";
	}
	
	
}
