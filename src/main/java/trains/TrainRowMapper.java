package trains;

import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class TrainRowMapper implements RowMapper<Train> {
    @Override
    public Train mapRow(ResultSet rs, int rowNum) throws SQLException {
        long id = rs.getLong("id");
        String destination = rs.getString("destination");
        LocalDateTime departure=rs.getTimestamp("departure").toLocalDateTime();
        int maxCapacity = rs.getInt("max_capacity");
        int numberOfPassengers = rs.getInt("number_of_passengers");
        return new Train(id, destination, departure,maxCapacity,numberOfPassengers);
    }
}
