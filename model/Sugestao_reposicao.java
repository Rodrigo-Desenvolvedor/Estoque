package model;

import java.sql.Date;

public class Sugestao_reposicao {
	private int idSugestao;
	private String tipoItem;
	private String codigoItem;
	private int estoqueAtual;
	private int estoqueMinimo;
	private int estoqueMaximo;
	private int quantidadeReservada;
	private int quantidadeEmPedido;
	private int saldoProjetado;
	private int quantidadeSugerida;
	private int leadTime;
	private Date dataPrevistaReposicao;
	private int idResponsavel;
	private String statusSugestao;
	private String justificativa;
	
	public Sugestao_reposicao () {}
	
	public Sugestao_reposicao (int idSugestao, String tipoItem,
							   String codigoItem, int estoqueAtual,
							   int estoqueMinimo, int estoqueMaximo,
							   int quantidadeReservada, int quantidadeEmPedido,
							   int saldoProjetado, int quantidadeSugerida,
							   int leadTime, Date dataPrevistaReposicao,
							   int idResponsavel, String statusSugestao,
							   String justificativa) {
		this();
		this.setIdSugestao(idSugestao);
		this.setTipoItem(tipoItem);
		this.setCodigoItem(codigoItem);
		this.setEstoqueAtual(estoqueAtual);
		this.setEstoqueMinimo(estoqueMinimo);
		this.setEstoqueMaximo(estoqueMaximo);
		this.setQuantidadeReservada(quantidadeReservada);
		this.setQuantidadeEmPedido(quantidadeEmPedido);
		this.setSaldoProjetado(saldoProjetado);
		this.setQuantidadeSugerida(quantidadeSugerida);
		this.setLeadTime(leadTime);
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

	public int getEstoqueAtual() {
		return estoqueAtual;
	}

	public void setEstoqueAtual(int estoqueAtual) {
		this.estoqueAtual = estoqueAtual;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public int getEstoqueMaximo() {
		return estoqueMaximo;
	}

	public void setEstoqueMaximo(int estoqueMaximo) {
		this.estoqueMaximo = estoqueMaximo;
	}

	public int getQuantidadeReservada() {
		return quantidadeReservada;
	}

	public void setQuantidadeReservada(int quantidadeReservada) {
		this.quantidadeReservada = quantidadeReservada;
	}

	public int getQuantidadeEmPedido() {
		return quantidadeEmPedido;
	}

	public void setQuantidadeEmPedido(int quantidadeEmPedido) {
		this.quantidadeEmPedido = quantidadeEmPedido;
	}

	public int getSaldoProjetado() {
		return saldoProjetado;
	}

	public void setSaldoProjetado(int saldoProjetado) {
		this.saldoProjetado = saldoProjetado;
	}

	public int getQuantidadeSugerida() {
		return quantidadeSugerida;
	}

	public void setQuantidadeSugerida(int quantidadeSugerida) {
		this.quantidadeSugerida = quantidadeSugerida;
	}

	public int getLeadTime() {
		return leadTime;
	}

	public void setLeadTime(int leadTime) {
		this.leadTime = leadTime;
	}

	public Date getDataPrevistaReposicao() {
		return dataPrevistaReposicao;
	}

	public void setDataPrevistaReposicao(Date dataPrevistaReposicao) {
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