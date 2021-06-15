package za.co.span.assessment.fixtures.entity;

public class Team {
    private long id;
    private final String name;
    private final int score;
    private int points;

    public Team(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
