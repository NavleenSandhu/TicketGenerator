package ca.sheridancollege.sandnavl.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sandnavl.beans.User;

@Repository
public class UserRepository {
	@Autowired
	private NamedParameterJdbcTemplate jdbc;
	
	public User findUserByUserName(String userName) {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query= "SELECT * FROM SEC_USER WHERE USER_NAME=:un";
		parameters.addValue("un", userName);
		ArrayList<User> users=(ArrayList<User>) jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));
		if(users.size()>0) {
			return users.get(0);
		}
		return null;
	}
	public ArrayList<String> getRolesById(long id) {
		ArrayList<String> roles= new ArrayList<String>();
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="SELECT SEC_USER.USER_ID, SEC_ROLE.ROLE_NAME "
				+ "FROM SEC_ROLE, SEC_USER "
				+ "WHERE SEC_USER.ROLE_ID = SEC_ROLE.ROLE_ID "
				+ "AND USER_ID=:id;";
		parameters.addValue("id", id);
		List<Map<String,Object>> rows= jdbc.queryForList(query, parameters);
		for(Map row:rows) {
			roles.add((String)row.get("role_Name"));
		}
		return roles;
	}
	public void addUser(String username, String password) {
		BCryptPasswordEncoder encoder= new BCryptPasswordEncoder();
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query= "insert into SEC_USER (user_Name, encrypted_Password, ROLE_ID) "
				+ "values (:username, :password,2);";
		parameters.addValue("username", username);
		parameters.addValue("password", encoder.encode(password));
		jdbc.update(query, parameters);
	}
	
	public List<User> getUsers() {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query= "SELECT * FROM SEC_USER ORDER BY USER_NAME";
		return jdbc.query(query, parameters, new BeanPropertyRowMapper<User>(User.class));
	}
}
