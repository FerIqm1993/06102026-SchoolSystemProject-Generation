package org.generation.entidades;

public class Student {
    // Definir atributos
    public String firstName;
    public String lastName;
    public int registration;
    public int grade;
    public int year;

    // Constructor 1: Con todos los atributos
    public Student(String firstName, String lastName, int registration, int grade, int year) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = grade;
        this.year = year;
    }

    // Constructor 2: Sin calificación ni año (con valores por defecto)
    public Student(String firstName, String lastName, int registration) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = registration;
        this.grade = 0; // Valor por defecto
        this.year = 1;  // Año 1 por defecto
    }

    // Constructor 3: Solo nombre y apellido
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.registration = 0;
        this.grade = 0;
        this.year = 1;
    }

    // Método para imprimir el nombre completo
    public void printFullName() {
        // Imprimir el nombre y apellido del estudiante
        System.out.println(this.firstName + " " + this.lastName);
    }

    // Método para saber si está aprobado (se cambió void a boolean para poder retornar)
    public boolean isApproved() {
        // Retornar verdadero si la calificación es mayor o igual a 60
        return this.grade >= 60;
    }

    // Método para cambiar el año si está aprobado
    public int changeYearIfApproved() {
        // Si el estudiante está aprobado, avanzarlo al siguiente año
        if (this.isApproved()) {
            this.year = this.year + 1;
            // Imprimir felicitaciones si el estudiante fue aprobado
            System.out.println("Congratulations!");
        }
        return 0;
    }
}
