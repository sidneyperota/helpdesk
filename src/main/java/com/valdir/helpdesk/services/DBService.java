package com.valdir.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import com.valdir.helpdesk.domain.Chamado;
import com.valdir.helpdesk.domain.Cliente;
import com.valdir.helpdesk.domain.Tecnico;
import com.valdir.helpdesk.domain.enums.Perfil;
import com.valdir.helpdesk.domain.enums.Prioridade;
import com.valdir.helpdesk.domain.enums.Status;
import com.valdir.helpdesk.repositories.ChamadoRepository;
import com.valdir.helpdesk.repositories.ClienteRepository;
import com.valdir.helpdesk.repositories.TecnicoRepository;


// conceito de injecao de dependencias 
@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository; 
	
	@Autowired 
	private ChamadoRepository chamadoRepository; 
	
	
	
	
	public void instanciaDB() { 
		
		
		Tecnico tec1 = new Tecnico(null, "Valdir Cesar", "63653230268", "sidney@gmail.com", "123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cli1 = new Cliente( null, "Linus Trovalds", "07737038701", "linus@gmail.com", "123");
		
		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		
		tecnicoRepository.saveAll( Arrays.asList( tec1 ));
		clienteRepository.saveAll( Arrays.asList( cli1 ));
		chamadoRepository.saveAll( Arrays.asList( c1 ));
		
	}

}
