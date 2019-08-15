
package construction_market.configuration.security;

import construction_market.entities.UserE;
import construction_market.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

/**
 * @author Greg Turnquist
 */
// tag::code[]
@Component
public class SpringDataJpaUserDetailsService implements UserDetailsService {

	private final UserRepo repository;

	@Autowired
	public SpringDataJpaUserDetailsService(UserRepo repository) {
		this.repository = repository;
	}

	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		UserE manager = this.repository.findByUserName(name);
		return new User(manager.getUserName(), manager.getPassword(),
				AuthorityUtils.createAuthorityList(manager.getRoles()));
	}

}
// end::code[]
