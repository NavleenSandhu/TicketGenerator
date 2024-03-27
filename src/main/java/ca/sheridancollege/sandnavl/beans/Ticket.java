package ca.sheridancollege.sandnavl.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ticket {
	private int id;
	private String fullName;
	private String campus;
	private double price;
	private String phone;
	private String email;
	private String city;
	private int userId;
}
