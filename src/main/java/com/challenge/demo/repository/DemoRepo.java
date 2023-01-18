package com.challenge.demo.repository;

import com.challenge.demo.model.Sector;
import com.challenge.demo.model.User;
import com.challenge.demo.utils.SectorMapper;
import com.challenge.demo.utils.UserMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import java.util.ArrayList;
import java.util.List;
@Configuration
public class DemoRepo {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(new EmbeddedDatabaseBuilder()
            .setType(EmbeddedDatabaseType.H2)
            .addScript("classpath:jdbc/schema.sql")
            .addScript("classpath:jdbc/data.sql").build());

    private final String ALL_SECTOR_VALUES = "select * from sector";
    private final String INSERT_USER_DATA = "insert into userdata(name, sector) values(?,?)";
    private final String FIND_USER = "select ud.name, sec.name as sector from userdata as ud join sector as sec on sec.id = ud.sector where ud.name = ?";
    private final String UPDATE_USER = "update userdata set name = ?, sector = ? where name = ?";

    public List<String> getAllSectors() {
        List<String> result = new ArrayList<>();
        List<Sector> sectors = jdbcTemplate.query(ALL_SECTOR_VALUES, new SectorMapper());
        sectors.stream().forEach((obj)->result.add(obj.getValue()));
        return result;
    }

    public boolean insertUser(User user) {
        return jdbcTemplate.update(INSERT_USER_DATA, user.getName(), user.getSector()) > 0;
    }

    public List<String> getUser(String name){
        return jdbcTemplate.queryForObject(FIND_USER, new Object[] { name }, new UserMapper());
    }

    public boolean updateUser(User user, String name) {
        return jdbcTemplate.update(UPDATE_USER, user.getName(), user.getSector(), name) > 0;
    }
}
