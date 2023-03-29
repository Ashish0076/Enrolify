import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String firstName;
    private String lastName;
    private String address;
    private String mobileNumber;
    private String email;
    private String password;
    private List<Course> registeredCourses;

    public Student(String firstName, String lastName, String address, String mobileNumber, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        this.email = email;
        this.password = password;
        this.registeredCourses = new ArrayList<>();
    }

    public void updatePersonalDetails(String firstName, String lastName, String address, String mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.mobileNumber = mobileNumber;
        System.out.println("Personal details updated successfully!");
    }

    public void changePassword(String oldPassword, String newPassword) {
        if (this.password.equals(oldPassword)) {
            this.password = newPassword;
            System.out.println("Password changed successfully!");
        } else {
            System.out.println("Old password is incorrect!");
        }
    }

    public void viewAvailableCourses(List<Course> courses) {
        System.out.println("List of available courses:");
        for (Course course : courses) {
            System.out.println(course.getName());
        }
    }
    
    public void viewCourseBatches(List<Course> courses) {
        System.out.println("Available Batches:");
        for (Course course : courses) {
            System.out.println(course.getName() + ":");
            List<Batch> batches = course.getBatches();
            for (Batch batch : batches) {
                System.out.println("Batch " + batch);
            }
        }
    }
}