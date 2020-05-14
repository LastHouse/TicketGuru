package fi.rbmk.ticketguru.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import fi.rbmk.ticketguru.user.*;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    UserRepository uRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {
        User curruser = uRepository.findByUsername(username);
        if (curruser == null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        if (curruser.getInvalid() != null) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(),
                AuthorityUtils.createAuthorityList(curruser.getUserGroup().getName()));
        if (!curruser.getActive()) {
            throw new DisabledException("The account has not been activated");
        }
        return user;
    }
}