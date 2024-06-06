package school.hei.fiara.fiaraproject.controller;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${emailAdmin}")
    private String emailAdmin;

    @GetMapping("/contact")
    public String showContactForm(Model model) {
        return "contact";
    }

    @PostMapping("/contact")
    public String submitContactForm(@RequestParam("name") String name,
                                    @RequestParam("email") String email,
                                    @RequestParam("message") String message,
                                    Model model) {
        sendEmail(name, email, message);
        model.addAttribute("success", "Message sent successfully!");
        return "contact";
    }

    private void sendEmail(String name, String email, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(emailAdmin);
        mailMessage.setSubject("New Contact Form Submission");
        mailMessage.setText("Name: " + name + "\nEmail: " + email + "\nMessage: " + message);
        mailSender.send(mailMessage);
    }
}
