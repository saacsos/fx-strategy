package gradebook.services;

import gradebook.models.Student;
import gradebook.models.StudentList;

public class StudentHardcodeDataSource implements StudentDataSource {

    @Override
    public StudentList getStudentsData() {
        StudentList students = new StudentList();
        students.add(new Student("6210400001", "Poirot", 5, 10, 15, 24));
        students.add(new Student("6210400020", "Marple", 7, 9, 18, 21.2));
        students.add(new Student("6210400300", "Maigret", 3, 10, 8.1, 16.6));
        students.add(new Student("6210404000", "Morgan", 8, 8.5, 19.7, 21.2));
        students.add(new Student("6210450000", "Peter", 10, 10, 25, 25));
        students.add(new Student("6210400006", "Mori", 0, 10, 15, 20));
        students.add(new Student("6210400070", "Morales", 9, 7.4, 25, 17));
        students.add(new Student("6210400800", "Peat", 2, 3, 5, 2.5));
        students.add(new Student("6210409000", "Mope", 10, 10, 25, 25));
        students.add(new Student("6210400101", "Romape", 5, 6.7, 11.4, 22));
        students.add(new Student("6210401100", "Inter", 1, 4.5, 13.6, 14));

        return students;
    }

    @Override
    public void setStudentsData(StudentList students) {
        // do nothing
    }
}