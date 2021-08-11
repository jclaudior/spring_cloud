package br.com.jc.hruser.resources;

import br.com.jc.hruser.entities.User;
import br.com.jc.hruser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserResource {
    @Autowired
    UserRepository userRepository;


    @GetMapping(path = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        User user = userRepository.findById(id).get();
        return ResponseEntity.ok().body(user);
    }

    @GetMapping(path = "/search")
    public ResponseEntity<User> getUserByEmail(@RequestParam String email){
        User user = userRepository.findByEmail(email);
        return ResponseEntity.ok().body(user);
    }
}
