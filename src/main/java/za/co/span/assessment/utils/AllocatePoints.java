package za.co.span.assessment.utils;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.entity.MatchResult;

@Component
public class AllocatePoints {

    @Value("${league.points.win}")
    private String win;

    @Value("${league.points.loose}")
    private String loose;

    @Value("${league.points.draw}")
    private String draw;

    public void determinePoints(MatchResult matchResult) {

        if (matchResult.getTeams().get(0).getScore() == matchResult.getTeams().get(1).getScore()) {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(draw));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(draw));
        } else if (matchResult.getTeams().get(0).getScore() > matchResult.getTeams().get(1).getScore()) {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(win));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(loose));
        } else {
            matchResult.getTeams().get(0).setPoints(Integer.parseInt(loose));
            matchResult.getTeams().get(1).setPoints(Integer.parseInt(win));
        }
    }

    public void updateTeamPoints() {

    }
}
