package gradebook.models;

import java.util.HashMap;
import java.util.Map;

public class Score {
    private Map<ScoreType, Double> scores;

    public Score() {
        scores = new HashMap<>();
        for (ScoreType type : ScoreType.values()) {
            scores.put(type, 0.0);
        }
    }

    public double totolScore() {
        double total = 0;
        for (ScoreType type : ScoreType.values()) {
            total += scores.get(type);
        }
        return total;
    }

    public void add(ScoreType type, double score) {
        double current = get(type);
        if (score > 0) {
            current += score;
        }
        scores.put(type, current);
    }

    public void set(ScoreType type, double score) {
        scores.put(type, score);
    }

    public double get(ScoreType type) {
        return scores.get(type);
    }
}