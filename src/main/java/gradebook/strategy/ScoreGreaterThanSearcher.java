package gradebook.strategy;

import gradebook.models.Student;

public class ScoreGreaterThanSearcher implements Searcher {
    private double threshold = 0;

    public void setThreshold(double threshold) {
        this.threshold = threshold;
    }


    @Override
    public boolean isMatch(Student student) {
        return student.getTotalScore() > threshold;
    }
}
