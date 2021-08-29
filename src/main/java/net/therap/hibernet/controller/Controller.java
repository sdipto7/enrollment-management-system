package net.therap.hibernet.controller;

import net.therap.hibernet.View.EnrollmentView;
import net.therap.hibernet.domain.Course;
import net.therap.hibernet.domain.Enrollment;
import net.therap.hibernet.domain.User;
import net.therap.hibernet.service.EnrollmentService;
import net.therap.hibernet.service.UserService;

import java.util.List;
import java.util.Scanner;

/**
 * @author rumi.dipto
 * @since 8/24/21
 */
public class Controller {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("Press 0 to exit");
            System.out.println("Press 1 to view courses");
            System.out.println("Press 2 to view users"); //u
            System.out.println("Press 3 to view course enrollment details");
            System.out.println("Press 4 to add a new course");
            System.out.println("Press 5 to add a new user"); //u
            System.out.println("Press 6 to add a new enrollment");
            System.out.println("Press 7 to update a course information");
            System.out.println("Press 8 to update an user information"); //u
            System.out.println("Press 9 to update an enrollment information");
            System.out.println("Press 10 to view a specific course information");
            System.out.println("Press 11 to view a specific user information"); //u
            System.out.println("Press 12 to view a specific enrollment information");
            System.out.println("Press 13 to delete a course information");
            System.out.println("Press 14 to delete an user information"); //u
            System.out.println("Press 15 to delete an enrollment information");

            int operation = input.nextInt();
            if (operation == 0) {
                break;
            }
            executeOperation(operation);
            System.out.println("\n===========\n");
        }
        input.close();
    }

    public static void executeOperation(int operation) {
        EnrollmentService enrollmentService = new EnrollmentService();

        CourseController courseController = new CourseController();

        UserController userController = new UserController();

        long courseId;

        long userId;

        long enrollmentId;

        Scanner input = new Scanner(System.in);

        switch (operation) {
            case 1:
                courseController.viewAllCourses();
                break;

            case 2:
                userController.viewAllUsers();
                break;

            case 3:
                List<Enrollment> enrollmentList = enrollmentService.getEnrollmentList();
                EnrollmentView.printEnrollmentList(enrollmentList);
                break;

            case 4:
                courseController.addCourse();
                break;

            case 5:
                userController.addUser();
                break;

            case 6:
                System.out.println("Enter user id");
                userId = input.nextLong();
                input.nextLine();

                System.out.println("Enter course code");
                courseId = input.nextLong();
                input.nextLine();

                enrollmentService.addEnrollment(userId, courseId);
                break;

            case 7:
                courseController.updateCourse();
                break;

            case 8:
                userController.updateUser();
                break;

            case 9:
                System.out.println("Enter the id of enrollment: ");
                enrollmentId = input.nextLong();

                System.out.println("Enter the new user id: ");
                long newUserId = input.nextLong();

                System.out.println("Enter the new course id: ");
                long newCourseId = input.nextLong();

                enrollmentService.updateEnrollment(enrollmentId, newUserId, newUserId);
                break;

            case 10:
                courseController.viewCourse();
                break;

            case 11:
                userController.viewUser();
                break;

            case 12:
                System.out.println("Enter the enrollment id: ");
                enrollmentId = input.nextLong();

                Enrollment enrollment = enrollmentService.getEnrollment(enrollmentId);

                EnrollmentView.printEnrollment(enrollment);
                break;

            case 13:
                courseController.deleteCourse();
                break;

            case 14:
                userController.deleteUser();
                break;

            case 15:
                System.out.println("Enter the enrollment id: ");
                enrollmentId = input.nextLong();

                enrollmentService.deleteEnrollment(enrollmentId);
                break;

            default:
                System.out.println("Wrong input! Please enter a valid input");
                break;
        }
    }
}