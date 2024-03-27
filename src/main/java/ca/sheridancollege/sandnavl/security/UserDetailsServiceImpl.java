package ca.sheridancollege.sandnavl.security;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ca.sheridancollege.sandnavl.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		ca.sheridancollege.sandnavl.beans.User user = userRepo.findUserByUserName(username);
		if (user == null) {
			System.out.println("User Not Found");
			throw new UsernameNotFoundException("No user by the name");
		}
		ArrayList<String> roles = userRepo.getRolesById(user.getUserId());
		ArrayList<GrantedAuthority> grantList = new ArrayList<GrantedAuthority>();
		for (String role : roles) {
			grantList.add(new SimpleGrantedAuthority(role));
		}
		User springUser = new User(user.getUserName(), user.getEncryptedPassword(), grantList);
		return (UserDetails) springUser;
	}

}
