# **Automated Student Registration System**
This is a software application that automates the student registration process in an educational institute. It helps to create batches under a course, register students, and efficiently allocate them to a batch.

### **Problem Description:**
In an Educational Institute, every year technology training is conducted during the summer and winter seasons. Students are enrolled in different courses under different technology tracks like- Android, Java, JEE, PHP, Oracle, etc. This automated application will help Institute create batches under a course, register the students, and efficiently allocate the student in a batch.

### **Installation:**

1. Open the project in your favorite IDE 
2. Run the main class (Main.java)

## **The main users of the system:**
- Administrator
* Students

### **Roles for Administrator:**

1. Add new Courses
2.  Search for information about courses (by course name, duration range and fee range)
3. Update details of course
4. Create a Batch under a course.
5. Search for information about batches (by batch name, by start date range, by end date range, by start and end date. By course name of the batch)
6. Update details of batch
7. View student details
8. View the student list of a batch
9. Consolidate the report batch-wise that contains the total students in every batch; also Consolidate the report course-wise that contains total batches and total students in every course.

### **Roles for a Student:**

1.  Students can sign-up. At the time of sign up first name, last name, address, mobile number, email, and password should be taken.
2.  Sign in with an email and password
3.  Can update personal details
4.  Can change the password. An old password has to be entered for changing the password
5.  Can see all the available course list
6.  Can see all batches course-wise along with available seats.
7.  Register himself in a course and select any batch for himself from the list of upcoming batches for this course

### Note:

1. You are free to add any number of fields in every class as per the requirement & additional features.
2. One course can have many batches but a batch can belong to a single course.
3. A student can be enrolled in any number of courses and a course can have any number of students.
4. Kindly throw the appropriate exception for any invalid data entry like duplicate email, incorrect course name, batch name, etc.
