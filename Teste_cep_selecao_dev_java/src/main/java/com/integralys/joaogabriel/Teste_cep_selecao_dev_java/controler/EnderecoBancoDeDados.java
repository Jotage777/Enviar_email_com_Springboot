package com.integralys.joaogabriel.Teste_cep_selecao_dev_java.controler;

import org.springframework.data.repository.CrudRepository;

import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.Endereco;

public interface EnderecoBancoDeDados extends CrudRepository<Endereco, String> {

}
