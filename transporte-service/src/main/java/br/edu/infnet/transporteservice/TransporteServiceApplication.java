package br.edu.infnet.transporteservice;

import br.edu.infnet.transporteservice.service.PedidoMessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;
import java.util.UUID;

@SpringBootApplication
public class TransporteServiceApplication implements CommandLineRunner {

	@Autowired
	PedidoMessagePublisherService pedidoPublisherService;

	public static void main(String[] args) {
		SpringApplication.run(TransporteServiceApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UUID pedidoId = UUID.randomUUID();
		pedidoPublisherService.publishPedido(pedidoId.toString());
	}

}
