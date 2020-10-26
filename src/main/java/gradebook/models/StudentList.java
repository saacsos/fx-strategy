package gradebook.models;

import gradebook.strategy.Searcher;

import java.util.ArrayList;

public class StudentList {
    private ArrayList<Student> students;

    public StudentList() {
        students = new ArrayList<>();
    }

    public StudentList(ArrayList<Student> students) {
        this.students = students;
    }

    public void add(Student student) {
        students.add(student);
    }

    public Student findById(String id) {
        for (Student s : students) {
            if (s.getId().equals(id)) {
                return s;
            }
        }
        throw new RuntimeException("Student with id " + id + " not found");
    }

    public double getStudentScore(String id, ScoreType type) {
        Student student = findById(id);
        return student.getScore().get(type);
    }

    public double getStudentTotalScore(String id) {
        Student student = findById(id);
        return student.getTotalScore();
    }

    public ArrayList<Student> toList() {
        return students;
    }

    public ArrayList<Student> search(Searcher searcher) {
        ArrayList<Student> newList = new ArrayList<>();
        for (Student student: students) {
            if (searcher.isMatch(student)) {
                newList.add(student);
            }
        }
        return newList;
    }

    public int count() {
        return students.size();
    }
}
