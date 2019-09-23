package practice05;

public class Student extends Person{
    private int klass;
    public Student(String name, int age) {
        super(name, age);
    }

    public Student(String name, int age, int klass){
        super(name,age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Student. I am at Class " + getKlass() +".";
    }

    public int getKlass() {
        return klass;
    }
}
