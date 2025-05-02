package app.students.models;

public class Student {
    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private int age;

    public Student(int id, String firstName, String lastName, String email,String password, int age) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.age = age;
    }


    public Student(String text){
        text.split(",");
        this.id = Integer.parseInt(text.split(",")[0]);
        this.firstName = text.split(",")[1];
        this.lastName = text.split(",")[2];
        this.email = text.split(",")[3];
        this.password = text.split(",")[4];
        this.age = Integer.parseInt(text.split(",")[5]);
    }

    public String descriere(){
        String text = "";
        text += "id: " + this.id + "\n";
        text += "firstName: " + this.firstName + "\n";
        text += "lastName: " + this.lastName + "\n";
        text += "email: " + this.email + "\n";
        text += "password: " + this.password + "\n";
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

