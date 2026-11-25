package model;

import java.sql.Date;

public class Movimentacao {
	private int id_movimentacao;
	private int id_produto;
	private int id_origem;
	private int id_destino;
	private String tipo_movimentacao;
	private double quantidade;
	private Date data_hora;
	private String motivo;
	private String documento;
	private String responsavel;
	private String observacao;
	
	public Movimentacao () {}
	
	public Movimentacao (int id_movimentacao, int id_produto,
						 int id_origem, int id_destino,
						 String tipo_movimentacao, double quantidade,
						 Date data_hora, String motivo,
						 String documento, String responsavel,
						 String observacao) {
		this();
		this.setId_movimentacao(id_movimentacao);
		this.setId_produto(id_produto);
		this.setId_origem(id_origem);
		this.setId_destino(id_destino);
		this.setTipo_movimentacao(tipo_movimentacao);
		this.setQuantidade(quantidade);
		this.setData_hora(data_hora);
		this.setMotivo(motivo);
		this.setDocumento(documento);
		this.setResponsavel(responsavel);
		this.setObservacao(observacao);
	}

	public int getId_movimentacao() {
		return id_movimentacao;
	}

	public void setId_movimentacao(int id_movimentacao) {
		this.id_movimentacao = id_movimentacao;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getId_origem() {
		return id_origem;
	}

	public void setId_origem(int id_origem) {
		this.id_origem = id_origem;
	}

	public int getId_destino() {
		return id_destino;
	}

	public void setId_destino(int id_destino) {
		this.id_destino = id_destino;
	}

	public String getTipo_movimentacao() {
		return tipo_movimentacao;
	}

	public void setTipo_movimentacao(String tipo_movimentacao) {
		this.tipo_movimentacao = tipo_movimentacao;
	}

	public double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(double quantidade) {
		this.quantidade = quantidade;
	}

	public Date getData_hora() {
		return data_hora;
	}

	public void setData_hora(Date data_hora) {
		this.data_hora = data_hora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getResponsavel() {
		return responsavel;
	}

	public void setResponsavel(String responsavel) {
		this.responsavel = responsavel;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}
}