package za.co.span.assessment.fixtures.repository.rowmapper;

import org.springframework.jdbc.core.RowMapper;
import za.co.span.assessment.fixtures.dao.TeamDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TeamDAORowMapper implements RowMapper {
    @Override
    public TeamDAO mapRow(ResultSet rs, int rowNum) throws SQLException {
        TeamDAO teamDAO = new TeamDAO(rs.getInt("id"), rs.getString("team"),
                0, Integer.parseInt(rs.getString("points")), 0);
        return teamDAO;
    }
}
