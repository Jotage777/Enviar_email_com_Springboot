package com.integralys.joaogabriel.Teste_cep_selecao_dev_java.controler;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.BuscarCep;
import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.EmailDto;
import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.Endereco;
import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.EnderecoModelo;


@RestController
public class Controler_API {
	@Autowired
	private EnderecoBancoDeDados er;
	
	// Endpoint para buscar o cep na api
	@GetMapping(path="/buscar_cep/{cep}")
	public ResponseEntity buscar_cep(@PathVariable("cep") String cep) throws Exception {
		
		// O cep é enviado para a class EnderecoModelo para que seja tratado o json e retorne um endereco como objeto para ser adicionado no banco de dados
		EnderecoModelo endereco = BuscarCep.buscaEnderecoPelo(cep) ;
		String erro = "true";
		// Se o cep não existir vai ser informado nessa condição
		if(erro.equals(endereco.getErro())==true) {
			System.out.println("O cep informado não existe");
		}
		else {
			 // Nessa parte o endereco é salvo no banco de dados sql e em seguida enviado para o email
			 Endereco enderecoFinal = new Endereco(endereco.getCep(),endereco.getLogradouro(),endereco.getComplemento(),endereco.getBairro(),endereco.getLocalidade(),endereco.getUf(),
			 
			 endereco.getIbge(),endereco.getGia(),endereco.getDdd(),endereco.getSiafi());
			 
			 er.save(enderecoFinal);
			 
			 String json = BuscarCep.jsonCep(cep);
        
			 String mensagem = " As informações do cep: "+ cep+ " foram adicionadas no banco de dados " + json;
			 EmailDto email = new EmailDto("jotagepb@gmail.com","contato@integralys.com.br","TESTE – CEP -\r\n"+"Seleção DEV Java - João Gabriel de Oliveira Ponciano", mensagem);
		
			 EmailControler enviar = new EmailControler();
		
			enviar.validar_email(email);
						
		}
		return null;   
	}
						
}
	  

			


