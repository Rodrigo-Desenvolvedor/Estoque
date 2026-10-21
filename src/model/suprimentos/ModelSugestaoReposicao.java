package model.suprimentos;

import java.time.LocalDate;

public class ModelSugestaoReposicao {
	private int idSugestao;
	private String tipoItem;
	private String codigoItem;
	private int quantidadeSugerida;
	private LocalDate dataPrevistaReposicao;
	private int idResponsavel;
	private String statusSugestao;
	private String justificativa;
	
	public ModelSugestaoReposicao() {}
	
	public ModelSugestaoReposicao(int idSugestao, String tipoItem,
								 String codigoItem, int quantidadeSugerida,
								 LocalDate dataPrevistaReposicao, int idResponsavel,
								 String statusSugestao, String justificativa) {
		this();
		this.setIdSugestao(idSugestao);
		this.setTipoItem(tipoItem);
		this.setCodigoItem(codigoItem);
		this.setQuantidadeSugerida(quantidadeSugerida);
		this.setDataPrevistaReposicao(dataPrevistaReposicao);
		this.setIdResponsavel(idResponsavel);
		this.setStatusSugestao(statusSugestao);
		this.setJustificativa(justificativa);
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

	public int getQuantidadeSugerida() {
		return quantidadeSugerida;
	}

	public void setQuantidadeSugerida(int quantidadeSugerida) {
		this.quantidadeSugerida = quantidadeSugerida;
	}

	public LocalDate getDataPrevistaReposicao() {
		return dataPrevistaReposicao;
	}

	public void setDataPrevistaReposicao(LocalDate dataPrevistaReposicao) {
		this.dataPrevistaReposicao = dataPrevistaReposicao;
	}

	public int getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getStatusSugestao() {
		return statusSugestao;
	}

	public void setStatusSugestao(String statusSugestao) {
		this.statusSugestao = statusSugestao;
	}

	public String getJustificativa() {
		return justificativa;
	}

	public void setJustificativa(String justificativa) {
		this.justificativa = justificativa;
	}
}
