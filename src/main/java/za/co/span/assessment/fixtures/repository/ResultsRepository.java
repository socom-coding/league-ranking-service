package za.co.span.assessment.fixtures.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.entity.LeagueRanking;
import za.co.span.assessment.fixtures.entity.MatchResult;
import za.co.span.assessment.fixtures.entity.Team;
import za.co.span.assessment.fixtures.repository.rowmapper.LeagueRankingModelRowMapper;

import java.util.List;

@Repository
public class ResultsRepository {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ResultsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int insertResult(MatchResult matchResult) {
        return jdbcTemplate.update(
                "insert into fixtures ( team_1_name, team_1_score, team_2_name, team_2_score) " + "values(?, ?, ?, ?)",
                new Object[]{matchResult.getTeams().get(0).getName(), matchResult.getTeams().get(0).getScore(),
                        matchResult.getTeams().get(1).getName(), matchResult.getTeams().get(1).getScore()});
    }

    public int insertFixtures(MatchResult matchResult) {
        return jdbcTemplate.update(
                "insert into points ( team_1_name, team_1_points, team_2_name, team_2_points) " + "values(?, ?, ?, ?)",
                new Object[]{matchResult.getTeams().get(0).getName(), matchResult.getTeams().get(0).getPoints(),
                        matchResult.getTeams().get(1).getName(), matchResult.getTeams().get(1).getPoints()});
    }

    public List<LeagueRanking> findTeam(String team) {

        try {
            return jdbcTemplate.query("select * from ranking where team=" + "\'" + team + "\'", new LeagueRankingModelRowMapper());
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return null;

    }

    public int insertPoints(Team team) {
        return jdbcTemplate.update(
                "insert into ranking (team, points) " + "values(?, ?)",
                new Object[]{team.getName(), team.getPoints()});
    }

    public int updatePoints(Team team) {
        return jdbcTemplate.update("update ranking set points =" + "\'" + team.getPoints() + "\'" + "where id =" + "\'" + team.getId() + "\'");
    }

    public List<LeagueRanking> findAll() {
        return jdbcTemplate.query("select * from ranking", new LeagueRankingModelRowMapper());
    }
}
