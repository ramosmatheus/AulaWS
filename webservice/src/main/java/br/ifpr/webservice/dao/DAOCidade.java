package br.ifpr.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.webservice.entidade.Cidade;

public interface DAOCidade extends JpaRepository<Cidade, Integer> {

}
