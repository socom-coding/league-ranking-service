package za.co.span.assessment.fixtures.service;

import za.co.span.assessment.fixtures.entity.LeagueRanking;

import java.util.List;

public interface DefaultFixturesService {
    void processResult(String matchResult);

    List<LeagueRanking> findAll();
}
