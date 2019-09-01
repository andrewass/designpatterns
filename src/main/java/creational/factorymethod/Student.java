package creational.factorymethod;

public class Student extends Person {

    Student(String name) {
        super(name);
    }

    @Override
    public String presentPerson() {
        return "My name is " + name + " and I am a student";
    }
}
