package Check.Authentication.util;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.*;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

//
//@Service
//public class MailUtility {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    private TemplateEngine templateEngine; // Thymeleaf template engine
//
//    /**
//     * Sends the invitation email to the user with a registration form link.
//     *
//     * @param userEmail - recipient email
//     * @param userName - recipient name
//     * @param subjectLine - email subject
//     */
//    public void sendUserRegistrationMail(String userEmail, String userName, String subjectLine) throws Exception {
//        MimeMessage message = javaMailSender.createMimeMessage(); // Create MIME message
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        // Thymeleaf context for template variables
//        Context context = new Context();
//        context.setVariable("userName", userName);
//
//        // Use 'user-registration.html' Thymeleaf template from resources/templates/
//        String htmlContent = templateEngine.process("user-registration", context);
//
//        // Set email properties
//        helper.setTo(userEmail);
//        helper.setSubject(subjectLine);
//        helper.setText(htmlContent, true); // true for HTML email
//
//        // Send the email
//        javaMailSender.send(message);
//    }
//}





@Service
public class MailUtility {

    @Autowired
    private JavaMailSender javaMailSender;

    @Autowired
    private TemplateEngine templateEngine;

    public void sendUserRegistrationMail(String userEmail, String userName, String subjectLine, String token) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        Context context = new Context();
        context.setVariable("userName", userName);
        context.setVariable("token", token);

        String html = templateEngine.process("user-registration", context);

        helper.setTo(userEmail);
        helper.setSubject(subjectLine);
        helper.setText(html, true);

        javaMailSender.send(message);
    }
}































//@Service
//public class MailUtility {
//
//    @Autowired
//    private JavaMailSender javaMailSender;
//
//    @Autowired
//    private TemplateEngine templateEngine;
//
//    public void sendUserRegistrationMail(String userEmail, String userName, String subjectLine) throws Exception {
//        MimeMessage message = javaMailSender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message);
//
//        Context context = new Context();
//        context.setVariable("userName", userName);
//
//        String htmlContent = templateEngine.process("user-registration", context);
//        helper.setTo(userEmail);
//        helper.setSubject(subjectLine);
//        helper.setText(htmlContent, true);
//
//        javaMailSender.send(message);
//    }
//}


