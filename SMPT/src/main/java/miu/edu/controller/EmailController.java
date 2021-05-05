package miu.edu.controller;


import miu.edu.configur.MailConfig;
import miu.edu.entity.Email;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.bind.ValidationException;

@RequestMapping("/email")
@RestController
public class EmailController {


    private MailConfig sender;

    private Email email;

    public EmailController(MailConfig sender) {

        this.sender = sender;
    }



    @PostMapping("/send")
    public void sendMail(@RequestBody Email email, BindingResult bindingResult) throws ValidationException {
        if(bindingResult.hasErrors()){
            throw  new ValidationException("Mail is not valid");
        }


        JavaMailSenderImpl helper = new JavaMailSenderImpl();
        helper.setHost(sender.getHost());
        helper.setPort(sender.getPort());
        helper.setUsername(sender.getUsername());
        helper.setPassword(sender.getPassword());


        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setFrom(email.getEmail());
        mailMessage.setTo(email.getEmail());
        mailMessage.setSubject("New email from " + email.getName());
        mailMessage.setText(email.getFeedback());
        helper.send(mailMessage);
    }

}
