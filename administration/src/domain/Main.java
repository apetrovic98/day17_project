package domain;

import java.util.Scanner;

import source.Admin;

public class Main {	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		Admin admin = new Admin("Admin","Admin","admin","admin");
		
		
		System.out.println("-----------Welcome!-----------");
		for (int i = 0; i < 4; i++) {
			System.out.println("Enter admin username");
			String username = sc.next();
			System.out.println("Enter admin password");
			String password = sc.next();
			if (!username.equals(admin.getUsername()) || !password.equals(admin.getPassword())) {
				System.out.println("Wrong admin username or password!");
				if (i == 3) {
					throw new Exception("Wrong username or password entered 4 times");
				}
			} else {
				break;
			}
		}

		while(true) {
				showAdminMenu();
				System.out.print("Choose an option: ");
				int choise = sc.nextInt();
				String username;
				switch(choise) {
					
				case 1:
					admin.insert();
					break;
				case 2:
					admin.showEditors();
					break;
				case 3:
					System.out.println("Enter username: ");
					username = sc.next();					
					admin.showEditor(username);
					break;
				case 4:
					System.out.println("Enter username: ");
					username = sc.next();	
					admin.change(username);
					break;
				case 5:
					System.out.println("Enter username: ");
					username = sc.next();	
					admin.deleteEditor(username);
					break;
				case 0:
					System.out.println("End of program!");
					break;
				default:
					System.out.println("Wrong option chosen!");
				}				
			}
	}
	public static void showAdminMenu() {
		System.out.println("1. Input user");
		System.out.println("2. Show all users");
		System.out.println("3. Show user");
		System.out.println("4. Change user");
		System.out.println("5. Delete user");
		System.out.println("0. End of program");
	}
}
