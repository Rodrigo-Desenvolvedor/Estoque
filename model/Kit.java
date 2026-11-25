package model;

public class Kit {
	private int id_kit;
	private String nome_kit;
	private String tipo_kit;
	private int quantidade_kits;
	
	public Kit () {}
	
	public Kit (int id_kit, String nome_kit,
				String tipo_kit, int quantidade_kits) {
		this();
		this.setId_kit(id_kit);
		this.setNome_kit(nome_kit);
		this.setTipo_kit(tipo_kit);
		this.setQuantidade_kits(quantidade_kits);
	}

	public int getId_kit() {
		return id_kit;
	}

	public void setId_kit(int id_kit) {
		this.id_kit = id_kit;
	}

	public String getNome_kit() {
		return nome_kit;
	}

	public void setNome_kit(String nome_kit) {
		this.nome_kit = nome_kit;
	}

	public String getTipo_kit() {
		return tipo_kit;
	}

	public void setTipo_kit(String tipo_kit) {
		this.tipo_kit = tipo_kit;
	}

	public int getQuantidade_kits() {
		return quantidade_kits;
	}

	public void setQuantidade_kits(int quantidade_kits) {
		this.quantidade_kits = quantidade_kits;
	}
}