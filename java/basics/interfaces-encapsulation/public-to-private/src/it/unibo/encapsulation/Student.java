package it.unibo.encapsulation;

public class Student {

    private final String name;
    private final String surname;
    private final int id;
    private final int matriculationYear;

    public Student(final int id, final String name, final String surname, final int matriculationYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.matriculationYear = matriculationYear;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public int getId() {
        return id;
    }

    public int getMatriculationYear() {
        return matriculationYear;
    }

    public void printStudentInfo() {
        IO.println("Student id: " + this.id);
        IO.println("Student name: " + this.name);
        IO.println("Student surname: " + this.surname);
        IO.println("Student matriculationYear: " + this.matriculationYear + "\n");
    }
}
