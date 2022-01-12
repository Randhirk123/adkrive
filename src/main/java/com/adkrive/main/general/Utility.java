package com.adkrive.main.general;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.UnknownHostException;
import java.security.SecureRandom;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.http.HttpServletRequest;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.sun.mail.smtp.SMTPTransport;

public class Utility {
	
	static final String AB ="0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	static SecureRandom rnd = new SecureRandom();
    public static String getSiteURL(HttpServletRequest request) {
        String siteURL = request.getRequestURL().toString();
        return siteURL.replace(request.getServletPath(), "");
    }
    
    public static boolean sendMailToAll(List<String> names, String subject, String message, JavaMailSender mailSender) throws MessagingException, UnknownHostException, IOException
    {
    	
    	Properties props = new Properties();  
        props.setProperty("mail.transport.protocol", "smtp");     
        props.setProperty("mail.host", "smtp.gmail.com");  
        props.put("mail.smtp.auth", "true");    
        props.put("mail.debug", "true"); 
        props.put("mail.smtp.port", 587); 
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port",587);  
       
      
        Session session = Session.getInstance(props,
        	    new Authenticator() {
        	        protected PasswordAuthentication  getPasswordAuthentication() {
        	        return new PasswordAuthentication(
        	                    "randhircs32@gmail.com", "9931998890");
        	                }
        	    });
    	 InternetAddress[] address = new InternetAddress[names.size()];
		 for(int i=0; i< names.size(); i++ )
		 {
			 address[i] = new InternetAddress(names.get(i));
		 }
    	
    	
    	//Html mail

		  MimeMessage msg = new MimeMessage(session);
		  msg.setFrom(new InternetAddress(GeneralConstant.sendFrom, "Admin"));
		  msg.addRecipients(Message.RecipientType.TO, address);
		  msg.setSubject(subject,"UTF-8");
		  
		  Multipart mp = new MimeMultipart();
		  MimeBodyPart htmlPart = new MimeBodyPart();
		  htmlPart.setContent(message,"text/html");
		  mp.addBodyPart(htmlPart);
		  msg.setContent(mp);
		  
		  SMTPTransport t = (SMTPTransport) session.getTransport("smtp");
		  t.connect();
	        t.sendMessage(msg, msg.getAllRecipients());
	        t.close();
		return true;
    	
    }
    
    public static String[] getSplitOfListString(String splitStr)
    {
    	if(splitStr!=null)
    	{
    		String[] str=splitStr.split("\\R");
    		return str;
    	}
    	else
    	{
    		return null;
    	}
    	
    	
    }
    
    public static String generateUniqueTranx(int len)
    {
    	StringBuilder sb = new StringBuilder(len);
 	   for(int i = 0; i < len; i++)
 	      sb.append(AB.charAt(rnd.nextInt(AB.length())));
 	   return sb.toString();  
    	
    }
    
     public static boolean sendMailToSpecific(String email,String message,String subject, JavaMailSender mailSender) throws MessagingException, UnsupportedEncodingException
     {
    	 MimeMessage msg = mailSender.createMimeMessage();
 		MimeMessageHelper helper = new MimeMessageHelper(msg);
 		helper.setFrom("contact@shopme.com", "AdsRock Support");
		helper.setTo(email);
		helper.setSubject(subject);

		helper.setText(message, true);

		mailSender.send(msg);
		return true;
    	 
     }
    
     
     public static Map<String, String> convertJsonToJava(String json) throws JsonMappingException, JsonProcessingException
     {
    	 ObjectMapper mapper = new ObjectMapper();
    	 Map<String, String> map = mapper.readValue(json, Map.class);
		return map;
    	 
    	 
     }
     
     public static boolean testSms(String mobile) throws IOException, InterruptedException
     {
    	 String code="123456";
			/*
			 * OkHttpClient client = new OkHttpClient(); RequestBody formBody = new
			 * FormEncodingBuilder() .add("phoneNumber",mobile) .build(); Request request =
			 * new Request.Builder() .url(
			 * "https://telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com/sms-verification-code?phoneNumber=8252413798&verifyCode=123456")
			 * .post(formBody) .addHeader("x-rapidapi-host",
			 * "telesign-telesign-send-sms-verification-code-v1.p.rapidapi.com")
			 * .addHeader("x-rapidapi-key",
			 * "5895a11285msh8bfaa314642dda7p19bea4jsn4e8b121e07c7") .build(); Response
			 * response=client.newCall(request).execute(); return response.isSuccessful();
			 */
    	 
    	 
    	 OkHttpClient client = new OkHttpClient();

    	 Request request = new Request.Builder()
    	   .url("http://msg.msgclub.net/rest/services/sendSMS/sendGroupSms?AUTH_KEY=e6def24b1dfd5adc86b11066a32a9d59&message='hello'&senderId=DEMOOS&routeId=1&mobileNos=8252413798&smsContentType=english")
    	   .get()
    	   .addHeader("Cache-Control", "no-cache")
    	   .build();


    	 Response response = client.newCall(request).execute();
    	 
    	 String msg=response.message();
    	 System.out.println(msg+" "+response.isRedirect());
    	 return response.isSuccessful();
    	 
     }

}
