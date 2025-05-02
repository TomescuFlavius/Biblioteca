package app.books.models;

public class Book {
    private int id;
    private int studentId;
    private String name;
    private String addedDate;

    public Book(int id, int studentId, String name, String addedDate) {
        this.id = id;
        this.studentId = studentId;
        this.name = name;
        this.addedDate = addedDate;
    }
    public Book(int studentId, String name, String addedDate) {
        this.studentId = studentId;
        this.name = name;
        this.addedDate = addedDate;
    }

    public Book(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.studentId = Integer.parseInt(text.split(",")[1]);
        this.name = text.split(",")[2];
        this.addedDate = text.split(",")[3];
    }

    public String descriere(){
        String text="";
        text+="id:" + this.id + ",";
        text+="id student:"+this.studentId + ",";
        text+="name:"+this.name + ",";
        text+="data:"+this.addedDate+ "\n";
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(String addedDate) {
        this.addedDate = addedDate;
    }
    public String toSave(){
        return id+","+studentId+","+name+","+addedDate+"\n";
    }

}
