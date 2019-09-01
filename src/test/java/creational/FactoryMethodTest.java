package creational;

import creational.factorymethod.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactoryMethodTest {

    @Test
    void shouldInstantiateObjectOfCorrectSubclass() {
        Person doctor = PersonFactory.createPerson("Phil", "Doctor");
        Person professor = PersonFactory.createPerson("James", "Professor");
        Person student = PersonFactory.createPerson("Anne", "Student");
        Person undefined = PersonFactory.createPerson("John", "Unknown");

        assertTrue(doctor instanceof Doctor);
        assertTrue(professor instanceof Professor);
        assertTrue(student instanceof Student);
        assertNull(undefined);

        assertEquals("My name is Phil and I am a doctor", doctor.presentPerson());
        assertEquals("My name is James and I am a professor", professor.presentPerson());
        assertEquals("My name is Anne and I am a student", student.presentPerson());
    }
}
