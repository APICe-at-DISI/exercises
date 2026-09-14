class Student {

    // È buona pratica mettere i campi in testa alla classe
    int id;
    String name;
    String surname;
    int matriculationYear;

    void build(String name, String surname, int id, int matriculationYear) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.matriculationYear = matriculationYear;
    }

    void printStudentInfo() {
        IO.println("Student name: " + name);
        IO.println("Student surname: " + surname);
        IO.println("Student id: " + id);
        IO.println("Student matriculationYear: " + matriculationYear);
    }
}
