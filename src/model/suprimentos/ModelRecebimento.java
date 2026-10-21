package model.suprimentos;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ModelRecebimento {
	private int idRecebimento;
	private int idPedido;
	private int quantidadeRecebida;
	private int idLocalDestino;
	private String documentoAquisicao;
	private int idResponsavel;
	private String lote;
	private String numeroSerie;
	private LocalDate dataFabricacao;
	private LocalDate dataValidade;
	private LocalDateTime dataRecebimento;
	
	public ModelRecebimento() {}
	
	public ModelRecebimento(int idRecebimento, int idPedido,
							  int quantidadeRecebida, int idLocalDestino,
							  String documentoAquisicao, int idResponsavel,
							  String lote, String numeroSerie,
							  LocalDate dataFabricacao, LocalDate dataValidade,
							  LocalDateTime dataRecebimento) {
		this();
		this.setIdRecebimento(idRecebimento);
		this.setIdPedido(idPedido);
		this.setQuantidadeRecebida(quantidadeRecebida);
		this.setIdLocalDestino(idLocalDestino);
		this.setDocumentoAquisicao(documentoAquisicao);
		this.setIdResponsavel(idResponsavel);
		this.setLote(lote);
		this.setNumeroSerie(numeroSerie);
		this.setDataFabricacao(dataFabricacao);
		this.setDataValidade(dataValidade);
		this.setDataRecebimento(dataRecebimento);
	}

	public int getIdRecebimento() {
		return idRecebimento;
	}

	public void setIdRecebimento(int idRecebimento) {
		this.idRecebimento = idRecebimento;
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getQuantidadeRecebida() {
		return quantidadeRecebida;
	}

	public void setQuantidadeRecebida(int quantidadeRecebida) {
		this.quantidadeRecebida = quantidadeRecebida;
	}

	public int getIdLocalDestino() {
		return idLocalDestino;
	}

	public void setIdLocalDestino(int idLocalDestino) {
		this.idLocalDestino = idLocalDestino;
	}

	public String getDocumentoAquisicao() {
		return documentoAquisicao;
	}

	public void setDocumentoAquisicao(String documentoAquisicao) {
		this.documentoAquisicao = documentoAquisicao;
	}

	public int getIdResponsavel() {
		return idResponsavel;
	}

	public void setIdResponsavel(int idResponsavel) {
		this.idResponsavel = idResponsavel;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDateTime getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(LocalDateTime dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
}
