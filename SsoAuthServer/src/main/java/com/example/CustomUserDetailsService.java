package com.example;

import com.example.data.Account;
import com.example.data.AccountRepository;
import com.example.data.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Set;


@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private AccountRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = userRepository.findByAccountUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException(String.format("User %s does not exist!", username));
        }

        String password = account.getPassword();
        boolean enabled = true;
        boolean accountNonExpired = true;
        boolean credentialsNonExpired = true;
        boolean accountNonLocked = true;
        Collection<? extends GrantedAuthority> authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(getAuthorities(account.getRoles()));
        return new User(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
    }

    private String getAuthorities(Set<Role> roles) {
        StringBuilder stringBuilder = new StringBuilder();
        roles.forEach(role -> stringBuilder.append(role.getRoleName() + ","));
        return stringBuilder.toString();
    }


//    private final static class UserRepositoryUserDetails extends User implements UserDetails {
//
//        private static final long serialVersionUID = 1L;
//
//        public UserRepositoryUserDetails(String username, String password, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
//            super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
//        }
//    }

}
