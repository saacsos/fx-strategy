package gradebook.services;

import gradebook.models.StudentList;

public interface StudentDataSource {
    StudentList getStudentsData();

    void setStudentsData(StudentList students);
}