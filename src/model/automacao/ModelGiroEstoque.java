package model.automacao;

public class ModelGiroEstoque {
	private String nome_item_giro_auto;
	private String tipo_giro_auto;
	private String classificacao_giro_auto;
	
	public ModelGiroEstoque() {}
	
	public ModelGiroEstoque(String nome_item_giro_auto,
							String tipo_giro_auto,
							String classificacao_giro_auto) {
		this();
		this.setNome_item_giro_auto(nome_item_giro_auto);
		this.setTipo_giro_auto(tipo_giro_auto);
		this.setClassificacao_giro_auto(classificacao_giro_auto);
	}

	public String getNome_item_giro_auto() {
		return nome_item_giro_auto;
	}

	public void setNome_item_giro_auto(String nome_item_giro_auto) {
		this.nome_item_giro_auto = nome_item_giro_auto;
	}

	public String getTipo_giro_auto() {
		return tipo_giro_auto;
	}

	public void setTipo_giro_auto(String tipo_giro_auto) {
		this.tipo_giro_auto = tipo_giro_auto;
	}

	public String getClassificacao_giro_auto() {
		return classificacao_giro_auto;
	}

	public void setClassificacao_giro_auto(String classificacao_giro_auto) {
		this.classificacao_giro_auto = classificacao_giro_auto;
	}
}