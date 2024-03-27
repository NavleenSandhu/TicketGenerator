package ca.sheridancollege.sandnavl.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class User {
	private int userId;
	private String userName;
	private String encryptedPassword;
	private int roleId;
}
