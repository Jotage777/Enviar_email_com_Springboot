package com.integralys.joaogabriel.Teste_cep_selecao_dev_java.controler;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class Controler_API {
	
	@GetMapping(path="/buscar_cep/{cep}")
	public ResponseEntity buscar_cep(@PathVariable("cep") String cep) {
		try {
			URL url = new URL ("https://viacep.com.br/ws/"+cep+"/json/?callback=?");
			HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
			conexao.setRequestMethod("GET");
			conexao.connect();
			
			int responseCode = conexao.getResponseCode();
			if(responseCode != 200) {
				throw new RuntimeException("Ocorreu um erro" + responseCode );
		}
		else {
			StringBuilder json = new StringBuilder();
			
			Scanner scanner = new Scanner(url.openStream());
			while(scanner.hasNext()) {
				json.append(scanner.nextLine());
			}
			
			scanner.close();
			
			System.out.println(json);
			
			
			
			
		}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		

}
