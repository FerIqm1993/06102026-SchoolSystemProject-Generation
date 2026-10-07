package org.generation.entidades;

import java.util.ArrayList;
import java.util.List;

public class Course {
    // Definir atributos del curso
    public String courseName;
    public String professorName;
    public int year;
    // Colección de estudiantes inscritos
    public List<Student> students;

    // Constructor del curso
    public Course(String courseName, String professorName, int year) {
        this.courseName = courseName;
        this.professorName = professorName;
        this.year = year;
        this.students = new ArrayList<>(); // Inicializar la lista de estudiantes
    }

    // Método para inscribir un estudiante
    public void enroll(Student student) {
        // Agregar estudiante a la colección
        this.students.add(student);
    }

    // Sobrecarga de método: inscribir un arreglo de estudiantes
    public void enroll(Student[] students) {
        // Agregar todos los estudiantes del arreglo a la colección
        for (Student student : students) {
            this.enroll(student);
        }
    }

    // Método para dar de baja un estudiante
    public void unEnroll(Student student) {
        // Remover el estudiante de la colección
        // Verificar si el estudiante realmente está en la lista usando contains
        if (this.students.contains(student)) {
            this.students.remove(student);
        }
    }

    // Método para contar los estudiantes inscritos
    public int countStudents() {
        // Retornar el tamaño de la lista de estudiantes
        return this.students.size();
    }
    
    // Método para encontrar la mejor calificación
    public int bestGrade() {
        // Buscar la calificación más alta entre los estudiantes inscritos
        int best = 0;
        for (Student student : this.students) {
            if (student.grade > best) {
                best = student.grade;
            }
        }
        return best;
    }

    // --- Desafíos ---

    // Función que calcula la calificación promedio del curso
    public double calculateAverageGrade() {
        if (this.students.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Student student : this.students) {
            sum += student.grade;
        }
        return (double) sum / this.students.size();
    }

    // Función que imprime un ranking con todos los estudiantes y sus calificaciones
    public void printRanking() {
        System.out.println("Ranking de calificaciones para el curso " + this.courseName + ":");
        // Crear una copia para no alterar la lista original al ordenar
        List<Student> ranking = new ArrayList<>(this.students);
        ranking.sort((s1, s2) -> Integer.compare(s2.grade, s1.grade));
        
        for (int i = 0; i < ranking.size(); i++) {
            Student s = ranking.get(i);
            System.out.println((i + 1) + ". " + s.firstName + " " + s.lastName + " - Calificación: " + s.grade);
        }
    }

    // Función que muestra si cada estudiante está por encima del promedio del curso o no
    public void showAboveAverage() {
        double average = this.calculateAverageGrade();
        System.out.println("Promedio del curso: " + average);
        System.out.println("Alumnos por encima del promedio:");
        for (Student student : this.students) {
            boolean isAbove = student.grade > average;
            System.out.println("- " + student.firstName + " " + student.lastName + ": " + (isAbove ? "Sí" : "No"));
        }
    }
}
