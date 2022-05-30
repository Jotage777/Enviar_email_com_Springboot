package com.integralys.joaogabriel.Teste_cep_selecao_dev_java.controler;

import javax.validation.Valid;

import org.springframework.beans.BeanUtils;

import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.EmailDto;
import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.EmailModelo;
import com.integralys.joaogabriel.Teste_cep_selecao_dev_java.EnviarEmail;

public class EmailControler {
	public void validar_email( @Valid EmailDto emailDto) {
		EmailModelo emailModelo = new EmailModelo();
		BeanUtils.copyProperties(emailDto, emailModelo);
		EnviarEmail enviar = new EnviarEmail();
		enviar.enviar_email(emailModelo);
	}
}
