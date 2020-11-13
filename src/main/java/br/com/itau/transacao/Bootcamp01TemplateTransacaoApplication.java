package br.com.itau.transacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Bootcamp01TemplateTransacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bootcamp01TemplateTransacaoApplication.class, args);
	}

}
