package za.co.span.assessment.utils.points;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.repository.ResultsRepository;

@Component
public class AllocateMatchPoints {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private ResultsRepository resultsRepository;

    @Value("${league.points.win}")
    private String win;

    @Value("${league.points.loose}")
    private String loose;

    @Value("${league.points.draw}")
    private String draw;

    public AllocateMatchPoints(ResultsRepository resultsRepository) {
        this.resultsRepository = resultsRepository;
    }

    public void applyRules(MatchResult matchResult) {

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
}
