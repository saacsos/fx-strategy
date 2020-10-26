package gradebook.strategy;

import gradebook.models.Student;

public class ScoreGreaterThanFiftySearcher implements Searcher {
    @Override
    public boolean isMatch(Student student) {
        return student.getTotalScore() > 50;
    }
}
