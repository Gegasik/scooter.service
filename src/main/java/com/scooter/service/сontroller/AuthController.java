package com.scooter.service.сontroller;

import com.scooter.service.conf.jwt.JwtProvider;
import com.scooter.service.model.AuthRequest;
import com.scooter.service.model.AuthResponse;
import com.scooter.service.model.RegistrationRequest;
import com.scooter.service.model.UserModel;
import com.scooter.service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class AuthController {
    @Autowired
    private UserService userService;
    @Autowired
    private JwtProvider jwtProvider;


    @GetMapping("/register")
    public ModelAndView registerPage() {
        return new ModelAndView("register.html");
    }

    @PostMapping("/register")
    public ResponseEntity registerUser(@RequestBody RegistrationRequest registrationRequest) {
        UserModel u = new UserModel();
        u.setPassword(registrationRequest.getPassword());
        u.setLogin(registrationRequest.getLogin());
        u.setRole(1);
        System.out.println(registrationRequest);
        UserModel user= new UserModel();
        try {
            user = (UserModel) userService.save(u);
        }catch (Exception ex){
            return ResponseEntity.ok(user);
        }
        return ResponseEntity.ok(user);
    }

    @PostMapping("/auth")
    public AuthResponse auth(@RequestBody AuthRequest request) {
        UserModel userEntity = userService.findByNameAndPassword(request.getLogin(), request.getPassword());
        String token = jwtProvider.generateToken(userEntity.getLogin());
        return new AuthResponse(token);
    }
}
