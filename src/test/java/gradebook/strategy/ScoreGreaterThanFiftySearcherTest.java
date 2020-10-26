package gradebook.strategy;

import gradebook.models.Student;
import gradebook.models.StudentList;
import gradebook.services.StudentDataSource;
import gradebook.services.StudentHardcodeDataSource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ScoreGreaterThanFiftySearcherTest {
    private Searcher searcher;
    private StudentList studentList;

    @BeforeEach
    void setupEach() {
        // test fixture
        searcher = new ScoreGreaterThanFiftySearcher();
        StudentDataSource dataSource = new StudentHardcodeDataSource();
        studentList = dataSource.getStudentsData();
    }

    @Test
    @DisplayName("ค้นหานักเรียนที่มีคะแนนมากกว่า 50 คะแนน")
    void search_case1() {
        StudentList searchedList = new StudentList(studentList.search(searcher));
        assertEquals(6, searchedList.count());
        for (Student student: searchedList.toList()) {
            assertTrue(student.getTotalScore() > 50);
        }
    }
}