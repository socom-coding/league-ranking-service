package za.co.span.assessment.fixtures.entity;

public class LeagueRanking {
    private final long id;
    private final String name;
    private final int points;
    private int position;

    public LeagueRanking(long id, String name, int points) {
        this.id = id;
        this.name = name;
        this.points = points;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}
