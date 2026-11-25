package model;

public class Variacao {
	private String sku;
	private int id_produto;
	private String nome_variacao;
	private String tamanho;
	private String cor;
	private String modelo;
	private int quantidade;
	private float preco;
	
	public Variacao () {}
	
	public Variacao (String sku, int id_produto,
					 String nome_variacao, String tamanho,
					 String cor, String modelo,
					 int quantidade, float preco) {
		this();
		this.setSku(sku);
		this.setId_produto(id_produto);
		this.setNome_variacao(nome_variacao);
		this.setTamanho(tamanho);
		this.setCor(cor);
		this.setModelo(modelo);
		this.setQuantidade(quantidade);
		this.setPreco(preco);
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNome_variacao() {
		return nome_variacao;
	}

	public void setNome_variacao(String nome_variacao) {
		this.nome_variacao = nome_variacao;
	}

	public String getTamanho() {
		return tamanho;
	}

	public void setTamanho(String tamanho) {
		this.tamanho = tamanho;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}