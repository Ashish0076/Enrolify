package com.masai;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Administrator admin = new Administrator();
		Student student = new Student();
		System.out.println("                                                         ");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("~ Welcome to the Automated Student Registration System! ~");
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		while (true) {
			System.out.println("================================");
			System.out.println("| Please select an option:     |");
			System.out.println("| 1. Administrator login       |");
			System.out.println("| 2. Student login             |");
			System.out.println("| 3. SignUp                    |");
			System.out.println("| 4. Exit                      |");
			System.out.println("================================");
			System.out.println("                                ");

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
						System.out.println("                                ");
						System.out.println("================================");
						System.out.println("| Please select an option:     |");
						System.out.println("| 1. Add new course            |");
						System.out.println("| 2. Delete course             |");
						System.out.println("| 3. Add batch                 |");
						System.out.println("| 4. Delete batch              |");
						System.out.println("| 5. Delete student            |");
						System.out.println("| 6. View all courses          |");
						System.out.println("| 7. View all batches          |");
						System.out.println("| 8. View all students         |");
						System.out.println("| 0. Exit                      |");
						System.out.println("================================");
						System.out.println("                                ");

						choice = scanner.nextInt();
						scanner.nextLine();
						switch (choice) {
						case 1:
							// Add course
							System.out.println("                                ");
							System.out.println("Enter course name:");
							String courseName = scanner.nextLine();
							System.out.println("Enter course duration:");
							int courseDuration = scanner.nextInt();
							scanner.nextLine();
							System.out.println("Enter course fees:");
							double courseFees = scanner.nextDouble();
							scanner.nextLine();
							Course course = new Course(courseName, courseDuration, courseFees);
							admin.addCourse(course);
							System.out.println("Course added successfully.");
							break;
						case 2:
							// Delete course
							System.out.println("                                ");
							System.out.println("Enter course name:");
							String courseNameToDelete = scanner.nextLine();
							Course courseToDelete = admin.getCourseByName(courseNameToDelete);
							if (courseToDelete == null) {
								System.out.println("Course not found.");
							} else {
								admin.getCourses().remove(courseToDelete);
								System.out.println("Course deleted successfully.");
							}
							break;
						case 3:
							// Add batch
							System.out.println("                                ");
							System.out.println("Enter course name:");
							String courseNameToAddBatch = scanner.nextLine();
							Course courseToAddBatch = admin.getCourseByName(courseNameToAddBatch);
							if (courseToAddBatch == null) {
								System.out.println("Course not found.");
							} else {
								System.out.println("Enter batch name:");
								String batchName = scanner.nextLine();
								System.out.println("Enter batch start date:");
								String startDate = scanner.nextLine();
								System.out.println("Enter batch end date:");
								String endDate = scanner.nextLine();
								System.out.println("Enter batch available seats:");
								int availableSeats = scanner.nextInt();
								Batch batch = new Batch(batchName, startDate, endDate, availableSeats,
										courseToAddBatch);
								admin.getBatches().add(batch);
								System.out.println("Batch added successfully.");
							}
							break;
						case 4:
							// Delete batch
							System.out.println("                                ");
							System.out.println("Enter batch name:");
							String batchNameToDelete = scanner.nextLine();
							Batch batchToDelete = null;
							for (Batch batch : admin.getBatches()) {
								if (batch.getName().equals(batchNameToDelete)) {
									batchToDelete = batch;
									break;
								}
							}
							if (batchToDelete == null) {
								System.out.println("Batch not found.");
							} else {
								admin.getBatches().remove(batchToDelete);
								System.out.println("Batch deleted successfully.");
							}
							break;
						case 5:
							// Delete student
							System.out.println("                                ");
							System.out.println("Enter student email:");
							String emailToDelete = scanner.nextLine();
							Student studentToDelete = null;
							for (Student s : admin.getStudents()) {
								if (s.getEmail().equals(emailToDelete)) {
									studentToDelete = s;
									break;
								}
							}
							if (studentToDelete == null) {
								System.out.println("Student not found.");
							} else {
								admin.getStudents().remove(studentToDelete);
								System.out.println("Student deleted successfully.");
							}
							break;
						case 6:
							// View all courses
							System.out.println("                                ");
							System.out.println("List of courses:");
							for (Course c : admin.getCourses()) {
								System.out.println(c.getName());
							}
							break;
						case 7:
							// View all batches
							System.out.println("                                ");
							System.out.println("List of batches:");
							for (Batch b : admin.getBatches()) {
								System.out.println(b.getBatchName() + " -" + b.getCourse().getName() + " ");
							}
							break;
						case 8:
							// View all students
							System.out.println("                                ");
							System.out.println("List of students:");
							for (Student s : admin.getStudents()) {
								System.out
										.println(s.getFirstName() + " " + s.getLastName() + " (" + s.getEmail() + ")");
							}
							break;
						case 0:
							// Exit
							System.out.println("Exiting...");
							// Main.main(args);
							isAdminMenuActive = false;
							break;
						default:
							// Invalid choice
							System.out.println("                                ");
							System.out.println("Invalid choice.");
							break;
						}
					}
				} else {
					System.out.println("Invalid Credentials!");
				}
				break;

			case 2:
				// student login
				System.out.println("Enter email:");
				String email = scanner.nextLine();
				System.out.println("Enter password:");
				String password = scanner.nextLine();
				boolean foundStudent = false;
				for (Student stu : admin.getStudents()) {
					if (stu.getEmail().equals(email) && stu.getPassword().equals(password)) {
						// Student menu
						System.out.println("Student login successful.");
						foundStudent = true;
						// ... the rest of the student menu code ...
						break;
					}
				}
				if (!foundStudent) {
					System.out.println("Invalid email or password.");
				}
				if (foundStudent) {
					// Student menu
					boolean isAdminMenuActive = true;
					while (isAdminMenuActive) {
						System.out.println("                                ");
						System.out.println("================================");
						System.out.println("| Please select an option:     |");
						System.out.println("| 1. Update details            |");
						System.out.println("| 2. Change Password           |");
						System.out.println("| 3. View available course     |");
						System.out.println("| 4. View all batches          |");
						System.out.println("| 5. Register for course       |");
						System.out.println("| 0. Exit                      |");
						System.out.println("================================");
						System.out.println("                                ");

						choice = scanner.nextInt();
						scanner.nextLine();

						switch (choice) {
						case 1:
							// Update details
							System.out.println("Please select a field to update:");
							System.out.println("1. First name");
							System.out.println("2. Last name");
							System.out.println("3. Address");
							System.out.println("4. Mobile number");
							System.out.println("5. Email");
							int fieldOption = scanner.nextInt();
							scanner.nextLine(); // Consume the remaining newline character
							System.out.println("Please enter the new value:");
							String newValue = scanner.nextLine();
							switch (fieldOption) {
							case 1:
								student.updatePersonalDetails("firstName", newValue);
								break;
							case 2:
								student.updatePersonalDetails("lastName", newValue);
								break;
							case 3:
								student.updatePersonalDetails("address", newValue);
								break;
							case 4:
								student.updatePersonalDetails("mobileNumber", newValue);
								break;
							case 5:
								student.updatePersonalDetails("email", newValue);
								break;
							default:
								System.out.println("Invalid field option. Please try again.");
								break;
							}
							System.out.println("Details updated successfully.");
							break;

						case 2:
							// Change password
							// Change password
							System.out.println("                                ");

							System.out.println("Enter current password:");
							String currentPassword = scanner.nextLine();

							System.out.println("Enter new password:");
							String newPass = scanner.nextLine();
							if (student == null) {
							    System.out.println("Student not found. Please try again.");
							} else {
							    // change password
							    if (student.getPassword().equals(currentPassword)) {
							        student.setPassword(newPass);
							        System.out.println("Password changed successfully.");
							    } else {
							        System.out.println("Invalid password. Please try again.");
							    }
							}

							break;

						case 3:
							// View available courses
							System.out.println("                                ");
							System.out.println("List of courses:");
							for (Course c : admin.getCourses()) {
								System.out.println(c.getName());
							}
							break;

						case 4:
							// View all batches
							System.out.println("                                ");
							System.out.println("List of batches:");
							for (Batch b : admin.getBatches()) {
								System.out.println(b.getBatchName() + " -" + b.getCourse().getName() + " ");
							}
							break;

						case 5:
							// Register for course
							System.out.println("                                ");
							System.out.println("Enter course name:");
							String courseName = scanner.nextLine();

							List<Course> course = new ArrayList<>();
							for (Course c : admin.getCourses()) {
							    if (c.getName().equals(courseName)) {
							        course.add(c);
							        break;
							    }
							}

							if (course.isEmpty()) {
							    System.out.println("Course not found. Please try again");
							} else {
							    student.registerCourse(course);
							    System.out.println("Course successfully registered.");
							}
							break;
						case 0:
							// Exit
							System.out.println("                                ");
							System.out.println("Exiting program...");
							isAdminMenuActive = false;
							break;
						default:
							// Invalid choice
							System.out.println("                                ");
							System.out.println("Invalid choice.");
							break;

						}
					}
				}
				break;
			case 3:
				// SignUp
				System.out.println("                                ");
				System.out.println("Enter student first name:");
				String firstName = scanner.nextLine();
				System.out.println("Enter student last name:");
				String lastName = scanner.nextLine();
				System.out.println("Enter student address:");
				String address = scanner.nextLine();
				System.out.println("Enter student mobile number:");
				String mobile = scanner.nextLine();
				System.out.println("Enter student email:");
				String email1 = scanner.nextLine();
				System.out.println("Enter student password:");
				String password1 = scanner.nextLine();
				Student students = new Student(firstName, lastName, address, mobile, email1, password1);
				admin.getStudents().add(students);
				System.out.println("Student added successfully.");
				break;
			case 4:
				System.out.println("Successfully Exit!");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid choice.");
				break;
			}
		}
	}
}

