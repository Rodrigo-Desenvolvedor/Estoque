package model;

import java.sql.Date;

public class Pedido_compra {
	private int idPedido;
	private int idSoliciticao;
	private String tipoItem;
	private String codigoItem;
	private int idFornecedor;
	private int quantidade;
	private Date dataPedido;
	private String statusPedido;
	
	public Pedido_compra () {}
	
	public Pedido_compra (int idPedido, int idSolicitacao,
						  String tipoItem, String codigoItem,
						  int idFornecedor, int quantidade,
						  Date dataPedido, String statusPedido) {
		this();
		this.setIdPedido(idPedido);
		this.setIdSoliciticao(idSolicitacao);
		this.setTipoItem(tipoItem);
		this.setCodigoItem(codigoItem);
		this.setIdFornecedor(idFornecedor);
		this.setQuantidade(quantidade);
		this.setDataPedido(dataPedido);
		this.setStatusPedido(statusPedido);
	}

	public int getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(int idPedido) {
		this.idPedido = idPedido;
	}

	public int getIdSoliciticao() {
		return idSoliciticao;
	}

	public void setIdSoliciticao(int idSoliciticao) {
		this.idSoliciticao = idSoliciticao;
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

	public int getIdFornecedor() {
		return idFornecedor;
	}

	public void setIdFornecedor(int idFornecedor) {
		this.idFornecedor = idFornecedor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Date getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(Date dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
}