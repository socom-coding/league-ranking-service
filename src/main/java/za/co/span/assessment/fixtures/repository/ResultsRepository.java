package za.co.span.assessment.fixtures.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import za.co.span.assessment.fixtures.controller.DefaultFixturesController;
import za.co.span.assessment.fixtures.dao.TeamDAO;
import za.co.span.assessment.fixtures.repository.rowmapper.TeamDAORowMapper;

import java.util.List;

@Repository
public class ResultsRepository {

    private static final Logger log = LoggerFactory.getLogger(DefaultFixturesController.class);

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public ResultsRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    //TODO: Exception handling and clean up

    public int insertResult(List<TeamDAO> teamDAO) {
        return jdbcTemplate.update(
                "insert into fixtures ( team_1_name, team_1_score, team_2_name, team_2_score) " + "values(?, ?, ?, ?)",
                new Object[]{teamDAO.get(0).getName(), teamDAO.get(0).getScore(),
                        teamDAO.get(1).getName(), teamDAO.get(1).getScore()});
    }

    public int insertFixtures(List<TeamDAO> teamDAO) {
        return jdbcTemplate.update(
                "insert into points ( team_1_name, team_1_points, team_2_name, team_2_points) " + "values(?, ?, ?, ?)",
                new Object[]{teamDAO.get(0).getName(), teamDAO.get(0).getPoints(),
                        teamDAO.get(1).getName(), teamDAO.get(1).getPoints()});
    }

    public List<TeamDAO> findTeam(String team) {

        try {
            return jdbcTemplate.query("select * from ranking where team=" + "\'" + team + "\'", new TeamDAORowMapper());
        } catch (Exception e) {
            log.error(String.valueOf(e));
        }
        return null;
    }

    public int insertPoints(TeamDAO team) {
        return jdbcTemplate.update(
                "insert into ranking (team, points) " + "values(?, ?)",
                new Object[]{team.getName(), team.getPoints()});
    }

    public int updatePoints(TeamDAO team) {
        return jdbcTemplate.update("update ranking set points =" + "\'" + team.getPoints() + "\'" + "where id =" + "\'" + team.getId() + "\'");
    }

    public List<TeamDAO> findAll() {
        return jdbcTemplate.query("select * from ranking", new TeamDAORowMapper());
    }
}
