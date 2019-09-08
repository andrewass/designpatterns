package creational;

import creational.builder.Person;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuilderTest {

    @Test
    void shouldCreatePersonUsingBuilder() {
        Person firstPerson = new Person.Builder()
                .withAge(55)
                .withCountry("Norway")
                .build();

        Person secondPerson = new Person.Builder()
                .withName("James")
                .withDateOfBirth(LocalDate.of(1980, Month.MARCH, 16))
                .withOccupation("Doctor")
                .build();

        assertEquals(55, firstPerson.getAge());
        assertEquals("Norway", firstPerson.getCountry());

        assertEquals("James", secondPerson.getName());
        assertEquals(LocalDate.of(1980, Month.MARCH, 16), secondPerson.getDateOfBirth());
        assertEquals("Doctor", secondPerson.getOccupation());
    }

    @Test
    void shouldBeAbleToModifyPersonObject(){
        Person person = new Person.Builder()
                .withAge(55)
                .withCountry("Norway")
                .build();

        person.setAge(person.getAge()+1);
        person.setCountry("Sweden");

        assertEquals(56, person.getAge());
        assertEquals("Sweden", person.getCountry());
    }
}