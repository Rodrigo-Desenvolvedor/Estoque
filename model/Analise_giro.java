package model;

import java.sql.Date;

public class Analise_giro {
	private int id_analise_giro;
	private int id_produto;
	private String tipo_item;
	private int vendas_periodo;
	private float estoque_medio;
	private float indice_giro;
	private String classificacao_giro;
	private Date data_calculo;
	
	public Analise_giro () {}
	
	public Analise_giro (int id_analise_giro, int id_produto,
						 String tipo_item, int vendas_periodo,
						 float estoque_medio, float indice_giro,
						 String classificacao_giro, Date data_calculo) {
		this();
		this.setId_analise_giro(id_analise_giro);
		this.setId_produto(id_produto);
		this.setTipo_item(tipo_item);
		this.setVendas_periodo(vendas_periodo);
		this.setEstoque_medio(estoque_medio);
		this.setIndice_giro(indice_giro);
		this.setClassificacao_giro(classificacao_giro);
		this.setData_calculo(data_calculo);
	}

	public int getId_analise_giro() {
		return id_analise_giro;
	}

	public void setId_analise_giro(int id_analise_giro) {
		this.id_analise_giro = id_analise_giro;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getTipo_item() {
		return tipo_item;
	}

	public void setTipo_item(String tipo_item) {
		this.tipo_item = tipo_item;
	}

	public int getVendas_periodo() {
		return vendas_periodo;
	}

	public void setVendas_periodo(int vendas_periodo) {
		this.vendas_periodo = vendas_periodo;
	}

	public float getEstoque_medio() {
		return estoque_medio;
	}

	public void setEstoque_medio(float estoque_medio) {
		this.estoque_medio = estoque_medio;
	}

	public float getIndice_giro() {
		return indice_giro;
	}

	public void setIndice_giro(float indice_giro) {
		this.indice_giro = indice_giro;
	}

	public String getClassificacao_giro() {
		return classificacao_giro;
	}

	public void setClassificacao_giro(String classificacao_giro) {
		this.classificacao_giro = classificacao_giro;
	}

	public Date getData_calculo() {
		return data_calculo;
	}

	public void setData_calculo(Date data_calculo) {
		this.data_calculo = data_calculo;
	}
}