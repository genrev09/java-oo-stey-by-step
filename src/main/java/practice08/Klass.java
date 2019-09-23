package practice08;

public class Klass {
    private int number;
    private Student student;

    public Klass(int number){
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class " + Integer.toString(getNumber());
    }

    public void assignLeader(Student student){
        this.student = student;
    }

    public Student getLeader(){
        return student;
    }
}
