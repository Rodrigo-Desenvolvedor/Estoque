package model.cadastro;

public class ModelKits {
	private int cod_kit;
	private String nome_kit;
	private String tipo_kit;
	private int quant_kit;
	private String cod_prod_sku_kit;
	private String nome_prod_kit;
	private int quant_prod_kit;
	
	public ModelKits() {}
	
	public ModelKits(int cod_kit, String nome_kit,
					 String tipo_kit, int quant_kit,
					 String cod_prod_sku_kit, String nome_prod_kit,
					 int quant_prod_kit) {
		this();
		this.setCod_kit(cod_kit);
		this.setNome_kit(nome_kit);
		this.setTipo_kit(tipo_kit);
		this.setCod_prod_sku_kit(cod_prod_sku_kit);
		this.setNome_prod_kit(nome_prod_kit);
		this.setQuant_prod_kit(quant_prod_kit);
	}

	public int getCod_kit() {
		return cod_kit;
	}

	public void setCod_kit(int cod_kit) {
		this.cod_kit = cod_kit;
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

	public int getQuant_kit() {
		return quant_kit;
	}

	public void setQuant_kit(int quant_kit) {
		this.quant_kit = quant_kit;
	}

	public String getCod_prod_sku_kit() {
		return cod_prod_sku_kit;
	}

	public void setCod_prod_sku_kit(String cod_prod_sku_kit) {
		this.cod_prod_sku_kit = cod_prod_sku_kit;
	}

	public String getNome_prod_kit() {
		return nome_prod_kit;
	}

	public void setNome_prod_kit(String nome_prod_kit) {
		this.nome_prod_kit = nome_prod_kit;
	}

	public int getQuant_prod_kit() {
		return quant_prod_kit;
	}

	public void setQuant_prod_kit(int quant_prod_kit) {
		this.quant_prod_kit = quant_prod_kit;
	}
}