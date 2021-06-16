package za.co.span.assessment.fixtures.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.span.assessment.fixtures.entity.Team;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LeagueRankingModelRowMapper implements RowMapper {
    @Override
    public Team mapRow(ResultSet rs, int rowNum) throws SQLException {
        Team leagueRanking = new Team(rs.getInt("id"), rs.getString("team"),
                0, Integer.parseInt(rs.getString("points")), 0);
        return leagueRanking;
    }
}
