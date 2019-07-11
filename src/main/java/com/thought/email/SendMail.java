package com.thought.email;

import com.thought.Application;
import com.thought.filereader.Reader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SendMail {

    private static Logger log = LoggerFactory.getLogger(Application.class);
    private int countOfData = 0;

    @Autowired
    private EmailService emailService;

    @Scheduled(cron = "0 0 9 * * ?")
    public void sender() throws MessagingException {
        log.info("Sending Email");

        List<String> data = new Reader().reader();

        if(countOfData < data.size()) {
            String dataOne = data.get(countOfData);
            String[] quoteData = dataOne.split(",");

            MailModel mailModel = new MailModel();
            mailModel.setFrom(DetailMail.MAIL_FROM);
            mailModel.setTo(DetailMail.MAIL_TO);
            mailModel.setSubject(DetailMail.MAIL_SUBJECT);

            Map<String, Object> model = new HashMap<>();
            model.put(DetailMail.HTML_QUOTE, quoteData[0]);
            model.put(DetailMail.HTML_AUTHOR, quoteData[1]);
            mailModel.setModel(model);

            emailService.sendSimpleMessage(mailModel);
            countOfData++;
        }
        else {
            System.exit(0);
        }
    }
}
