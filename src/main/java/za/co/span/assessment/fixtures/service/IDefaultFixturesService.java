package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;

import java.util.List;

public interface IDefaultFixturesService {
    public int add(String matchResult);
    public List<LeagueRanking> findAll();
}
