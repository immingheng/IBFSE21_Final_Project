package ibf2021.springboot.controllers;

// import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ibf2021.springboot.configurations.EmailConfig;
import ibf2021.springboot.models.Email;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/email", produces = MediaType.APPLICATION_JSON_VALUE)
public class EmailRESTController {

    // private static final Logger logger =
    // Logger.getLogger(EmailRESTController.class.getName());

    @Autowired
    private EmailConfig emailConfig;

    @PostMapping
    public ResponseEntity<Void> emailFromAngularForm(@RequestBody Email payload) {
        // logger.info("EMAIL OBJECT FROM ANGULAR-->" + payload.toString());
        // Creating mail senderr
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        mailSender.setHost(this.emailConfig.getHost());
        mailSender.setPort(this.emailConfig.getPort());
        mailSender.setUsername(this.emailConfig.getUsername());
        mailSender.setPassword(this.emailConfig.getPassword());
        if (emailConfig.getPassword() == null) {
            System.err.println("spring.email.password IS NOT SET IN SYSTEM ENVIRONMENT!");
        }

        // Creating email instance
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom("rotndecay@gmail.com");
        mailMessage.setTo("rotndecay@gmail.com");
        mailMessage.setSubject(payload.getSubject());
        mailMessage.setText(payload.getMessage());

        // Send mail
        mailSender.send(mailMessage);
        return ResponseEntity.ok().build();

    }

}
