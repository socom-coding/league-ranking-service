package za.co.span.assessment.fixtures.entity;

public class Team {
    private long id;
    private final String name;
    private final int score;
    private int points;
    private int position;

    public Team(long id, String name, int score, int points, int position) {
        this.id = id;
        this.name = name;
        this.score = score;
        this.points = points;
        this.position = position;
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

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
