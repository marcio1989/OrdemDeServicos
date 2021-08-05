package com.marcio.os;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.marcio.os.domain.Cliente;
import com.marcio.os.domain.OS;
import com.marcio.os.domain.Tecnico;
import com.marcio.os.domain.enuns.Prioridade;
import com.marcio.os.domain.enuns.Status;
import com.marcio.os.repositories.ClienteRepository;
import com.marcio.os.repositories.OSRepository;
import com.marcio.os.repositories.TecnicoRepository;

@SpringBootApplication
public class OsApplication implements CommandLineRunner {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private OSRepository osRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(OsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Tecnico t1 = new Tecnico(null, "Marcio Muniz", "144.785.300-84", "(88) 98888-8888");
		Cliente c1 = new Cliente(null, "Betina Campos", "598.508.200-80", "(88) 98888-7777");
		OS os1 = new OS(null, Prioridade.ALTA, "Teste create OD", Status.ANDAMENTO, t1, c1);
		
		t1.getList().add(os1);
		c1.getList().add(os1);
		
		tecnicoRepository.saveAll(Arrays.asList(t1));
		clienteRepository.saveAll(Arrays.asList(c1));
		osRepository.saveAll(Arrays.asList(os1));
		
	}

}
