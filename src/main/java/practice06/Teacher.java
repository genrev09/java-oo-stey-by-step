package practice06;

public class Teacher extends Person{
    private int klass;
    public Teacher(String name, int age) {
        super(name, age);
    }

    public Teacher(String name, int age, int klass){
        super(name,age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        if (getKlass()!=0)
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach Class " + getKlass() +".";
        else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Teacher. I teach No Class.";
    }

    public int getKlass() {
        return klass;
    }
}
