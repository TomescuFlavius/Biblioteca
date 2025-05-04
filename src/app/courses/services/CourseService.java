package app.courses.services;

import app.courses.models.Course;
import app.enrolments.models.Enrolment;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseService {
    private File file;
    private List<Course> courses;
    public CourseService() {
        courses = new ArrayList<Course>();
        file = new File("C:\\mycode\\oop\\Biblioteca\\src\\app\\courses\\file\\CourseFile");
        this.loadCourses();
    }

    private void loadCourses() {
        try{
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Course course = new Course(line);
                courses.add(course);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void showCourses() {
        for (Course course : courses) {
            System.out.println(course.descriere());
        }
    }

    public void saveCourses() {
        try {
            FileWriter fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);
            printWriter.println(toSaveCourses());
            printWriter.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public String toSaveCourses() {
        String result = "";
        int i;
        for (i=0; i<courses.size()-1; i++) {
            result += courses.get(i).descriere();
        }
        return result+courses.get(i).descriere();
    }

    public void addCourse(Course course) {
        courses.add(course);
        saveCourses();
    }

    public Course getCoursesById(int id) {
        for (Course course : courses) {
            if (course.getId() == id) {
                return course;
            }
        }
        return null;
    }

    public Course chooseCoursebyName(String name) {
        for (Course course : courses) {
        if (course.getName().equals(name)) {
            return course;
            }
        }
        return null;
    }

    public void removeCoursebyName(String nume) {
        for (int i = 0; i < courses.size(); i++) {
            if (courses.get(i).getName().equals(nume)) {
                courses.remove(i);
                saveCourses();
            }
        }
    }

    public List<Course> showEnrolmentsForStudent(List<Enrolment> enrolments) {
        List<Course> courses1 = new ArrayList<>();
        for(Enrolment enrolment : enrolments) {
            int id = enrolment.getCourseId();
            Course course =getCoursesById(id);
            courses1.add(course);
        }
        return courses1;
    }






}
