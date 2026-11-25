package model;

public class Produto_kit {
	private int id_item_kit;
	private int id_kit;
	private int id_produto;
	private String sku;
	private int quantidade;
	
	public Produto_kit () {}
	
	public Produto_kit (int id_item_kit, int id_kit,
						int id_produto, String sku, int quantidade) {
		this();
		this.setId_item_kit(id_item_kit);
		this.setId_kit(id_kit);
		this.setId_produto(id_produto);
		this.setSku(sku);
		this.setQuantidade(quantidade);
	}

	public int getId_item_kit() {
		return id_item_kit;
	}

	public void setId_item_kit(int id_item_kit) {
		this.id_item_kit = id_item_kit;
	}

	public int getId_kit() {
		return id_kit;
	}

	public void setId_kit(int id_kit) {
		this.id_kit = id_kit;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
}