package za.co.span.assessment.utils.mapper;

import com.google.common.base.CharMatcher;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;

@Component
public class MapStringToObject {

    public MatchResult mapResult(String string) {

        String team1 = string.split(",")[0].trim();
        String team2 = string.split(",")[1].trim();

        CharMatcher charMatcherDigit = CharMatcher.javaDigit();

        Team teamModel1 = new Team(team1.replaceAll("\\d", "").trim(), Integer.parseInt(charMatcherDigit.retainFrom(team1)));
        Team teamModel2 = new Team(team2.replaceAll("\\d", "").trim(), Integer.parseInt(charMatcherDigit.retainFrom(team2)));

        MatchResult matchResult = new MatchResult();
        matchResult.getTeams().add(teamModel1);
        matchResult.getTeams().add(teamModel2);

        return matchResult;
    }
}
