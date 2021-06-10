package za.co.span.assessment.utils;

import com.google.common.base.CharMatcher;
import za.co.span.assessment.fixtures.entity.MatchResult;

public class MapStringToObject {
    public MatchResult mapResult(String string){

        String team1 = string.split(",")[0].trim();
        String team2 = string.split(",")[1].trim();

        CharMatcher charMatcherLetter = CharMatcher.javaLetter();
        CharMatcher charMatcherDigit = CharMatcher.javaDigit();

        MatchResult matchResult = new MatchResult();
        matchResult.setTeam1Name(charMatcherLetter.retainFrom(team1));
        matchResult.setTeam1Score(charMatcherDigit.retainFrom(team1));
        matchResult.setTeam2Name(charMatcherLetter.retainFrom(team2));
        matchResult.setTeam2Score(charMatcherDigit.retainFrom(team2));

        return matchResult;
    }
}
