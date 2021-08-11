package br.com.jc.hroauth.feingClients;

import br.com.jc.hroauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(name="hr-user", path="/users")
public interface UserFeingClient {
    @GetMapping(path = "/search")
    ResponseEntity<User> getUserByEmail(@RequestParam String email);

}
