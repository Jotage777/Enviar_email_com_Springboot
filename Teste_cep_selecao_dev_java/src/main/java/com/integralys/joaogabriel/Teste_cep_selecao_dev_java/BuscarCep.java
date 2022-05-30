package com.integralys.joaogabriel.Teste_cep_selecao_dev_java;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.google.gson.Gson;



public class BuscarCep {
	
	 public static EnderecoModelo buscaEnderecoPelo(String cep) throws Exception {
	        try {
	        	URL url = new URL ("https://viacep.com.br/ws/"+cep+"/json");
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
				conexao.setRequestMethod("GET");
				conexao.connect();
				
				int responseCode = conexao.getResponseCode();
				if(responseCode != 200) {
					throw new RuntimeException("Ocorreu um erro" + responseCode );
				}
				else {
				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            String jsonEmString = ConverterJson.converteJsonEmString(resposta);
	            Gson gson = new Gson();
	            EnderecoModelo endereco = gson.fromJson(jsonEmString, EnderecoModelo.class);
	            
	            return endereco;

				}
				} catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	    }
	 
	 public static String jsonCep(String cep) throws Exception {
	        try {
	        	URL url = new URL ("https://viacep.com.br/ws/"+cep+"/json");
				HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
				conexao.setRequestMethod("GET");
				conexao.connect();
				
				int responseCode = conexao.getResponseCode();
				if(responseCode != 200) {
					throw new RuntimeException("Ocorreu um erro" + responseCode );
				}
				else {
				BufferedReader resposta = new BufferedReader(new InputStreamReader((conexao.getInputStream())));
	            String jsonEmString = ConverterJson.converteJsonEmString(resposta);
	            
	            
	            return jsonEmString;

				}
				} catch (Exception e) {
	            throw new Exception("ERRO: " + e);
	        }
	    }
}
