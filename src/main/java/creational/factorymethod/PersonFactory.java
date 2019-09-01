package creational.factorymethod;

/**
 * Factory class for creating Person-objects
 */
public class PersonFactory {

    /**
     * Instantiate a Person-object, based on occupation
     *
     * @param name       Name of the person
     * @param occupation Occupation of the person
     * @return an object of a subclass of Person
     */
    public static Person createPerson(String name, String occupation) {
        switch (occupation.toLowerCase()) {
            case "doctor":
                return new Doctor(name);
            case "professor":
                return new Professor(name);
            case "student":
                return new Student(name);
            default:
                return null;
        }
    }

}
