package com.immoc.linear_search;

/**
 * @author pachi
 */
public class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public boolean equals(Object student) {

        if (this == student) {
            return true;
        }

        if (student == null) {
            return false;
        }

        if (this.getClass() != student.getClass()) {
            return false;
        }

        Student other = (Student) student;
        return this.name.equals(other.name);
    }

    @Override
    public int compareTo(Student student) {

//        if (this.score < student.score) {
//            return -1;
//        } else if (this.score == student.score) {
//            return 0;
//        }
//        return 1;
        return this.score - student.score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }
}
