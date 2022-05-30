package com.integralys.joaogabriel.Teste_cep_selecao_dev_java;

import java.io.BufferedReader;
import java.io.IOException;

public class ConverterJson {
	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
        String resposta, jsonEmString = "";
        while ((resposta = buffereReader.readLine()) != null) {
            jsonEmString += resposta;
        }
        return jsonEmString;
    }
	
}
