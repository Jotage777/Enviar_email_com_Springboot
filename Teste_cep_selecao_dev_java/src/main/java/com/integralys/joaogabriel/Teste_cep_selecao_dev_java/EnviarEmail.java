package com.integralys.joaogabriel.Teste_cep_selecao_dev_java;

import java.util.Properties;


import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


public class EnviarEmail {

	public void enviar_email( EmailModelo emailModel ) {
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.ssl.enable", "true");
	    props.put("mail.smtp.port", "465");

	    Session session = Session.getDefaultInstance(props,
	    new javax.mail.Authenticator() {
	    	protected PasswordAuthentication getPasswordAuthentication()
	    	{return new PasswordAuthentication("email","senha");
	        }
	      });

	    session.setDebug(true);
		 
		try{
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(emailModel.getEmailFrom()));
			Address[] toUser = InternetAddress.parse(emailModel.getEmailTo());
            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject(emailModel.getSubject());
            message.setText(emailModel.getText());
            Transport.send(message);
            System.out.println("Email enviado com sucesso");
	    }catch (MessagingException e){
        	throw new RuntimeException(e);
		
	    }
	}
}
