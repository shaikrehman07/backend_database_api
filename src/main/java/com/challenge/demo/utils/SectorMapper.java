package com.challenge.demo.utils;

import com.challenge.demo.model.Sector;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SectorMapper implements RowMapper<Sector> {
    @Override
    public Sector mapRow(ResultSet resultSet, int i) throws SQLException {
        Sector result = new Sector();
        result.setId(resultSet.getInt("id"));
        result.setValue(resultSet.getString("name"));
        return result;
    }
}
