package creational.factorymethod;

public class Doctor extends Person {

    Doctor(String name) {
        super(name);
    }

    @Override
    public String presentPerson() {
        return "My name is " + name + " and I am a doctor";
    }
}
