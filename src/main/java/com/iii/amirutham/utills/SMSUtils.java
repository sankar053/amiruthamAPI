package com.iii.amirutham.utills;

import org.springframework.beans.factory.annotation.Value;

//@PropertySource(ignoreResourceNotFound = false,value = "classpath:sms.properties")
//@Component
public class SMSUtils {
	
	@Value("${aws.sns.message.accessKey}")
	private String messageAccessKey ; 
	
	@Value("${aws.sns.message.secretKey}")
	private String messageSecretKey ; 
	
	@Value("${aws.sns.message.senderId}")
	public String senderId;
	
//	@SuppressWarnings("unchecked")
//	public boolean sendSMS(Map<String, Object> notificationMap) {
//		try {
//			//System.out.println("messageSecretKey>>>>" + smsProperties.accessKey);
//			AWSCredentials awsCredentials = new BasicAWSCredentials(messageAccessKey, messageSecretKey);
//			AmazonSNSClient snsClient = new AmazonSNSClient(awsCredentials);
//			String message = (String) notificationMap.get("message");
//			String phoneNumber = Constant.SMS_DEFAULT_COUNTRY_CODE + (String) notificationMap.get("phoneNumber");
//			Map<String, MessageAttributeValue> smsAttributes = new HashMap<String, MessageAttributeValue>();
//			smsAttributes.put("AWS.SNS.SMS.SenderID",
//					new MessageAttributeValue().withStringValue(senderId).withDataType("String"));
//			smsAttributes.put("AWS.SNS.SMS.SMSType", new MessageAttributeValue()
//					.withStringValue((String) notificationMap.get("smsType")).withDataType("String"));
//			PublishResult result = snsClient.publish(new PublishRequest().withMessage(message)
//					.withPhoneNumber(phoneNumber).withMessageAttributes(smsAttributes));
//			System.out.println(result);
//		} catch (Exception e) {
//			// Logger.error(e.getMessage());
//			e.printStackTrace();
//			return false;
//		}
//		return true;
//	}
}
