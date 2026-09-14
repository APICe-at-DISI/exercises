package it.unibo.constructors;

class Student {

    final String name;
    final String surname;
    final int id;
    final int matriculationYear;

    Student(final int id, final String name, final String surname, final int matriculationYear) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        IO.println("Student id: " + this.id);
        IO.println("Student name: " + this.name);
        IO.println("Student surname: " + this.surname);
        IO.println("Student matriculationYear: " + this.matriculationYear + "\n");
    }
}
