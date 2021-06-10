package za.co.span.assessment.fixtures.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.repository.rowmapper.LeagueRankingModelRowMapper;

import java.util.List;

@Repository
public class ResultsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public int insert(MatchResult matchResult) {
        return jdbcTemplate.update(
                "insert into Match_Results ( team_1_name, team_1_score, team_2_name, team_2_score) " + "values(?, ?, ?, ?)",
                new Object[]{matchResult.getTeam1Name(), matchResult.getTeam1Score(), matchResult.getTeam2Name(), matchResult.getTeam2Score()});
    }

    public List<LeagueRanking> findAll() {
        return jdbcTemplate.query("select * from Team_Points", new LeagueRankingModelRowMapper());
    }
}
