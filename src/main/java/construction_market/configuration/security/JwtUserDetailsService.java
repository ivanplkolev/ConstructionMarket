package construction_market.configuration.security;


import construction_market.entities.UserE;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService {



    private final UserRepo repository;

    @Autowired
    public JwtUserDetailsService(UserRepo repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserE foundUser = this.repository.findByUserName(username);
        return new JwtUserDetails(foundUser.getId(), foundUser.getUserName(), foundUser.getPassword(), "ROLE_USER_2");



    }

}

