package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.util.List;

public interface IDefaultFixturesService {
    public void processResult(String matchResult);

    public List<LeagueRanking> findAll();
}
