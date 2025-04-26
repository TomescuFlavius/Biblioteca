package app.enrolments.services;

import app.enrolments.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
            printWriter.println(enrolments);
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveEnrolments() {
        String text="";
        int i;
        for(i=0;i<enrolments.size();i++){
            text += enrolments.get(i).descriere();
        }
        return text+enrolments.get(i).descriere();
    }

    public void addEnrolment(Enrolment enrolment) {
        this.enrolments.add(enrolment);
        saveEnrolments();
    }
}

