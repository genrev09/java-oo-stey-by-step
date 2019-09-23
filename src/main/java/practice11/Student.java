package practice11;

public class Student extends Person{
    private Klass klass;
    public Student(int id, String name, int age) {
        super(id, name, age);
    }

    public Student(int id, String name, int age, Klass klass){
        super(id,name,age);
        this.klass = klass;
    }

    @Override
    public String introduce(){
        if (klass.getLeader() == null)
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Student. I am at " + getKlass().getDisplayName() + ".";
        else
            return "My name is " + getName() + ". I am " + getAge() + " years old. I am a Student. I am Leader of " + getKlass().getDisplayName() + ".";
    }

    public Klass getKlass() {
        return klass;
    }

    public boolean isIn(Klass klass){
        return klass.getMembers().contains(this);
    }
}
