package br.ifpr.webservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ifpr.webservice.entidade.Estado;

public interface DAOEstado extends JpaRepository<Estado, Integer> {

}
