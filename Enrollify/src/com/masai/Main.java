package com.masai;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		  try (Scanner scanner = new Scanner(System.in)) {
			System.out.println("Welcome to the Automated Student Registration System!");

	        while (true) {
	            System.out.println("Please select an option:");
	            System.out.println("1. Administrator login");
	            System.out.println("2. Student login");
	            System.out.println("3. SignUp");
	            System.out.println("4. Exit");

	            int choice = scanner.nextInt();
	            scanner.nextLine();

	            switch (choice) {
	                case 1:
	                    System.out.println("Enter username:");
	                    String adminUsername = scanner.nextLine();
	                    System.out.println("Enter password:");
	                    String adminPassword = scanner.nextLine();
	                    if (adminUsername.equals("admin") && adminPassword.equals("admin")) {
	                        // administrator menu
	                        System.out.println("Administrator login successful.");
	                        boolean isAdminMenuActive = true;
	                        while (isAdminMenuActive) {
	                            System.out.println("Please select an option:");
	                            System.out.println("1. Add new course");
	                            System.out.println("2. Search for course information");
	                            System.out.println("3. Update course details");
	                            System.out.println("4. Create batch under a course");
	                            System.out.println("5. Search for batch information");
	                            System.out.println("6. Update batch details");
	                            System.out.println("7. View student details");
	                            System.out.println("8. View student list of a batch");
	                            System.out.println("9. Consolidate report batch-wise");
	                            System.out.println("10. Consolidate report course-wise");
	                            System.out.println("11. Logout");

	                            int adminMenuChoice = scanner.nextInt();
	                            scanner.nextLine();

	                            switch (adminMenuChoice) {
	                                case 1:
	                                    // add new course
	                                    break;
	                                case 2:
	                                    // search for course information
	                                    break;
	                                case 3:
	                                    // update course details
	                                    break;
	                                case 4:
	                                    // create batch under a course
	                                    break;
	                                case 5:
	                                    // search for batch information
	                                    break;
	                                case 6:
	                                    // update batch details
	                                    break;
	                                case 7:
	                                    // view student details
	                                    break;
	                                case 8:
	                                    // view student list of a batch
	                                    break;
	                                case 9:
	                                    // consolidate report batch-wise
	                                    break;
	                                case 10:
	                                    // consolidate report course-wise
	                                    break;
	                                case 11:
	                                    // logout
	                                    isAdminMenuActive = false;
	                                    break;
	                                default:
	                                    System.out.println("Invalid choice.");
	                                    break;
	                            }
	                        }
	                    } else {
	                        System.out.println("Invalid username or password.");
	                    }
	                    break;
	                case 2:
	                    // student login
	                	System.out.println("Enter username:");
	                    String studentUsername = scanner.nextLine();
	                    System.out.println("Enter password:");
	                    String studentPassword = scanner.nextLine();
	                    
	                    break;
	                case 3:
	                    // SignUp
	             
	                    break;
	                case 4:
	                    System.exit(0);
	                    break;
	                default:
	                    System.out.println("Invalid choice.");
	                    break;
	            }
	        }
		}

	}

}
