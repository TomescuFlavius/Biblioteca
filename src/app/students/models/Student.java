package app.students.models;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private int age;

    public Student(int id, String firstName, String lastName, String email, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public Student(){
        this.id = 0;
        this.firstName = "";
        this.lastName = "";
        this.email = "";
        this.age = 0;
    }

    public Student(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.firstName = text.split(",")[1];
        this.lastName = text.split(",")[2];
        this.email = text.split(",")[3];
        this.age = Integer.parseInt(text.split(",")[4]);
    }

    public String descriere(){
        String text = "";
        text += "id: " + this.id + "\n";
        text += "firstName: " + this.firstName + "\n";
        text += "lastName: " + this.lastName + "\n";
        text += "email: " + this.email + "\n";
        text += "age: " + this.age + "\n";
        return text;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

