package nada.doktorski.doktorski;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import javax.mail.MessagingException;
import java.io.IOException;

@SpringBootApplication
public class DoktorskiApplication {

	@Autowired
	public JavaMailSender javaMailSender;

	public static void main(String[] args) {
		SpringApplication.run(DoktorskiApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(ApplicationContext ctx) {
		return args -> {

//			System.out.println("Sending Email...");
//
//			try {
//
//				sendEmail();
//				//sendEmailWithAttachment();
//
//			} catch (MessagingException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//
//			System.out.println("Done");

		};
	}


	void sendEmail() throws MessagingException, IOException{

		SimpleMailMessage msg = new SimpleMailMessage();
		msg.setTo("93csergityleon@gmail.com");

		msg.setSubject("Testing from Spring Boot");
		msg.setText("Hello World \n Spring Boot Email");

		javaMailSender.send(msg);

	}
}
