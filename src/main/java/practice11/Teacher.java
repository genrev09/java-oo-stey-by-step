package practice11;

import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

public class Teacher extends Person implements Observer {
    private Klass klass;
    private LinkedList<Klass> classList;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass){
        super(id,name,age);
        this.klass = klass;
        klass.addObserver(this);
    }
    public Teacher(int id, String name, int age, LinkedList<Klass> classList){
        super(id,name,age);
        this.classList = classList;
        classList.forEach(klass1 -> klass1.addObserver(this));
    }

    @Override
    public String introduce(){
        if (getClasses() != null) {
            StringBuilder classListString = new StringBuilder("");
            classList.forEach(klass -> {
                if (classListString.length() == 0)
                    classListString.append(klass.getNumber());
                else
                    classListString.append(", " + klass.getNumber());
            });
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach Class " + classListString + ".";
        } else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach No Class.";
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduceWith(Student student){
        if (isTeaching(student))
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + "." ;
    }

    public LinkedList<Klass> getClasses(){
        return classList;
    }

    public boolean isTeaching(Student student){
        return classList.contains(student.getKlass());
    }

    @Override
    public void update(Observable o, Object arg) {
        int indicator = (int) arg;
        Klass klass = (Klass) o;
        Student leader = klass.getLeader();

        if (klass == this.klass || classList.contains(klass)){
            if (indicator == 1){
                klass.getMembers().forEach(student -> {
                    System.out.print("I am " + getName() + ". I know " + student.getName() + " has joined " + klass.getDisplayName() + ".\n");
                });
            } else if(indicator == 2){
                System.out.print("I am " + getName() + ". I know " + leader.getName() + " become Leader of " + klass.getDisplayName() + ".\n");
            }
        }
    }

//        if (arg instanceof Klass){
//            Klass klass = (Klass) arg;
//            if (this.)
//            klass.getMembers().forEach(student -> {
//                getClasses().forEach(klass1 -> {
//                    if (student.getKlass() == klass1)
//                        System.out.print("I am " + getName() + ". I know " + student.getName() + " has joined " + klass1.getDisplayName() + ".\n");
//                    else if(student.getKlass() == this.klass)
//                        System.out.print("I am " + getName() + ". I know " + student.getName() + " has joined " + klass.getDisplayName() + ".\n");
//                });
//            });
//        } else if(arg instanceof Student){
//            Student leader = (Student) arg;
//            if (leader.getKlass() == this.klass)
//                System.out.print("I am " + getName() + ". I know " + leader.getName() + " become Leader of " + klass.getDisplayName() + ".\n");
//            else{
//                classList.forEach(klass1 -> {
//                    if (klass1 == leader.getKlass())
//                        System.out.print("I am " + getName() + ". I know " + leader.getName() + " become Leader of " + klass1.getDisplayName() + ".\n");
//                });
//            }
//        }
//    }

//    @Override
//    public void update(Klass klass, Indicator indicator) {
//        Student leader = klass.getLeader();
//        if (indicator.equals(Indicator.MEMBER)){
//            klass.getMembers().forEach(student -> {
//                getClasses().forEach(klass1 -> {
//                    if (student.getKlass() == klass1)
//                        System.out.print("I am " + getName() + ". I know " + student.getName() + " has joined " + klass1.getDisplayName() + ".\n");
//                    else if(student.getKlass() == this.klass)
//                        System.out.print("I am " + getName() + ". I know " + student.getName() + " has joined " + klass.getDisplayName() + ".\n");
//                });
//            });
//        } else if(indicator.equals(Indicator.LEADER)){
//            if (leader.getKlass() == this.klass)
//                System.out.print("I am " + getName() + ". I know " + leader.getName() + " become Leader of " + klass.getDisplayName() + ".\n");
//            else{
//                classList.forEach(klass1 -> {
//                    if (klass1 == leader.getKlass())
//                        System.out.print("I am " + getName() + ". I know " + leader.getName() + " become Leader of " + klass1.getDisplayName() + ".\n");
//                });
//            }
//        }
//    }

//

}
