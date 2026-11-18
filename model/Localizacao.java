package model;

public class Localizacao {
	private int id_localizacao;
	private String nome;
	private String descricao;
	
	public Localizacao () {}
	
	public Localizacao (int id_localizacao, String nome,
						String descricao) {
		this();
		this.setId_localizacao(id_localizacao);
		this.setNome(nome);
		this.setDescricao(descricao);
	}

	public int getId_localizacao() {
		return id_localizacao;
	}

	public void setId_localizacao(int id_localizacao) {
		this.id_localizacao = id_localizacao;
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
}