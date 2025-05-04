package app.enrolments.services;

import app.courses.models.Course;
import app.enrolments.models.Enrolment;
import app.utile.Frecventa;

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
    private List<Frecventa> frecvente;
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

    public List<Enrolment> listGetEnrolmentsbyStudentId(int id) {

        List<Enrolment> enrolmentList= new ArrayList<>();
        for (Enrolment enrolment : enrolments) {
            if (id == enrolment.getStudentId()) {
                enrolmentList.add(enrolment);
            }
        }
        return enrolmentList;
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

    public Frecventa mostPopularCourse() {
        this.frecvente=getFrecvente();
        Frecventa maxima=new Frecventa(0,0);
        for (Frecventa current : frecvente) {
            if(current.getFrecventa()>maxima.getFrecventa()){
                maxima=current;
            }
        }
        return maxima;
    }

    public List<Frecventa> getFrecvente() {
        List<Frecventa> frecventas = new ArrayList<>();
        for(int i=0;i<enrolments.size();i++){
            Frecventa frecventa=getFrecventaByCourseId(frecventas,enrolments.get(i).getCourseId());
            if(frecventa!=null){
                frecventa.setFrecventa(frecventa.getFrecventa()+1);
            }else{
                frecventas.add(new Frecventa(enrolments.get(i).getCourseId(),0));
            }

        }
        return frecventas;
    }


 //functie ce primeste ca parametru Lista de frecvente , idCursului si returneaza frecvenata

 public Frecventa getFrecventaByCourseId(List<Frecventa> frecventas, int idCourse) {
        int ct=0;
        for (int i=0;i<frecventas.size();i++) {
            if(frecventas.get(i).getIdCurs()==idCourse){
                return frecventas.get(i);
            }
        }
        return null;
 }




}

