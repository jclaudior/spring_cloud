package br.com.jc.hroauth.services;

import br.com.jc.hroauth.entities.User;
import br.com.jc.hroauth.feingClients.UserFeingClient;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserFeingClient userFeingClient;

    private static Logger log = LoggerFactory.getLogger(UserService.class);

    public User findByEmail(String email){
        User user = userFeingClient.getUserByEmail(email).getBody();
        if (user == null) {
            log.error("E-mail not found " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("E-mail found " + email);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userFeingClient.getUserByEmail(s).getBody();
        if (user == null) {
            log.error("E-mail not found " + s);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("E-mail found " + s);
        return user;
    }
}
