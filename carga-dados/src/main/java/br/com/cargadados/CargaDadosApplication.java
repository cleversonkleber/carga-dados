package br.com.cargadados;

import br.com.cargadados.model.Pedido;
import br.com.cargadados.repository.PedidoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CargaDadosApplication {
	private static final Logger log = LoggerFactory.getLogger(CargaDadosApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(CargaDadosApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(PedidoRepository repository) {
		return (args) -> {
			repository.save(new Pedido("sacos",12));
			repository.save(new Pedido("sacos1",12));
			repository.save(new Pedido("sacos2",12));
			repository.save(new Pedido("sacos3",12));
			repository.save(new Pedido("sacos4",12));

			log.info("=========== listar pedidos ======================");
			for(Pedido pedido : repository.findAll()){
				log.info(pedido.toString());
			}

		};
	}

}
