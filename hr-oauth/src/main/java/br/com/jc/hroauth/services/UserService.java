package br.com.jc.hroauth.services;

import br.com.jc.hroauth.entities.User;
import br.com.jc.hroauth.feingClients.UserFeingClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserFeingClient userFeingClient;


    public User findByEmail(String email){
        User user = userFeingClient.getUserByEmail(email).getBody();
        if (user == null) {
            log.error("E-mail not found " + email);
            throw new IllegalArgumentException("Email not found");
        }
        log.info("E-mail found " + email);
        return user;
    }
}
