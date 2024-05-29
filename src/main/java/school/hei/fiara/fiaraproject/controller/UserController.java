package school.hei.fiara.fiaraproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.hei.fiara.fiaraproject.model.LoginRequest;
import school.hei.fiara.fiaraproject.model.User;
import school.hei.fiara.fiaraproject.service.UserService;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/User/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = userService.login(loginRequest);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.OK).body("Invalid username or password");
        }
    }
    @GetMapping("/User/{id}")
    public User getUserById(@PathVariable Integer id){
        return userService.getUserById(id);
    }


    @GetMapping("/User")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/User/Create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/User/Update/{id}")
    public User updateUser(@PathVariable Integer id, @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    @DeleteMapping("/User/Delete/{id}")
    public void deleteUserById(@PathVariable Integer id) {
        userService.deleteUserById(id);
    }
}
