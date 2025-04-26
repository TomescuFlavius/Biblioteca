package app.courses.models;

public class Course {
    private int id;
    private String name;
    private String department;

    public Course(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course() {
        this.id = 0;
        this.name = "";
        this.department = "";
    }

    public Course(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.name = text.split(",")[1];
        this.department = text.split(",")[2];
    }

    public String descriere(){
        String text="";
        text+="id: "+this.id+"\n";
        text+="name: "+this.name+"\n";
        text+="department: "+this.department+"\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
