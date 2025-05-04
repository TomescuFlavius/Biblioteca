package app.views;

import app.students.models.Student;
import app.students.services.StudentService;

import java.util.Scanner;

public class ViewLogin {
    private Scanner scanner;
    private StudentService studentService;

    public ViewLogin() {
        scanner = new Scanner(System.in);
        studentService = new StudentService();
        this.play1();
    }
    private void meniu() {
        System.out.println("Apasati tasta 1 pentru login");
        System.out.println("Apasati tasta 2 pentru inregistrare");
    }
    private void play1() {
        boolean run = true;
        while (run) {
            meniu();
            int option = Integer.parseInt(scanner.nextLine());
            switch (option) {
                case 1:this.login();
                break;
                case 2:this.signIn();
                break;

                default:
                    System.out.println("Alegere invalida");
            }

        }
    }


    public void login() {
        System.out.println("Email:");
        String email=scanner.nextLine();

        System.out.println("Password:");
        String password=scanner.nextLine();

        Student student= this.studentService.getStudentByEmailAndPassword(email,password);

        if (student == null) {
            System.out.println("Email sau Parola incorecta");
        }
        else{
            View view = new View(student);
        }
        }

        public void signIn() {
        System.out.println("Email:");
        String email=scanner.nextLine();
        }
    }
