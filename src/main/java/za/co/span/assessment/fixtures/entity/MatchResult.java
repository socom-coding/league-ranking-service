package za.co.span.assessment.fixtures.entity;

import java.util.ArrayList;
import java.util.List;

public class MatchResult {

    private List<Team> teams = new ArrayList<>();

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
