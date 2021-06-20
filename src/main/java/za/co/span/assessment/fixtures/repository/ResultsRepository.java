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

    public int insertResult(List<TeamDAO> teamDAO) {
        try {
            return jdbcTemplate.update(
                    "insert into fixtures ( team_1_name, team_1_score, team_2_name, team_2_score) " + "values(?, ?, ?, ?)",
                    teamDAO.get(0).getName(), teamDAO.get(0).getScore(),
                    teamDAO.get(1).getName(), teamDAO.get(1).getScore());
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return 0;
    }

    public int insertFixtures(List<TeamDAO> teamDAO) {
        try {
            return jdbcTemplate.update(
                    "insert into points ( team_1_name, team_1_points, team_2_name, team_2_points) " + "values(?, ?, ?, ?)",
                    teamDAO.get(0).getName(), teamDAO.get(0).getPoints(),
                    teamDAO.get(1).getName(), teamDAO.get(1).getPoints());
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return 0;
    }

    public List<TeamDAO> findTeam(String team) {

        try {
            return jdbcTemplate.query("select * from ranking where team=" + "\'" + team + "\'", new TeamDAORowMapper());
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return null;
    }

    public int insertPoints(TeamDAO team) {
        try {
            return jdbcTemplate.update(
                    "insert into ranking (team, points) " + "values(?, ?)",
                    team.getName(), team.getPoints());
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return 0;
    }

    public int updatePoints(TeamDAO team) {
        try {
            return jdbcTemplate.update(
                    "update ranking set points =" + "\'" + team.getPoints() + "\'" + "where id =" + "\'" + team.getId() + "\'");
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return 0;
    }

    public List<TeamDAO> findAll() {
        try {
            return jdbcTemplate.query(
                    "select * from ranking", new TeamDAORowMapper());
        } catch (Exception e) {
            log.error("Exception occurred in class {}", this.getClass());
            log.error(String.valueOf(e));
        }
        return null;
    }
}
