package model.inventario;

public class ModelInventario {
	private String nome_inv;
	private String descricao_inv;
	private String comp_quant_estoque_inv;
	private int quant_inv;
	
	public ModelInventario() {}
	
	public ModelInventario(String nome_inv, String descricao_inv,
						   String comp_quant_estoque_inv, int quant_inv) {
		this();
		this.setNome_inv(nome_inv);
		this.setDescricao_inv(descricao_inv);
		this.setComp_quant_estoque_inv(comp_quant_estoque_inv);
		this.setQuant_inv(quant_inv);
	}

	public String getNome_inv() {
		return nome_inv;
	}

	public void setNome_inv(String nome_inv) {
		this.nome_inv = nome_inv;
	}

	public String getDescricao_inv() {
		return descricao_inv;
	}

	public void setDescricao_inv(String descricao_inv) {
		this.descricao_inv = descricao_inv;
	}

	public String getComp_quant_estoque_inv() {
		return comp_quant_estoque_inv;
	}

	public void setComp_quant_estoque_inv(String comp_quant_estoque_inv) {
		this.comp_quant_estoque_inv = comp_quant_estoque_inv;
	}

	public int getQuant_inv() {
		return quant_inv;
	}

	public void setQuant_inv(int quant_inv) {
		this.quant_inv = quant_inv;
	}
}