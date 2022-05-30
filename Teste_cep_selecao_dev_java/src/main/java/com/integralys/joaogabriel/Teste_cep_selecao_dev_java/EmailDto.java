package com.integralys.joaogabriel.Teste_cep_selecao_dev_java;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class EmailDto {
	@NotBlank
	@Email
	private String emailFrom;
	@NotBlank
	@Email
    private String emailTo;
	@NotBlank
    private String subject;
	@NotBlank
    private String text;
	public EmailDto(@NotBlank @Email String emailFrom, @NotBlank @Email String emailTo, @NotBlank String subject,
			@NotBlank String text) {
		super();
		this.emailFrom = emailFrom;
		this.emailTo = emailTo;
		this.subject = subject;
		this.text = text;
	}
	public String getEmailFrom() {
		return emailFrom;
	}
	public void setEmailFrom(String emailFrom) {
		this.emailFrom = emailFrom;
	}
	public String getEmailTo() {
		return emailTo;
	}
	public void setEmailTo(String emailTo) {
		this.emailTo = emailTo;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	
	

}
