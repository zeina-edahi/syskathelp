package syskathelpproject.syskathelpproject.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;


@Service

public class EmailService {
	@Autowired
private JavaMailSender  mailsender;
	public void sendEmail(String toEmail,String password) {
		String body;
		String subject;
		body= "Salut "+toEmail+"\n"+"Votre compte syshelp a été créé avec succès et cet e-mail contient toutes les informations dont vous aurez besoin pour commencer à utiliser votre compte.\n"
				+ "\n"
				+ "Voici les détails de votre nouveau compte syshelp :"+ "\n"
				+ "Email: "+toEmail+ "\n"
	+"Mot de passe: "	+ password;
		subject=" compte syshelp pour reclamation ";
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("zeinaedahi@gmail.com");
		message.setTo(toEmail);
		message.setSubject(subject);
		message.setText(body);
		
		mailsender.send(message);
		System.out.println("email a ete envoyer");
	}
}
