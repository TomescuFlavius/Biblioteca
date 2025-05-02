package app.enrolments.models;

public class Enrolment {
    private  int id;
    private int studentId;
    private int courseId;
    private String addedDate;

    public Enrolment(int id, int studentId, int courseId, String addedDate) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.addedDate = addedDate;
    }
    public Enrolment(int studentId, int courseId, String addedDate) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.addedDate = addedDate;
    }


    public Enrolment(String text){
        text.split(",");
        this.id=Integer.parseInt(text.split(",")[0]);
        this.studentId=Integer.parseInt(text.split(",")[1]);
        this.courseId=Integer.parseInt(text.split(",")[2]);
        this.addedDate=text.split(",")[3];
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

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
    public String toSave(){
        return id+","+studentId+","+courseId+","+addedDate+"\n";
    }

}

