package com.example.transfer;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.example.transfer.dao.ClientRepository;
import com.example.transfer.entities.Client;

@SpringBootApplication
public class TransferApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(TransferApplication.class, args);
		ClientRepository cr = ctx.getBean(ClientRepository.class);
		cr.save(new Client(1, "c1","30602002" ,"ek" ,"fatma" , "fatmaek@gmail.com", 0));
		cr.save(new Client(2, "c2","36959539" ,"abd" ,"zeina" , "zeina@gmail.com", 0));
		cr.save(new Client(3, "c3","38515258" ,"ali" ,"khadjetou" , "khadjetou@gmail.com", 0));
		
	
		
	}

}
