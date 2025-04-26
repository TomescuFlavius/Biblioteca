package app.enrolments.models;

public class Enrolment {
    private  int id;
    private int studentId;
    private int courseId;
    private float addedDate;

    public Enrolment(int id, int studentId, int courseId, float addedDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.addedDate = addedDate;
    }

    public Enrolment() {
        this.id=0;
        this.studentId=0;
        this.courseId=0;
        this.addedDate=0;
    }

    public Enrolment(String text){
        text.split(",");
        this.id=Integer.parseInt(text.split(",")[0]);
        this.studentId=Integer.parseInt(text.split(",")[1]);
        this.courseId=Integer.parseInt(text.split(",")[2]);
        this.addedDate=Float.parseFloat(text.split(",")[3]);
    }

    public String descriere(){
        String text="";
        text+="id: " + this.id + "\n";
        text+="studentId: " + this.studentId + "\n";
        text+="courseId: " + this.courseId + "\n";
        text+="addedDate: " + this.addedDate + "\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public float getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(float addedDate) {
        this.addedDate = addedDate;
    }
}

