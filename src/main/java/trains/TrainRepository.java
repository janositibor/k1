package trains;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class TrainRepository {
    private JdbcTemplate jdbcTemplate;

    public TrainRepository(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }
    public long insertTrain(String destination, LocalDateTime departure, int maxCapacity) {
        KeyHolder keyHolder = new GeneratedKeyHolder();

        jdbcTemplate.update(new PreparedStatementCreator() {
                                @Override
                                public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                                    PreparedStatement ps =
                                            connection.prepareStatement("insert into trains(destination, departure, max_capacity, number_of_passengers) values (?,?,?,0)",
                                                    Statement.RETURN_GENERATED_KEYS);
                                    ps.setString(1, destination);
                                    ps.setTimestamp(2, Timestamp.valueOf(departure));
                                    ps.setInt(3, maxCapacity);
                                    return ps;
                                }
                            }, keyHolder
        );

        return keyHolder.getKey().longValue();
    }
    public Train findById(long id){
        List<Train> trains=jdbcTemplate.query("select id, destination, departure, max_capacity, number_of_passengers from trains where id=?"
                , new TrainRowMapper()
                ,id);
        if(trains.size()<1){
            throw new IllegalStateException(" No Train foind eith this id: "+id);
        }
        return trains.get(0);
    }

    public List<Train> getTrainsByDestination(String destination) {
        return jdbcTemplate.query("select id, destination, departure, max_capacity, number_of_passengers from trains where destination=? ORDER BY departure"
                , new TrainRowMapper()
                ,destination);
    }

    public void updateNumberOfPassengersById(long id, int amount){
        String sql = "UPDATE trains SET number_of_passengers = number_of_passengers+?, departure=departure  WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, amount, id);
    }
}
