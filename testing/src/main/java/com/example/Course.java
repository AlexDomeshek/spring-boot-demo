package com.example;

/**
 * Created by alex on 1/22/18.
 */
public class Course {
    String name;
    String lecturer;

    public String getName() {
        return name;
    }

    public String getLecturer() {
        return lecturer;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLecturer(String lecturer) {
        this.lecturer = lecturer;
    }

    public Course() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        if (name != null ? !name.equals(course.name) : course.name != null) return false;
        if (lecturer != null ? !lecturer.equals(course.lecturer) : course.lecturer != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (lecturer != null ? lecturer.hashCode() : 0);
        return result;
    }

    public Course(String name, String lecturer) {
        this.name = name;
        this.lecturer = lecturer;
    }
}