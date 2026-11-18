package model;

public class Produto {
	private int id_produto;
	private int id_categoria;
	private String nome;
	private String descricao;
	private String unidade_medida;
	private int quantidade;
	private int estoque_minimo;
	private int estoque_maximo;
	private float peso;
	private float preco;
	private String status;
	
	public Produto () {}
	
	public Produto (int id_produto, int id_categoria,
					String nome, String descricao,
					String unidade_medida, int quantidade,
					int estoque_minimo, int estqoue_maximo,
					float peso, float preco, String status) {
		this();
		this.setId_produto(id_produto);
		this.setId_categoria(id_categoria);
		this.setNome(nome);
		this.setDescricao(descricao);
		this.setUnidade_medida(unidade_medida);
		this.setQuantidade(quantidade);
		this.setEstoque_minimo(estoque_minimo);
		this.setEstoque_maximo(estqoue_maximo);
		this.setPeso(peso);
		this.setPreco(preco);
		this.setStatus(status);
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public int getId_categoria() {
		return id_categoria;
	}

	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUnidade_medida() {
		return unidade_medida;
	}

	public void setUnidade_medida(String unidade_medida) {
		this.unidade_medida = unidade_medida;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public int getEstoque_minimo() {
		return estoque_minimo;
	}

	public void setEstoque_minimo(int estoque_minimo) {
		this.estoque_minimo = estoque_minimo;
	}

	public int getEstoque_maximo() {
		return estoque_maximo;
	}

	public void setEstoque_maximo(int estoque_maximo) {
		this.estoque_maximo = estoque_maximo;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}