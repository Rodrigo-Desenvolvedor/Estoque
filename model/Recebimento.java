package model;

import java.sql.Date;

public class Recebimento {
	private int idRecebimento;
	private int idPedido;
	private String tipoItem;
	private String codigotItem;
	private int idFornecedor;
	private int quantidadeSolicitada;
	private int quantidadeRecebida;
	private int idLocalDestino;
	private String documentoAquisicao;
	private int idResponsavel;
	private String lote;
	private String numeroSerie;
	private Date dataFabricacao;
	private Date dataValidade;
	private Date dataRecebimento;
	
	public Recebimento () {}
	
	public Recebimento (int idRecebimento, int idPedido,
						String tipoItem, String codigoItem,
						int idFornecedor, int quantidadeSolicidata,
						int quantidadeRecebida, int idLocalDestino,
						String documentoAquisicao, int idResponsavel,
						String lote, String numneroSerie,
						Date dataFabricacao, Date dataValidade,
						Date dataRecebimento) {
		this();
		this.setIdRecebimento(idRecebimento);
		this.setIdPedido(idPedido);
		this.setTipoItem(tipoItem);
		this.setCodigotItem(codigoItem);
		this.setIdFornecedor(idFornecedor);
		this.setQuantidadeSolicitada(quantidadeSolicidata);
		this.setQuantidadeRecebida(quantidadeRecebida);
		this.setIdLocalDestino(idLocalDestino);
		this.setDocumentoAquisicao(documentoAquisicao);
		this.setIdResponsavel(idResponsavel);
		this.setLote(lote);
		this.setNumeroSerie(numneroSerie);
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

	public String getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(String tipoItem) {
		this.tipoItem = tipoItem;
	}

	public String getCodigotItem() {
		return codigotItem;
	}

	public void setCodigotItem(String codigotItem) {
		this.codigotItem = codigotItem;
	}

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public int getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}

	public void setQuantidadeSolicitada(int quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
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

	public Date getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(Date dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataRecebimento() {
		return dataRecebimento;
	}

	public void setDataRecebimento(Date dataRecebimento) {
		this.dataRecebimento = dataRecebimento;
	}
}