package app.students.services;

import app.books.models.Book;
import app.students.models.Student;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class StudentService {
    private File file;
    private List<Student> students;
    public StudentService() {
        file=new File("C:\\mycode\\oop\\Biblioteca\\src\\app\\students\\file\\Students");
        students=new ArrayList<Student>();
        this.loadStudents();
    }
    public void loadStudents() {
        try{Scanner scanner=new Scanner(file);
            while(scanner.hasNextLine()) {
                String line=scanner.nextLine();
                Student student=new Student(line);
                students.add(student);
            }

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void saveStudents() {
        try {
            FileWriter fw=new FileWriter(file);
            PrintWriter pw=new PrintWriter(fw);
            pw.println(toSaveStudents());
            pw.close();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String toSaveStudents(){
        String text="";
        int i;
        for(i=0;i<students.size()-1;i++){
            text+=students.get(i).toSave()+"\n";
        }
        return text+students.get(i).toSave();
    }

    public void showStudents(){
        for(Student student:students){
            System.out.println(student.descriere());
        }
    }

    public void addStudent(Student student){
        students.add(student);
        saveStudents();
    }
    public Student getStudentById(int id){
        for(Student student:students){
            if(student.getId()==id){
                return student;
            }
        }
        return null;
    }




    public Student getStudentByEmailAndPassword(String email, String password) {
    for(Student student:students){
        if(student.getEmail().equals(email) && student.getPassword().equals(password)){
            return student;
        }
    }
    return null;
    }

    public int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getStudentById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }

    public Student register() {

        for(Student student:students){
            return student;
        }
        return null;
    }







}

