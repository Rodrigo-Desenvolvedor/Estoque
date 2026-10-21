package model.suprimentos;

import java.time.LocalDate;

public class ModelPedidoCompra {
	private int idPedido;
	private int idSolicitacao;
	private int idFornecedor;
	private int quantidade;
	private LocalDate dataPedido;
	private String statusPedido;
	
	public ModelPedidoCompra() {}
	
	public ModelPedidoCompra(int idPedido, int idSolicitacao,
							 int idFornecedor, int quantidade,
							 LocalDate dataPedido, String statusPedido) {
		this();
		this.setIdPedido(idPedido);
		this.setIdSolicitacao(idSolicitacao);
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

	public int getIdSolicitacao() {
		return idSolicitacao;
	}

	public void setIdSolicitacao(int idSolicitacao) {
		this.idSolicitacao = idSolicitacao;
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

	public LocalDate getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDate dataPedido) {
		this.dataPedido = dataPedido;
	}

	public String getStatusPedido() {
		return statusPedido;
	}

	public void setStatusPedido(String statusPedido) {
		this.statusPedido = statusPedido;
	}
}
