package model;

import java.sql.Date;

public class Lote {
	private int id_lote;
	private int id_produto;
	private int id_fornecedor;
	private String numero_lote;
	private Date data_fabricacao;
	private Date data_validade;
	
	public Lote () {}
	
	public Lote (int id_lote, int id_produto,
				 int id_fornecedor, String numero_lote,
				 Date data_fabricacao, Date data_validade) {
		this();
		this.setId_lote(id_lote);
		this.setId_produto(id_produto);
		this.setId_fornecedor(id_fornecedor);
		this.setNumero_lote(numero_lote);
		this.setData_fabricacao(data_fabricacao);
		this.setData_validade(data_validade);
	}

	public int getId_lote() {
		return id_lote;
	}

	public void setId_lote(int id_lote) {
		this.id_lote = id_lote;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNumero_lote() {
		return numero_lote;
	}

	public void setNumero_lote(String numero_lote) {
		this.numero_lote = numero_lote;
	}

	public Date getData_fabricacao() {
		return data_fabricacao;
	}

	public void setData_fabricacao(Date data_fabricacao) {
		this.data_fabricacao = data_fabricacao;
	}

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
}