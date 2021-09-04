package com.iii.amirutham.utills;

import java.io.IOException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationHelper {
	
	/*
	 * @Autowired SMSUtils smsUtils;
	 */
	
	@Autowired
	MailUtils mailUtils;
	
	
	public boolean sendNotification(String type, Map<String, Object> notificationMap) throws IOException {
		if (type.equalsIgnoreCase(Constant.NOTIFICATION_MAIL_TYPE)) {
			return mailUtils.sendMail(notificationMap);
		
		} else if (type.equalsIgnoreCase(Constant.NOTIFICATION_SMS_TYPE)) {
			//return smsUtils.sendSMS(notificationMap);
		}
		return false;
	}
}