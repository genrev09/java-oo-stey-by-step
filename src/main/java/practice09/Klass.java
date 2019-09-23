package practice09;

import java.util.ArrayList;
import java.util.List;

public class Klass {
    private int number;
    private Student leader;
    private List<Student> members;

    public Klass(int number){
        this.number = number;
        members = new ArrayList<Student>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class " + Integer.toString(getNumber());
    }

    public void assignLeader(Student student){
        members.forEach(member -> {
            if (member == student)
                leader = member;
        });
        if (leader == null)
            System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student student){
        members.add(student);
    }

    public Student getLeader(){
        return leader;
    }
}
