package ca.sheridancollege.sandnavl.repositories;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import ca.sheridancollege.sandnavl.beans.Ticket;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Repository
public class TicketRepository {
	private NamedParameterJdbcTemplate jdbc;

	public void addTicket(Ticket ticket) {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="INSERT INTO TICKETS (FULL_NAME, CAMPUS, PRICE, PHONE, EMAIL, CITY, USER_ID) VALUES(:name,:campus,:price,:phone,:email,:city,:uid)";
		parameters.addValue("name", ticket.getFullName());
		parameters.addValue("campus", ticket.getCampus());
		parameters.addValue("price", ticket.getPrice());
		parameters.addValue("phone", ticket.getPhone());
		parameters.addValue("email", ticket.getEmail());
		parameters.addValue("city", ticket.getCity());
		parameters.addValue("uid", ticket.getUserId());
		jdbc.update(query,parameters);
	}

	public List<Ticket> getTickets() {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="SELECT * FROM TICKETS";
		return jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class));
	}
	
	public void editTicket(Ticket ticket) {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="UPDATE TICKETS SET FULL_NAME=:name, CAMPUS=:campus, PRICE=:price, PHONE=:phone, EMAIL=:email, CITY=:city, USER_ID=:uid WHERE ID=:id";
		parameters.addValue("name", ticket.getFullName());
		parameters.addValue("campus", ticket.getCampus());
		parameters.addValue("price", ticket.getPrice());
		parameters.addValue("phone", ticket.getPhone());
		parameters.addValue("email", ticket.getEmail());
		parameters.addValue("city", ticket.getCity());
		parameters.addValue("uid", ticket.getUserId());
		parameters.addValue("id", ticket.getId());
		jdbc.update(query,parameters);
	}
	
	public void deleteTicketById(int id) {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="DELETE FROM TICKETS WHERE ID=:id";
		parameters.addValue("id", id);
		jdbc.update(query,parameters);
		
	}

	public Ticket getTicketById(int id) {
		MapSqlParameterSource parameters= new MapSqlParameterSource();
		String query="SELECT * FROM TICKETS WHERE ID=:id";
		parameters.addValue("id", id);
		return jdbc.query(query, parameters, new BeanPropertyRowMapper<Ticket>(Ticket.class)).get(0);
	}
}
