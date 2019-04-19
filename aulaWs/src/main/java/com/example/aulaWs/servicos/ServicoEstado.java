package com.example.aulaWs.servicos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.aulaWs.dao.DAOEstado;
import com.example.aulaWs.entidade.copy.Estado;

@RestController//Vai ser webService
@RequestMapping("/ws")
public class ServicoEstado {
	
	@Autowired
	private DAOEstado dao;//Spring injeta dependencia
	
	@RequestMapping(value="/estado", method = RequestMethod.POST)
	public void salvar(@RequestBody Estado estado) {
		dao.save(estado);
	}

}
