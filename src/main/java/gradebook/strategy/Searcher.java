package gradebook.strategy;

import gradebook.models.Student;

public interface Searcher {
    boolean isMatch(Student student);
}
