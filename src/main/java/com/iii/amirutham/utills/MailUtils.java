package com.iii.amirutham.utills;

import java.nio.charset.StandardCharsets;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@PropertySource(ignoreResourceNotFound = false, value = "classpath:mail.properties")
public class MailUtils {

	@Autowired
	private JavaMailSender sender;

	@Value("${support.email}")
	private String fromEmail;

	public boolean sendMail(Map<String, Object> notificationMap) {

		String userMail = (String) notificationMap.get("userMail");
		String subject = (String) notificationMap.get("subject");
		String html = (String) notificationMap.get("html");
		MimeMessage message = sender.createMimeMessage();
		try {
			MimeMessageHelper helper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
					StandardCharsets.UTF_8.name());
			helper.setFrom(fromEmail);
			helper.setTo(userMail);
			helper.setText(html, true);
			helper.setSubject(subject);
			sender.send(message);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			log.error("Error Mailservice. {}", e.getMessage());
			return false;
		}
	}
}
