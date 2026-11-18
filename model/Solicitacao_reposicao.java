package model;

import java.sql.Date;

public class Solicitacao_reposicao {
	private int idSolicitacao;
	private int idSugestao;
	private String tipoItem;
	private String codigoItem;
	private int quantidadeAprovada;
	private Date dataSolicitacao;
	private String statusSolicitacao;
	
	public Solicitacao_reposicao () {}
	
	public Solicitacao_reposicao (int idSolicitacao, int idSugestao,
								  String tipoItem, String codigoItem,
								  int quantidadeAprovada, Date dataSolicitacao,
								  String statusSolicitacao) {
		this();
		this.setIdSolicitacao(idSolicitacao);
		this.setIdSugestao(idSugestao);
		this.setTipoItem(tipoItem);
		this.setCodigoItem(codigoItem);
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

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getCodigoItem() {
		return codigoItem;
	}

	public void setCodigoItem(String codigoItem) {
		this.codigoItem = codigoItem;
	}

	public int getQuantidadeAprovada() {
		return quantidadeAprovada;
	}

	public void setQuantidadeAprovada(int quantidadeAprovada) {
		this.quantidadeAprovada = quantidadeAprovada;
	}

	public Date getDataSolicitacao() {
		return dataSolicitacao;
	}

	public void setDataSolicitacao(Date dataSolicitacao) {
		this.dataSolicitacao = dataSolicitacao;
	}

	public String getStatusSolicitacao() {
		return statusSolicitacao;
	}

	public void setStatusSolicitacao(String statusSolicitacao) {
		this.statusSolicitacao = statusSolicitacao;
	}
}