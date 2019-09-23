package practice07;

public class Teacher extends Person{
    private Klass klass;
    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, Klass klass){
        super(name,age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        if (getKlass() != null)
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach " + getKlass().getDisplayName() +".";
        else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach No Class.";
    }

    public Klass getKlass() {
        return klass;
    }

    public String introduceWith(Student student){
        if (getKlass().equals(student.getKlass()))
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach " + student.getName() + ".";
        else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I don't teach " + student.getName() + "." ;
    }
}
