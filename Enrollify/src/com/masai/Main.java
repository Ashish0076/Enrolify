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

	                            do {
	                                System.out.println("What do you want to do?");
	                                System.out.println("1. Add course");
	                                System.out.println("2. Delete course");
	                                System.out.println("3. Add batch");
	                                System.out.println("4. Delete batch");
	                                System.out.println("5. Add student");
	                                System.out.println("6. Delete student");
	                                System.out.println("7. View all courses");
	                                System.out.println("8. View all batches");
	                                System.out.println("9. View all students");
	                                System.out.println("0. Exit");
	                                choice = scanner.nextInt();
	                                scanner.nextLine(); // Consume newline character
	                                
	                                switch (choice) {
	                                    case 1:
	                                        // Add course
	                                        System.out.println("Enter course name:");
	                                        String courseName = scanner.nextLine();
	                                        Course course = new Course(courseName, adminMenuChoice, adminMenuChoice, adminUsername, null);
	                                        Administrator.addCourse(course);
	                                        System.out.println("Course added successfully.");
	                                        break;
	                                    case 2:
	                                        // Delete course
	                                        System.out.println("Enter course name:");
	                                        String courseNameToDelete = scanner.nextLine();
	                                        Course courseToDelete = Administrator.getCourseByName(courseNameToDelete);
	                                        if (courseToDelete == null) {
	                                            System.out.println("Course not found.");
	                                        } else {
	                                        	Administrator.getCourses().remove(courseToDelete);
	                                            System.out.println("Course deleted successfully.");
	                                        }
	                                        break;
	                                    case 3:
	                                        // Add batch
	                                        System.out.println("Enter course name:");
	                                        String courseNameToAddBatch = scanner.nextLine();
	                                        Course courseToAddBatch = Administrator.getCourseByName(courseNameToAddBatch);
	                                        if (courseToAddBatch == null) {
	                                            System.out.println("Course not found.");
	                                        } else {
	                                            System.out.println("Enter batch name:");
	                                            String batchName = scanner.nextLine();
	                                            Batch batch = new Batch(courseToAddBatch, batchName);
	                                            Administrator.getBatches().add(batch);
	                                            System.out.println("Batch added successfully.");
	                                        }
	                                        break;
	                                    case 4:
	                                        // Delete batch
	                                        System.out.println("Enter batch name:");
	                                        String batchNameToDelete = scanner.nextLine();
	                                        Batch batchToDelete = null;
	                                        for (Batch batch : Administrator.getBatches()) {
	                                            if (batch.getName().equals(batchNameToDelete)) {
	                                                batchToDelete = batch;
	                                                break;
	                                            }
	                                        }
	                                        if (batchToDelete == null) {
	                                            System.out.println("Batch not found.");
	                                        } else {
	                                        	Administrator.getBatches().remove(batchToDelete);
	                                            System.out.println("Batch deleted successfully.");
	                                        }
	                                        break;
	                                    case 5:
	                                        // Add student
	                                        System.out.println("Enter student first name:");
	                                        String firstName = scanner.nextLine();
	                                        System.out.println("Enter student last name:");
	                                        String lastName = scanner.nextLine();
	                                        System.out.println("Enter student email:");
	                                        String email = scanner.nextLine();
//	                                        Student student = new Student( firstName,  lastName,  address,  mobileNumber,  email,  password));
//	                                        Administrator.getStudents().add(student);
	                                        System.out.println("Student added successfully.");
	                                        break;
	                                    case 6:
	                                        // Delete student
	                                        System.out.println("Enter student email:");
	                                        String emailToDelete = scanner.nextLine();
	                                        Student studentToDelete = null;
	                                        for (Student s : Administrator.getStudents()) {
	                                            if (s.getEmail().equals(emailToDelete)) {
	                                                studentToDelete = s;
	                                                break;
	                                            }
	                                        }
	                                        if (studentToDelete == null) {
	                                            System.out.println("Student not found.");
	                                        } else {
	                                        	Administrator.getStudents().remove(studentToDelete);
	                                            System.out.println("Student deleted successfully.");
	                                        }
	                                        break;
	                                    case 7:
	                                        // View all courses
	                                        System.out.println("List of courses:");
	                                        for (Course c : Administrator.getCourses()) {
	                                            System.out.println(c.getName());
	                                        }
	                                        break;
	                                    case 8:
	                                        // View all batches
	                                        System.out.println("List of batches:");
	                                        for (Batch b : Administrator.getBatches()) {
	                                            System.out.println(b.getName() + " (" + b.getCourse().getName() + ")");
	                                        }
	                                        break;
	                                    case 9:
	                                        // View all students
	                                        System.out.println("List of students:");
	                                        for (Student s : Administrator.getStudents()) {
	                                            System.out.println(s.getFirstName() + " " + s.getLastName() + " (" + s.getEmail() + ")");
	                                        }
	                                        break;
	                                    case 0:
	                                        // Exit
	                                        System.out.println("Exiting program...");
	                                        break;
	                                    default:
	                                        // Invalid choice
	                                        System.out.println("Invalid choice.");
	                                        break;
	                                }
	                            } while (choice != 0);
	                            
	                            scanner.close();
	                        }}

	                      
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












