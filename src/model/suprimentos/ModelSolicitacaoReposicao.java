package model.suprimentos;

import java.time.LocalDate;

public class ModelSolicitacaoReposicao {
	private int idSolicitacao;
	private int idSugestao;
	private int quantidadeAprovada;
	private LocalDate dataSolicitacao;
	private String statusSolicitacao;
	
	public ModelSolicitacaoReposicao() {}
	
	public ModelSolicitacaoReposicao(int idSolicitacao, int idSugestao,
								   int quantidadeAprovada, LocalDate dataSolicitacao,
								   String statusSolicitacao) {
		this();
		this.setIdSolicitacao(idSolicitacao);
		this.setIdSugestao(idSugestao);
		this.setQuantidadeAprovada(quantidadeAprovada);
		this.setDataSolicitacao(dataSolicitacao);
		this.setStatusSolicitacao(statusSolicitacao);
	}

	public int getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(int idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
	}

	public int getIdSugestao() {
		return idSugestao;
	}

	public void setIdSugestao(int idSugestao) {
		this.idSugestao = idSugestao;
	}

	public int getQuantidadeAprovada() {
		return quantidadeAprovada;
	}

	public void setQuantidadeAprovada(int quantidadeAprovada) {
		this.quantidadeAprovada = quantidadeAprovada;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(LocalDate dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(String statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
}
