package app;

import app.books.models.Book;
import app.books.services.BookService;
import app.courses.services.CourseService;
import app.enrolments.models.Enrolment;
import app.enrolments.services.EnrolmentService;
import app.students.models.Student;
import app.students.services.StudentService;
import app.views.View;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        CourseService courseService = new CourseService();
        EnrolmentService enrolmentService = new EnrolmentService();
        StudentService studentService = new StudentService();
        View view = new View();
        view.play();
    }
}