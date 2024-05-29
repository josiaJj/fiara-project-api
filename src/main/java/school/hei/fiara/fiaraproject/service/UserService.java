

package school.hei.fiara.fiaraproject.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.stereotype.Service;
import school.hei.fiara.fiaraproject.model.LoginRequest;
import school.hei.fiara.fiaraproject.model.User;
import school.hei.fiara.fiaraproject.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
@Autowired
private UserRepository userRepository;
@Autowired
private JwtService jwtService;

    public String login(LoginRequest request) {
        Optional<User> userOptional = userRepository.findByEmail(request.getUsername());
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (request.getPassword().equals(user.getPassword())) {
                return jwtService.generateToken(user);
            }
        }
        return null;
    }


    public User getUserById(Integer id) {
        Optional<User> userOptional = userRepository.findById(id);
        if (userOptional.isPresent()) {
            return userOptional.get();
        }
        return null;
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }
    public User createUser(User user) {
        User save = userRepository.save(user);
        new InMemoryUserDetailsManager(save);
        return save;
    }


    public User updateUser(Integer id, User updatedUser) {
        Optional<User> existingUser = userRepository.findById(id);

        if (existingUser.isPresent()) {
            User userToUpdate = existingUser.get();

            userToUpdate.setName(updatedUser.getName());
            userToUpdate.setEmail(updatedUser.getEmail());
            userToUpdate.setPassword(updatedUser.getPassword());

            return userRepository.save(userToUpdate);
        } else {
            return null;
        }
    }


    public void deleteUserById(Integer id) {
        userRepository.deleteById(id);
    }
}
