package org.generation;

import org.generation.entidades.Course;
import org.generation.entidades.Student;

public class SchoolSystemApp {
    public static void main(String[] args) {
        // Instanciar objetos de prueba (Estudiantes) usando al menos 3 constructores diferentes
        Student student1 = new Student("Juan", "Pérez", 1001, 85, 1);
        Student student2 = new Student("Ana", "Gómez", 1002, 55, 1);
        Student student3 = new Student("Carlos", "López", 1003); // Usa constructor sin grade ni year
        Student student4 = new Student("María", "Rodríguez"); // Usa constructor solo con nombre y apellido
        
        // Vamos a establecer calificaciones para student3 y student4 para probar los desafíos
        student3.grade = 90;
        student4.grade = 70;

        // Imprimir nombres completos
        System.out.println("=== Nombres de Estudiantes ===");
        student1.printFullName();
        student2.printFullName();

        // Probar si están aprobados y cambiar el año
        System.out.println("\n=== Estado de Aprobación y Cambio de Año ===");
        student1.changeYearIfApproved();
        student2.changeYearIfApproved();
        
        System.out.println("Año actual de Juan: " + student1.year);
        System.out.println("Año actual de Ana: " + student2.year);

        // Instanciar un Curso
        Course javaCourse = new Course("Java", "Prof. Fernando Aguilar", 2026);
        
        // Inscribir estudiantes individualmente
        javaCourse.enroll(student1);
        javaCourse.enroll(student2);

        // Inscribir un arreglo de estudiantes (Sobrecarga del método enroll)
        Student[] moreStudents = {student3, student4};
        javaCourse.enroll(moreStudents);

        // Imprimir información del curso y probar métodos
        System.out.println("\n========== Detalles del Curso ==========");
        System.out.println("Curso: " + javaCourse.courseName);
        System.out.println("Total de estudiantes inscritos: " + javaCourse.countStudents());
        System.out.println("Mejor calificación: " + javaCourse.bestGrade());
        System.out.println("==========================================");

        // Dar de baja a un estudiante
        javaCourse.unEnroll(student4);
        System.out.println("\nTotal de estudiantes tras dar de baja a María: " + javaCourse.countStudents());

        // Probar los métodos del desafío
        System.out.println("\n========== Desafíos ==========");
        System.out.println("Promedio del curso: " + javaCourse.calculateAverageGrade());
        System.out.println("");
        javaCourse.printRanking();
        System.out.println("");
        javaCourse.showAboveAverage();
    }
}
