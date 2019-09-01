package creational.factorymethod;


public abstract class Person {

    String name;

    Person(String name) {
        this.name = name;
    }

    /**
     * Get a presentation of the person
     *
     * @return a String representing the person
     */
    public abstract String presentPerson();
}
