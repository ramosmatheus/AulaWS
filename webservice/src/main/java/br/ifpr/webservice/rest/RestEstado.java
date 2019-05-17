package br.ifpr.webservice.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ifpr.webservice.dao.DAOEstado;
import br.ifpr.webservice.entidade.Estado;

@CrossOrigin
@RestController
@RequestMapping("/ws/estado/")
public class RestEstado {
	@Autowired
	private DAOEstado dao;

	@RequestMapping(method = RequestMethod.POST)
	public void salvar(@RequestBody Estado estado) {
		dao.save(estado);
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Estado>> buscar() {
		List<Estado> lista = dao.findAll();
		ResponseEntity<List<Estado>> resposta = new ResponseEntity<>(lista,HttpStatus.OK);
		return resposta;
	}
	@RequestMapping(value="{id}", method = RequestMethod.DELETE)
	public void excluir(@PathVariable("id") int id) {
		dao.deleteById(id);
	}
	@RequestMapping(method = RequestMethod.PUT)
	public void alterar(@RequestBody Estado estado) {
		Estado estadoBD = dao.findById(estado.getId()).get();
		estadoBD.setNome(estado.getNome());
		estadoBD.setSigla(estado.getSigla());
		dao.saveAndFlush(estadoBD);
	}

}
