package app.enrolments.services;

import app.courses.models.Course;
import app.enrolments.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class EnrolmentService {
    private File file;
    private List<Enrolment> enrolments;
    public EnrolmentService() {
        this.file = new File("C:\\mycode\\oop\\Biblioteca\\src\\app\\enrolments\\file\\Enrolments");
        this.enrolments = new ArrayList<Enrolment>();
        this.loadEnrolments();
    }
    public void loadEnrolments() {
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Enrolment enrolment = new Enrolment(line);
                this.enrolments.add(enrolment);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public void showEnrolments() {
        for (Enrolment enrolment : enrolments) {
            System.out.println(enrolment.descriere());
        }
    }

    public void saveEnrolments() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(toSaveEnrolments());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveEnrolments() {
        String text="";
        int i;
        for(i=0;i<enrolments.size()-1;i++){
            text += enrolments.get(i).toSave();
        }
        return text+enrolments.get(i).toSave();
    }


    public void addEnrolment(Enrolment enrolment) {
        enrolment.setId(generateId());
        this.enrolments.add(enrolment);
        saveEnrolments();
    }

    public void getEnrolmentsbyStudentId(int id) {
        for (Enrolment enrolment : enrolments) {
            if(id == enrolment.getStudentId()){
                System.out.println(enrolment.descriere());
            }
        }
    }

    public Enrolment getEnrolmentById(int id) {
        for (Enrolment enrolment : enrolments) {
            if (enrolment.getId() == id) {
                return enrolment;
            }
        }
        return null;
    }

    private int generateId() {
        Random random = new Random();
        int randomId = random.nextInt(1000) + 1;
        while (this.getEnrolmentById(randomId) != null) {
            randomId = random.nextInt(1000) + 1;
        }
        return randomId;
    }

    public int contorAparitii(int courseId){
        int ct=0;
        for (int i=0;i<enrolments.size();i++) {
            for (int j=i+1;j<enrolments.size();j++) {
                if (enrolments.get(i).getCourseId() == enrolments.get(j).getCourseId()) {
                    ct++;
                }
            }
        }
        return ct;
    }

    public void getEnrolmentsbyCourseId(int courseId) {
        for (Enrolment enrolment : enrolments) {
            if (enrolment.getCourseId() == courseId) {
                System.out.println(enrolment.descriere());
            }
        }
    }

    public Course mostPopularCourse() {
        int ct=0;
        for (int i=0;i<enrolments.size();i++){
            for (int j=i+1;j<enrolments.size();j++){
                if (enrolments.get(i).getCourseId() == enrolments.get(j).getCourseId()&& ct!=i){
                    ct++;
                }
                else if (enrolments.get(i).getCourseId()==enrolments.get(j).getCourseId()&& ct==i){
                    
                }
            }
        }
    }



}

