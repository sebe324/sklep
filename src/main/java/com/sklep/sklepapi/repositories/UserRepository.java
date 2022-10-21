package com.sklep.sklepapi.repositories;

import com.sklep.sklepapi.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getUsers(){
        return jdbcTemplate.query("SELECT * FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }
    public User getUserById(int id){
        return jdbcTemplate.queryForObject("SELECT * FROM users WHERE id=?", BeanPropertyRowMapper.newInstance(User.class), id);
    }
    public int addUsers(List<User> users){
        int i;
        for(i=0; i<users.size(); i++) {
            jdbcTemplate.update("INSERT INTO users (name, lname, email, role, password) VALUES (?,?,?,?,?)",
                    users.get(i).getName(),
                    users.get(i).getLname(),
                    users.get(i).getEmail(),
                    users.get(i).getRole(),
                    users.get(i).getPassword());
        }
        return i;
    }
    public void deleteUser(int id){
        jdbcTemplate.update("DELETE FROM users WHERE id=?",id);
    }
}
