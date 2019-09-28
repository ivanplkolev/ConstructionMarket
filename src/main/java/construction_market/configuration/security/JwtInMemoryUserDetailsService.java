package construction_market.configuration.security;


import construction_market.entities.UserE;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JwtInMemoryUserDetailsService implements UserDetailsService {



    private final UserRepo repository;

    @Autowired
    public JwtInMemoryUserDetailsService(UserRepo repository) {
        this.repository = repository;
    }


//    static List<JwtUserDetails> inMemoryUserList = new ArrayList<>();
//
//    static {
//        inMemoryUserList.add(new JwtUserDetails(1L, "in28minutes",
//                "$2a$10$3zHzb.Npv1hfZbLEU5qsdOju/tk2je6W6PnNnY.c1ujWPcZh4PL6e", "ROLE_USER_2"));
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<JwtUserDetails> findFirst = inMemoryUserList.stream()
//                .filter(user -> user.getUsername().equals(username)).findFirst();
//
//        if (!findFirst.isPresent()) {
//            throw new UsernameNotFoundException(String.format("USER_NOT_FOUND '%s'.", username));
//        }
//
//        return findFirst.get();


        UserE foundUser = this.repository.findByUserName(username);
        return new JwtUserDetails(foundUser.getId(), foundUser.getUserName(), foundUser.getPassword(), "ROLE_USER_2");



    }

}

