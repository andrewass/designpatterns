package creational.builder;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Person {

    private Integer age;
    private String name;
    private String occupation;
    private String country;
    private LocalDate dateOfBirth;

    private Person(){}

    public static class Builder{

        private Person person;

        public Builder(){
            person = new Person();
        }

        public Builder withName(String name){
            this.person.name = name;
            return this;
        }

        public Builder withAge(int age){
            this.person.age = age;
            return this;
        }

        public Builder withOccupation(String occupation) {
            this.person.occupation = occupation;
            return this;
        }

        public Builder withCountry(String country){
            this.person.country = country;
            return this;
        }

        public Builder withDateOfBirth(LocalDate dateOfBirth){
            this.person.dateOfBirth = dateOfBirth;
            return this;
        }

        public Person build(){
            return this.person;
        }
    }
}
