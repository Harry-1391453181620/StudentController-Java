package model;

import java.util.ArrayList;
import java.util.Arrays;

public class Student {
    private String name;
    private int age;
    private int studentID;
    private static int nextId = 0;
    private double[] GPA;
    private static ArrayList<Student> students = new ArrayList<>();

    public Student(String name, int age, double[] GPA) {
        this.name = name;
        this.age = age;
        this.GPA = GPA == null ? new double[]{} : GPA;
        this.studentID = ++nextId;
    }

    public Student() {
        this("Unknown", 0, new double[]{});
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public int getStudentID() { return studentID; }
    public double[] getGPA() { return GPA; }

    public void storeStudent() {
        students.add(this);
    }

    public static Student getStudent(int id) {
        for (Student s : students) {
            if (s.studentID == id) return s;
        }
        return null;
    }

    public static ArrayList<Student> getAllStudents() {
        return students;
    }

    public static void removeStudent(Student s) {
        students.remove(s);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentID +
                ", Name: " + name +
                ", Age: " + age +
                ", GPA: " + Arrays.toString(GPA);
    }
}