//------------------------------------------------------------------------------------------------------
////Admin actions
//BusBookingSystem admin = new BusBookingSystem();
//Scanner scanner = new Scanner(System.in);
//BusBookingSystem busBookingSystem = new BusBookingSystem();
//
//// Login to the system
//System.out.print("Enter username: ");
//String username = scanner.nextLine();
//System.out.print("Enter password: ");
//String password = scanner.nextLine();
//if (busBookingSystem.login(username, password)) {
//    System.out.println("Login successful!");
//
//    // Show main menu
//    int choice;
//    do {
//        System.out.println("Choose an option:");
//        System.out.println("1. Add a bus");
//        System.out.println("2. Update a bus");
//        System.out.println("3. Delete a bus");
//        System.out.println("4. View all bookings");
//        System.out.println("5. View bookings by date range");
//        System.out.println("6. View bookings by bus name");
//        System.out.println("7. View bookings by user name");
//        System.out.println("8. Exit");
//        choice = scanner.nextInt();
//
//        switch (choice) {
//            case 1:
//                System.out.print("Enter bus name: ");
//                String busName = scanner.next();
//                System.out.print("Enter bus number: ");
//                int busNo = scanner.nextInt();
//                System.out.print("Enter source: ");
//                String source = scanner.next();
//                System.out.print("Enter destination: ");
//                String destination = scanner.next();
//                System.out.print("Enter bus type: ");
//                String busType = scanner.next();
//                System.out.print("Enter departure time (hh:mm): ");
//                String departureTimeString = scanner.next();
//                LocalTime departureTime = LocalTime.parse(departureTimeString);
//                System.out.print("Enter arrival time (hh:mm): ");
//                String arrivalTimeString = scanner.next();
//                LocalTime arrivalTime = LocalTime.parse(arrivalTimeString);
//                System.out.print("Enter total seats: ");
//                int totalSeats = scanner.nextInt();
//                busBookingSystem.addBus(busName, busNo, source, destination, busType, departureTime, arrivalTime, totalSeats);
//                break;
//            case 2:
//                System.out.print("Enter bus name: ");
//                busName = scanner.next();
//                System.out.print("Enter bus number: ");
//                busNo = scanner.nextInt();
//                System.out.print("Enter new bus name: ");
//                String newBusName = scanner.next();
//                System.out.print("Enter new bus type: ");
//                String newBusType = scanner.next();
//                System.out.print("Enter new total seats: ");
//                int newTotalSeats = scanner.nextInt();
//                busBookingSystem.updateBus(busName, busNo, newBusName, newBusType, newTotalSeats);
//                break;
//            case 3:
//                System.out.print("Enter bus name: ");
//                busName = scanner.next();
//                System.out.print("Enter bus number: ");
//                busNo = scanner.nextInt();
//                busBookingSystem.deleteBus(busName, busNo);
//                break;
//            case 4:
//                busBookingSystem.viewAllBookings();
//                break;
//            case 5:
//                System.out.print("Enter start date (yyyy-mm-dd): ");
//                String startDateString = scanner.next();
//                LocalDate startDate = LocalDate.parse(startDateString);
//                System.out.print("Enter end date (yyyy-mm-dd): ");
//                String endDateString = scanner.next();
//                LocalDate endDate = LocalDate.parse(endDateString);
//                busBookingSystem.viewBookingsByDate(startDate, endDate);
//                break;
//            case 6:
//                System.out.print("Enter bus name: ");
//                busName = scanner.next();
//                busBookingSystem.viewBookingsByBusName(busName);
//                break;
//            case 7:
//                System.out.print("Enter user name: ");
//                String userName = scanner.next();
//                busBookingSystem.viewBookingsByUserName(userName);
//                break;
//            case 8:
//                System.out.println("Exiting...");
//                	Main.main(args);
//                break;
//            default:
//                System.out.println("Invalid choice!");
//        }
//
//    } while (choice != 8);
//
//} else {
//    System.out.println("Invalid username or password!");
//}
