package br.edu.unoesc.funcionarios;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.edu.unoesc.funcionarios.service.FuncionarioService;

@SpringBootApplication
public class ExemploH2Application {
	@Value("${mensagem}")
	private String mensagem;
	
	@Value("${ambiente}")
	private String ambiente;
	
	public static void main(String[] args) {
		SpringApplication.run(ExemploH2Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(FuncionarioService servico) {
		return args -> {
			System.out.println(mensagem + " " + ambiente);
			
			servico.popularTabelaInicial();
			
		};
	}
}

