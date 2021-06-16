package za.co.span.assessment.utils.mapper;

import com.google.common.base.CharMatcher;
import org.springframework.stereotype.Component;
import za.co.span.assessment.fixtures.pojo.Team;

import java.util.ArrayList;
import java.util.List;

@Component
public class MapStringToObject {

    public List<Team> mapResult(String string) {

        String team1 = string.split(",")[0].trim();
        String team2 = string.split(",")[1].trim();

        CharMatcher charMatcherDigit = CharMatcher.javaDigit();

        Team teamModel1 = new Team(0, team1.replaceAll("\\d", "").trim(), Integer.parseInt(charMatcherDigit.retainFrom(team1)), 0, 0);
        Team teamModel2 = new Team(0, team2.replaceAll("\\d", "").trim(), Integer.parseInt(charMatcherDigit.retainFrom(team2)), 0, 0);

        List<Team> teamList = new ArrayList<>();
        teamList.add(teamModel1);
        teamList.add(teamModel2);

        return teamList;
    }
}
