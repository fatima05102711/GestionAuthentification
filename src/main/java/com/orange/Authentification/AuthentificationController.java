package com.orange.Authentification;

import com.orange.Authentification.Service.Impl.AuthenticationService;
import com.orange.Authentification.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/authentification")
@RequiredArgsConstructor
public class AuthentificationController {
    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public  ResponseEntity<User>  registrer (@RequestBody User user)
    {
        User response = authenticationService.register(user);

          return ResponseEntity.ok(response);
    }


    @PostMapping("/authentification")
    public ResponseEntity<AuthentificationResponse> authenticate(@RequestBody User user)
    {
        AuthentificationResponse response = authenticationService.authenticate(user);
        return ResponseEntity.ok(response);
    }
}
