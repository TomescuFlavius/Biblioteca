package app.students.models;

public class StudentIdCard {
    private int id;
    private int studentId;
    private int cardNumber;

    public StudentIdCard(int id, int studentId, int cardNumber) {
        this.id = id;
        this.studentId = studentId;
        this.cardNumber = cardNumber;
    }
    public StudentIdCard() {
        this.id = 0;
        this.studentId = 0;
        this.cardNumber = 0;
    }
    public StudentIdCard(String text) {
        text.split(",");
        this.id = Integer.parseInt(text.split(" ")[0]);
        this.studentId = Integer.parseInt(text.split(" ")[1]);
        this.cardNumber = Integer.parseInt(text.split(" ")[2]);
    }
    public String descriere(){
        String text="";
        text+="id: "+this.id+"\n";
        text+="studentId: "+this.studentId+"\n";
        text+="cardNumber: "+this.cardNumber+"\n";
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

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }
}
