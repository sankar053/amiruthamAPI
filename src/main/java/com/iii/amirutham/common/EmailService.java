package com.iii.amirutham.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Value("${support.email}")
    private String fromEmail;
    

    
    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }
  //  Object data,
    
    public void sendTemplateEmail(String toEmail, String subject, String templateName, Object data, String cc) {
    	 Context context = new Context();
         context.setVariable("data", data);
//         context.setVariable("name", "test");
//         context.setVariable("otp", 123);
         String html = this.templateEngine.process(templateName, context);
         try {
             constructEmail(subject, html, toEmail, cc, true);
         } catch (MessagingException e) {
             e.printStackTrace();
         }
    }

    public void sendStringEmail(String toEmail, String subject, String body, String cc) {
        try {
            constructEmail(subject, body, toEmail, cc,  false);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
    @Async
    private void constructEmail(String subject, String body, String toEmail, String cc, boolean isHtml) throws MessagingException {
        final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true, "UTF-8");
        message.setSubject(subject);
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        if(!ObjectUtils.isEmpty(cc)) message.setCc(cc);
        message.setText(body, isHtml);
        this.javaMailSender.send(mimeMessage);
     //   return mimeMessage;
    }

}
