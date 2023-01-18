package com.challenge.demo.utils;

import com.challenge.demo.model.Sector;
import com.challenge.demo.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper implements RowMapper<List<String>> {
    @Override
    public List<String> mapRow(ResultSet resultSet, int i) throws SQLException {
        List<String> result = new ArrayList<>();
        result.add(resultSet.getString("name"));
        result.add(resultSet.getString("sector"));
        return result;
    }
}
