package br.uern.wagner.sc.soapcomjuddi.modelo;

public class Servico {
	private String nome;
	private String wsdl;
	private String operacao;
	private double disponibilidade;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getWsdl() {
		return wsdl;
	}
	public void setWsdl(String wsdl) {
		this.wsdl = wsdl;
	}
	public String getOperacao() {
		return operacao;
	}
	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	public double getDisponibilidade() {
		return disponibilidade;
	}
	public void setDisponibilidade(double disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
}	
