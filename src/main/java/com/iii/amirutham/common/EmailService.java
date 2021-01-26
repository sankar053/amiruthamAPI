package com.iii.amirutham.common;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailService {

    @Value("${support.email}")
    private String fromEmail;
    
    private static final String BACKGROUND_IMAGE = "templates/images/background.png";
    private static final String LOGO_BACKGROUND_IMAGE = "templates/images/logo-background.png";
    private static final String THYMELEAF_BANNER_IMAGE = "templates/images/thymeleaf-banner.png";
    private static final String THYMELEAF_LOGO_IMAGE = "templates/images/thymeleaf-logo.png";
    private static final String PNG_MIME = "image/png";
    
    private final TemplateEngine templateEngine;
    private final JavaMailSender javaMailSender;

    public EmailService(TemplateEngine templateEngine, JavaMailSender javaMailSender) {
        this.templateEngine = templateEngine;
        this.javaMailSender = javaMailSender;
    }
  //  Object data,
    public void sendTemplateEmail(String toEmail, String subject, String templateName, Object data, String cc) {
        Context context = new Context();
        context.setVariable("register", data);
        context.setVariable("name", "sankar");
        String html = this.templateEngine.process(templateName, context);
        
    

        try {
            this.javaMailSender.send(constructEmail(subject, html, toEmail, cc, true));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public void sendStringEmail(String toEmail, String subject, String body, String cc) {
        try {
            this.javaMailSender.send(constructEmail(subject, body, toEmail, cc,  false));
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    private MimeMessage constructEmail(String subject, String body, String toEmail, String cc, boolean isHtml) throws MessagingException {
        final MimeMessage mimeMessage = this.javaMailSender.createMimeMessage();
        final MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true, "UTF-8");
        message.setSubject(subject);
        message.setFrom(fromEmail);
        message.setTo(toEmail);
        // Add the inline images, referenced from the HTML code as "cid:image-name"
//        message.addInline("background", new ClassPathResource(BACKGROUND_IMAGE), PNG_MIME);
//       	message.addInline("logo-background", new ClassPathResource(LOGO_BACKGROUND_IMAGE), PNG_MIME);
//        message.addInline("thymeleaf-banner", new ClassPathResource(THYMELEAF_BANNER_IMAGE), PNG_MIME);
       // message.addInline("thymeleaf-logo", new ClassPathResource(THYMELEAF_LOGO_IMAGE), PNG_MIME);
        if(!ObjectUtils.isEmpty(cc)) message.setCc(cc);
        message.setText(body, isHtml);
        return mimeMessage;
    }

}
