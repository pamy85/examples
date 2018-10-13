package wecc.examples.springboot.mvc.thymeleaf.model;

public class ExampleObject {

    private String name;
    private String surname;

    public ExampleObject(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String greets(){
        return String.format("Hi! My name is %s %s", name, surname);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