//------------------------------------------------------------------------------------------------------
//	ArrayList<Passenger> passengerList = new ArrayList<>();
//
//	
//    Passenger loggedInPassenger = null;
//
//    while (true) {
//        System.out.println("*** Bus Reservation System ***");
//        System.out.println("1. View all buses");
//        System.out.println("2. Sign up");
//        System.out.println("3. Login");
//        System.out.println("4. Update personal details");
//        System.out.println("5. Change password");
//        System.out.println("6. View booking history");
//        System.out.println("7. Cancel ticket");
//        System.out.println("8. Book ticket");
//        System.out.println("9. Logout");
//        System.out.println("10. view passenger");
//        System.out.println("0. Exit");
//
//        int choice = scanner.nextInt(); 
//        scanner.nextLine();
//
//        switch (choice) {
//            case 1:
//                // View all buses
//            	if(BusBookingSystem.busList.size()==0) {
//            		System.out.println("There is no buses");
//            	}else {        	                		
//            		for (Bus bus : BusBookingSystem.busList) {
//            			//System.out.println("Bus: " +bus.getBusName()+" "+ bus.getAvailableSeats());
//            			System.out.println(bus);
//            		}
//            	}
//                break;
//            case 2:
//                // Sign up
//                Passenger passenger = Passenger.signUp();
//                passengerList.add(passenger);
//                System.out.println("Sign up successful!");
//                break;
//            case 3:
//                // Login
//                if (loggedInPassenger != null) {
//                    System.out.println("You are already logged in!");
//                    break;
//                }
//
//                System.out.println("Enter your username: ");
//                String username = scanner.nextLine();
//                System.out.println("Enter your password: ");
//                String password = scanner.nextLine();
//
//                for (Passenger passenger1 : passengerList) {
//                    if (passenger1.getUsername().equals(username) && passenger1.getPassword().equals(password)) {
//                        loggedInPassenger = passenger1;
//                        System.out.println("Login successful!");
//                        break;
//                    }
//                }
//
//                if (loggedInPassenger == null) {
//                    System.out.println("Invalid username or password!");
//                }
//
//                break;
//            case 4:
//                // Update personal details
//                if (loggedInPassenger == null) {
//                    System.out.println("You need to login first!");
//                    break;
//                }
//
//                System.out.println("Enter your first name:");
//                String firstName = scanner.nextLine();
//                System.out.println("Enter your last name:");
//                String lastName = scanner.nextLine();
//                System.out.println("Enter your address:");
//                String address = scanner.nextLine();
//                System.out.println("Enter your mobile number:");
//                String mobileNo = scanner.nextLine();
//
//                loggedInPassenger.updatePersonalDetails(firstName, lastName, address, mobileNo);
//                break;
//            case 5:
//                // Change password
//                if (loggedInPassenger == null) {
//                    System.out.println("You need to login first!");
//                    break;
//                }
//
//                System.out.println("Enter your current password: ");
//                String currentPassword = scanner.nextLine();
//
//                if (!loggedInPassenger.getPassword().equals(currentPassword)) {
//                    System.out.println("Invalid password!");
//                    break;
//                }
//
//                System.out.println("Enter your new password: ");
//                String newPassword = scanner.nextLine();
//                loggedInPassenger.setPassword(newPassword);
//                System.out.println("Password changed successfully!");
//
//                break;
//            case 6:
//                // View booking history
//                if (loggedInPassenger == null) {
//                    System.out.println("You need to login first!");
//                    break;
//                }
//
//                for (Booking booking : loggedInPassenger.getBookingHistory()) {
//                    System.out.println(booking.toString());
//                }
//
//                break;
//            case 7:
//                // Cancel Ticket
//                if (loggedInPassenger == null) {
//                    System.out.println("You need to login first!");
//                    break;
//                }
//
//                System.out.println("Enter the booking ID to cancel: ");
//                int bookingId = scanner.nextInt();
//                scanner.nextLine();
//
//                for (Booking booking : loggedInPassenger.getBookingHistory()) {
//                    if (booking.getBookingID() == bookingId) {
////                        booking.getBusName(). .cancelBooking(booking.getNumSeats());
//                        loggedInPassenger.cancelBooking(booking);
//                        System.out.println("Booking cancelled successfully!");
//                        break;
//                    }
//                }
//
//
//                break;
//            case 8:
//            	// Book ticket
//            	if (loggedInPassenger == null) {
//            	    System.out.println("You need to login first!");
//            	    break;
//            	}
//
//            	System.out.println("Enter username: ");
//            	String passengerUsername= scanner.nextLine();
//            	System.out.println("Enter the source: ");
//            	String source = scanner.nextLine();
//            	System.out.println("Enter the destination: ");
//            	String destination = scanner.nextLine();
//            	System.out.println("Enter the travel date (dd/mm/yyyy): ");
//            	String travelDate = scanner.nextLine();
//            	System.out.println("Enter the bus name: ");
//            	String busName = scanner.nextLine();
//            	System.out.println("Enter the Number of seats: ");
//            	int numSeats = scanner.nextInt();
//
//            	Bus bus = null;
//            	for (Bus b : BusBookingSystem.busList) {
//            	    if (b.getBusName().equals(busName)) {
//            	        bus = b;
//            	        break;
//            	    }
//            	}
//
//            	if (bus == null) {
//            	    System.out.println("Invalid bus name!");
//            	    break;
//            	}
//
//            	int availableSeats = bus.getAvailableSeats();
//            	if (availableSeats <= 0) {
//            	    System.out.println("No seats available on this bus!");
//            	    break;
//            	}
//
//            	System.out.println("Enter the number of tickets: ");
//            	int numTickets = scanner.nextInt();
//            	scanner.nextLine();
//
//            	if (numTickets > availableSeats) {
//            	    System.out.println("Only " + availableSeats + " seats are available on this bus!");
//            	    break;
//            	}
//
//            	double fare = bus.calculateFare(source, destination);
//            	double totalFare = fare * numSeats;
//
//            	Booking booking = new Booking(passengerUsername, busName, source, destination, numSeats);
//            	loggedInPassenger.addBooking(booking);
//            	BusBookingSystem.bookingList.add(booking);
////            	bus.bookTickets(passengerUsername, busName, source, destination, numSeats);
//
//            	System.out.println("Booking confirmed!");
//            	System.out.println("Booking ID: " + booking.getBookingID());
//            	System.out.println("Total fare: " + totalFare);
//
//
//
//                break;
//
//            case 9:
//                // Logout
//                if (loggedInPassenger == null) {
//                    System.out.println("You are not logged in!");
//                    break;
//                }
//
//                loggedInPassenger = null;
//                System.out.println("Logged out successfully!");
//
//                break;
//            case 10:
//        		for (Passenger psn : passengerList ) {
//        			System.out.println(psn);
//        		}
//
//                break;
//            case 0:
//                // Exit
//                System.out.println("Thank you for using Us!");
//                Main.main(args);
//                System.exit(0);
//                break;
//            default:
//        
//        } 
//    }
//} else {
//System.out.println("Invalid option selected");
//}
//	
//	
//	

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
