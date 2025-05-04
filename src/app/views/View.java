package app.views;

import app.books.models.Book;
import app.books.services.BookService;
import app.courses.models.Course;
import app.courses.services.CourseService;
import app.enrolments.models.Enrolment;
import app.enrolments.services.EnrolmentService;
import app.students.models.Student;
import app.students.services.StudentService;

import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.SortedMap;

public class View {
    private Scanner scanner;
    private StudentService studentService;
    private BookService bookService;
    private CourseService courseService;
    private EnrolmentService enrolmentService;
    private Student student;
    private Book book;
    private Course course;
    private Enrolment enrolment;

    public View(Student st) {
        scanner = new Scanner(System.in);
        studentService = new StudentService();
        bookService = new BookService();
        courseService = new CourseService();
        enrolmentService = new EnrolmentService();
        student = st;
        this.play();
    }

    private void meniu() {
        System.out.println("*1*->Adaugare carte");
        System.out.println("*2*->Stergere carte");
        System.out.println("*3*->Editare carte");
        System.out.println("*4*->Lista cursuri la care esti inscris");
        System.out.println("*5*->Inscriere curs");
        System.out.println("*6*->Cel mai bun curs");
        System.out.println("*7*->Stergere curs");
        System.out.println("*8*->Cartile mele");


    }

    public void play() {
        boolean running = true;
        while (running) {
            meniu();
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    this.addBook();
                    break;
                case 2:
                    this.deleteBook();
                    break;
                case 3:
                    this.editBook();
                    break;
                case 4:
                    this.showEnrolmentsByStudent();
                    break;
                case 5:
                    this.courseEnrolment();
                    break;
                case 6:
                    this.mostPopularCourse();
                    break;
                case 7:
                    this.removeCourse();
                    break;
                case 8:
                    this.showBooks();
                    break;

                    default:
                        System.out.println("invalid option");
            }
        }
    }

    public void addBook(){

        System.out.println("Cartea pe care vrei sa o adaugi:");
        System.out.println("nume: ");
        String nume=scanner.next();
        System.out.println("data: ");
        String data=scanner.next();

        Book book1 = new Book(student.getId(),nume,data);

        this.bookService.addBook(book1);
        this.bookService.saveBook();

        this.bookService.showBooks();
    }

    public void deleteBook(){
        this.bookService.showBooks();
        System.out.println("numele cartii pe care vreti sa o stergeti:");
        String nume=scanner.next();
        this.bookService.deleteBookByName(nume);
        this.bookService.saveBook();

        this.bookService.showBooks();

    }

    public void editBook(){
        this.bookService.showBooks();
        System.out.println("ID carte pe care vreti sa o editati:");
        int id = Integer.parseInt(scanner.next());
        System.out.println("nume nou: ");
        String nume=scanner.next();
        System.out.println("data : ");
        String data=scanner.next();
        this.bookService.editBook(id, nume,data);
        bookService.saveBook();
        bookService.showBooks();
    }

    public void showEnrolmentsByStudent(){

        List<Enrolment> enrolmentList= this.enrolmentService.listGetEnrolmentsbyStudentId(this.student.getId());

        List<Course> courses=this.courseService.showEnrolmentsForStudent(enrolmentList);

        for (Course course:courses){
            System.out.println(course.descriere());
        }





        }

    public void courseEnrolment(){
        this.courseService.showCourses();
        System.out.println("Alegeti un curs(numele):");
        String name=scanner.next();
        courseService.chooseCoursebyName(name);
        int courseId=courseService.chooseCoursebyName(name).getId();
        System.out.println("Data inscrierii la curs (an.luna.zi):");
        String data=scanner.next();

        Enrolment enrolment1=new Enrolment(student.getId(), courseId, data);
        System.out.println("Inscris la cursul:"+courseService.chooseCoursebyName(name).getName());
        enrolmentService.addEnrolment(enrolment1);
        enrolmentService.saveEnrolments();
        enrolmentService.showEnrolments();


    }

    public void mostPopularCourse(){

        System.out.println("most popular course:");
        int aparitii=enrolmentService.mostPopularCourse().getFrecventa();
        System.out.println(courseService.getCoursesById(aparitii).descriere());

    }

    public void removeCourse(){
        this.courseService.showCourses();
        System.out.println("Nume curs pentru stergere:");
        String nume=scanner.next();
        this.courseService.removeCoursebyName(nume);

        System.out.println("Curs sters!");
    }

    public void showBooks(){
        List<Book> books=this.bookService.getBooksByStudentId(student.getId());
        for (Book book:books){
            System.out.println(book.getName());
        }

    }



    }




