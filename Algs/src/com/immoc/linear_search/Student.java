package com.immoc.linear_search;

import java.util.Objects;

/**
 * @author pachi
 */
public class Student {
    private String name;

    public Student(String name) {
        this.name = name;
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

}
