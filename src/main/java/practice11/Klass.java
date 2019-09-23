package practice11;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

public class Klass extends Observable {
    private int number;
    private Student leader;
    private List<Student> members;
    private ArrayList<Observer> observerList;

    public Klass(int number){
        this.number = number;
        members = new ArrayList<Student>();
        observerList = new ArrayList<Observer>();
    }

    public int getNumber() {
        return number;
    }

    public String getDisplayName(){
        return "Class " + Integer.toString(getNumber());
    }

    public void assignLeader(Student student){
        members.forEach(member -> {
            if (member == student) {
                leader = member;
                notifyObservers(2);
            }
        });
        if (leader == null)
            System.out.print("It is not one of us.\n");
    }

    public void appendMember(Student student){
        members.add(student);
        notifyObservers(1);

    }

    public Student getLeader(){
        return leader;
    }

    public List<Student> getMembers(){
        return members;
    }

    @Override
    public void addObserver(Observer o) {
//        super.addObserver(o);
        observerList.add(o);
    }

    @Override
    public void notifyObservers(Object arg) {
        observerList.forEach(observer -> {
            observer.update(this, arg);
        });
    }
}
