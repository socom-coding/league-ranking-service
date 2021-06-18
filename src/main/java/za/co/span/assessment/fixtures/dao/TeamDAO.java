package za.co.span.assessment.fixtures.dao;

public class TeamDAO {
    private long id;
    private String name;
    private int score;
    private int points;
    private int position;

    public TeamDAO(long id, String name, int score, int points, int position) {
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

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
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
