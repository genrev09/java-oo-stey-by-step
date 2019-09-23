package practice10;

import java.util.LinkedList;

public class Teacher extends  Person{
    private Klass klass;
    private LinkedList<Klass> classList;

    public Teacher(int id, String name, int age) {
        super(id, name, age);
    }

    public Teacher(int id, String name, int age, Klass klass){
        super(id,name,age);
        this.klass = klass;
    }
    public Teacher(int id, String name, int age, LinkedList<Klass> classList){
        super(id,name,age);
        this.classList = classList;
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
}
