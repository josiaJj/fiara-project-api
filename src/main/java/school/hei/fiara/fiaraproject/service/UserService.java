

package school.hei.fiara.fiaraproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.LoginRequest;
import school.hei.fiara.fiaraproject.model.User;
import school.hei.fiara.fiaraproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BCryptPasswordEncoder passwordEncoders;

    public void save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }

    public User login(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && passwordEncoder.matches(password, user.getPassword())) {
            return user;
        }
        return null;
    }

    public User register(User newUser) {
        if (userRepository.findByEmail(newUser.getEmail()) != null) {
            return null;
        }
        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));
        return userRepository.save(newUser);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public List<User> allUser(){
        return  userRepository.findAll();
    }
    public  void deleteUser(Integer id){
        userRepository.deleteById(id);
    }
    public Optional<User> findById(Integer id){
        return userRepository.findById(id);
    }
    public User updateUser(Integer id, User newUserDetails) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isPresent()) {
            User existingUser = optionalUser.get();
            existingUser.setName(newUserDetails.getName());
            existingUser.setEmail(newUserDetails.getEmail());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found with id  : " + id);
        }
    }

}