package com.thought.email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    @Autowired
    private SpringTemplateEngine templateEngine;


    public void sendSimpleMessage(MailModel mailModel) throws MessagingException {
        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message,
                MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
                StandardCharsets.UTF_8.name());

        Context context = new Context();
        context.setVariables(mailModel.getModel());
        String html = templateEngine.process("email-template", context);

        helper.setFrom(mailModel.getFrom());
        helper.setTo(mailModel.getTo());
        helper.setSubject(mailModel.getSubject());
        helper.setText(html, true);
        helper.addInline("message", new ClassPathResource("images/message.png"));
        helper.addInline("hello", new ClassPathResource("images/footer.png"));

        emailSender.send(message);
    }

}
