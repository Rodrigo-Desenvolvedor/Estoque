package model.cadastro;

public class ModelVariacoes {
	
	private String nome_prod_var;
	private String sku;
	private String nome_var;
	private String tamanho_prod_var;
	private String cor_prod_var;
	private String modelo_prod_var;
	private int quantidade_prod;
	private double preco_prod_var;
	
	public ModelVariacoes() {}
	
	public ModelVariacoes(String nome_prod_var, String sku,
						  String nome_var, String tamanho_prod_var,
						  String cor_prod_var, String modelo_prod_var,
						  int quantidade_prod, double preco_prod_var) {
		this();
		this.setNome_prod_var(nome_prod_var);
		this.setSku(sku);
		this.setNome_var(nome_var);
		this.setTamanho_prod_var(tamanho_prod_var);
		this.setCor_prod_var(cor_prod_var);
		this.setModelo_prod_var(modelo_prod_var);
		this.setQuantidade_prod(quantidade_prod);
		this.setPreco_prod_var(preco_prod_var);
	}

	public String getNome_prod_var() {
		return nome_prod_var;
	}

	public void setNome_prod_var(String nome_prod_var) {
		this.nome_prod_var = nome_prod_var;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public String getNome_var() {
		return nome_var;
	}

	public void setNome_var(String nome_var) {
		this.nome_var = nome_var;
	}

	public String getTamanho_prod_var() {
		return tamanho_prod_var;
	}

	public void setTamanho_prod_var(String tamanho_prod_var) {
		this.tamanho_prod_var = tamanho_prod_var;
	}

	public String getCor_prod_var() {
		return cor_prod_var;
	}

	public void setCor_prod_var(String cor_prod_var) {
		this.cor_prod_var = cor_prod_var;
	}

	public String getModelo_prod_var() {
		return modelo_prod_var;
	}

	public void setModelo_prod_var(String modelo_prod_var) {
		this.modelo_prod_var = modelo_prod_var;
	}

	public int getQuantidade_prod() {
		return quantidade_prod;
	}

	public void setQuantidade_prod(int quantidade_prod) {
		this.quantidade_prod = quantidade_prod;
	}

	public double getPreco_prod_var() {
		return preco_prod_var;
	}

	public void setPreco_prod_var(double preco_prod_var) {
		this.preco_prod_var = preco_prod_var;
	}
}