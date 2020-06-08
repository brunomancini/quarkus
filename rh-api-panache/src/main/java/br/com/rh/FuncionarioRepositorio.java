package br.com.rh;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class FuncionarioRepositorio implements PanacheRepository<Funcionario>{

}
