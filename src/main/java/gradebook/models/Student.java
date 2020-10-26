package gradebook.models;

public class Student {
    private String id;
    private String name;
    private Score score;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        score = new Score();
    }

    public Student(String id, String name, double assignment, double attendance, double midtermExam, double finalExam) {
        this(id, name);
        this.updateAllScore(assignment, attendance, midtermExam, finalExam);
    }

    public void addScore(ScoreType type, double score) {
        this.score.add(type, score);
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public Score getScore() {
        return score;
    }

    public double getTotalScore() {
        return score.totolScore();
    }

    public void updateAllScore(double assignment, double attendance, double midtermExam, double finalExam) {
        score.set(ScoreType.ASSIGNMENT, assignment);
        score.set(ScoreType.ATTENDANCE, attendance);
        score.set(ScoreType.MIDTERM_EXAM, midtermExam);
        score.set(ScoreType.FINAL_EXAM, finalExam);
    }

    @Override
    public String toString() {
        return id + ": " + String.format("[%.2f]", score.totolScore()) + " | " + name;
    }
}
