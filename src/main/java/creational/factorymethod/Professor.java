package creational.factorymethod;

public class Professor extends Person {

    Professor(String name) {
        super(name);
    }

    @Override
    public String presentPerson() {
        return "My name is " + name + " and I am a professor";
    }
}
