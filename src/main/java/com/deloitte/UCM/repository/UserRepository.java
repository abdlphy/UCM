package com.deloitte.UCM.repository;



import com.deloitte.UCM.models.User;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            return new User(
                rs.getString("user_id"),
                rs.getLong("role_id"),
                rs.getString("fullname"),
                rs.getString("email"),
                rs.getString("phone_code"),
                rs.getString("phone"),
                rs.getString("password"),
                rs.getBoolean("is_active"),
                rs.getBoolean("is_deleted"),
                rs.getString("profile")
            );
        }
    };

    // ✅ Find by email for login
    public Optional<User> findByEmail(String email) {
        String sql = "SELECT * FROM \"main\".users WHERE email = ? AND is_deleted = false";
   
        List<User> users = jdbcTemplate.query(sql, userRowMapper, email);
        return users.stream().findFirst();
    }

    // ✅ Find by userId if needed
    public Optional<User> findByUserId(String userId) {
        String sql = "SELECT * FROM main.users WHERE user_id = ? AND is_deleted = false";
        List<User> users = jdbcTemplate.query(sql, userRowMapper, userId);
        return users.stream().findFirst();
    }
}
