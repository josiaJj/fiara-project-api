package school.hei.fiara.fiaraproject.controller;


import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.User;
import school.hei.fiara.fiaraproject.repository.UserRepository;
import school.hei.fiara.fiaraproject.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins = {"http://localhost:3000"})

public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        User foundUser = userRepository.findByEmail(user.getEmail());
        if(foundUser != null && foundUser.getPassword().equals(user.getPassword())){
            return ResponseEntity.ok().body("Login successful");
        }
        else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User newUser) {
        User user = userService.register(newUser);
        if (user != null) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PostMapping("/api/logout")
    public ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.invalidate();
        }
        return ResponseEntity.ok("Logout successful");
    }

    @GetMapping("/all")
    public List<User> findAllUser(){
        return  userService.allUser();
    }
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Integer id ){
        userService.deleteUser(id);
    }
    @GetMapping("/{id}")
    public Optional<User> findById(@PathVariable Integer id){
        return userService.findById(id);
    }
    @PutMapping("/{id}")
    public User UpdateUser(@PathVariable Integer id , @RequestBody User user){
        return  userService.updateUser(id,user);
    }
}