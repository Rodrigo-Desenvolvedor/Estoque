package model.cadastro;

public class ModelProdutos {
	private int cod_prod;
	private String nome_prod;
	private String categoria_prod;
	private String descricao_prod;
	private String uni_med_prod;
	private int quant_prod;
	private int peso_prod;
	private double preco_prod;
	private int estoque_prod_min;
	private int estoque_prod_max;
	private String status_prod;
	
	public ModelProdutos() {}
	
	public ModelProdutos(int cod_prod, String nome_prod,
						 String categoria_prod, String descricao_prod,
						 String uni_med_prod, int quant_prod,
						 int peso_prod, double preco_prod,
						 int estoque_prod_min, int estoque_prod_max,
						 String status_prod) {
		this();
		this.setCod_prod(cod_prod);
		this.setNome_prod(nome_prod);
		this.setCategoria_prod(categoria_prod);
		this.setDescricao_prod(descricao_prod);
		this.setUni_med_prod(uni_med_prod);
		this.setQuant_prod(quant_prod);
		this.setPeso_prod(peso_prod);
		this.setPreco_prod(preco_prod);
		this.setEstoque_prod_min(estoque_prod_min);
		this.setEstoque_prod_max(estoque_prod_max);
		this.setStatus_prod(status_prod);
	}

	public int getCod_prod() {
		return cod_prod;
	}

	public void setCod_prod(int cod_prod) {
		this.cod_prod = cod_prod;
	}

	public String getNome_prod() {
		return nome_prod;
	}

	public void setNome_prod(String nome_prod) {
		this.nome_prod = nome_prod;
	}

	public String getCategoria_prod() {
		return categoria_prod;
	}

	public void setCategoria_prod(String categoria_prod) {
		this.categoria_prod = categoria_prod;
	}

	public String getDescricao_prod() {
		return descricao_prod;
	}

	public void setDescricao_prod(String descricao_prod) {
		this.descricao_prod = descricao_prod;
	}

	public String getUni_med_prod() {
		return uni_med_prod;
	}

	public void setUni_med_prod(String uni_med_prod) {
		this.uni_med_prod = uni_med_prod;
	}

	public int getQuant_prod() {
		return quant_prod;
	}

	public void setQuant_prod(int quant_prod) {
		this.quant_prod = quant_prod;
	}

	public int getPeso_prod() {
		return peso_prod;
	}

	public void setPeso_prod(int peso_prod) {
		this.peso_prod = peso_prod;
	}

	public double getPreco_prod() {
		return preco_prod;
	}

	public void setPreco_prod(double preco_prod) {
		this.preco_prod = preco_prod;
	}

	public int getEstoque_prod_min() {
		return estoque_prod_min;
	}

	public void setEstoque_prod_min(int estoque_prod_min) {
		this.estoque_prod_min = estoque_prod_min;
	}

	public int getEstoque_prod_max() {
		return estoque_prod_max;
	}

	public void setEstoque_prod_max(int estoque_prod_max) {
		this.estoque_prod_max = estoque_prod_max;
	}

	public String getStatus_prod() {
		return status_prod;
	}

	public void setStatus_prod(String status_prod) {
		this.status_prod = status_prod;
	}
}