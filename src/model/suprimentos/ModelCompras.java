package model.suprimentos;

public class ModelCompras {
	private int id_soli_compras_supri;
	private int id_pedido_compras_supri;
	private String tipo_item_compras_supri;
	private int cod_compras_supri;
	private String fornecedor_compras_supri;
	private String situacao_compras_supri;
	
	public ModelCompras() {}
	
	public ModelCompras(int id_soli_compras_supri,
						int id_pedido_compras_supri,
						String tipo_item_compras_supri,
						int cod_compras_supri,
						String fornecedor_compras_supri,
						String situacao_compras_supri) {
		this();
		this.setId_soli_compras_supri(id_soli_compras_supri);
		this.setId_pedido_compras_supri(id_pedido_compras_supri);
		this.setTipo_item_compras_supri(tipo_item_compras_supri);
		this.setCod_compras_supri(cod_compras_supri);
		this.setFornecedor_compras_supri(fornecedor_compras_supri);
		this.setSituacao_compras_supri(situacao_compras_supri);
		
	}

	public int getId_soli_compras_supri() {
		return id_soli_compras_supri;
	}

	public void setId_soli_compras_supri(int id_soli_compras_supri) {
		this.id_soli_compras_supri = id_soli_compras_supri;
	}

	public int getId_pedido_compras_supri() {
		return id_pedido_compras_supri;
	}

	public void setId_pedido_compras_supri(int id_pedido_compras_supri) {
		this.id_pedido_compras_supri = id_pedido_compras_supri;
	}

	public String getTipo_item_compras_supri() {
		return tipo_item_compras_supri;
	}

	public void setTipo_item_compras_supri(String tipo_item_compras_supri) {
		this.tipo_item_compras_supri = tipo_item_compras_supri;
	}

	public int getCod_compras_supri() {
		return cod_compras_supri;
	}

	public void setCod_compras_supri(int cod_compras_supri) {
		this.cod_compras_supri = cod_compras_supri;
	}

	public String getFornecedor_compras_supri() {
		return fornecedor_compras_supri;
	}

	public void setFornecedor_compras_supri(String fornecedor_compras_supri) {
		this.fornecedor_compras_supri = fornecedor_compras_supri;
	}

	public String getSituacao_compras_supri() {
		return situacao_compras_supri;
	}

	public void setSituacao_compras_supri(String situacao_compras_supri) {
		this.situacao_compras_supri = situacao_compras_supri;
	}
}