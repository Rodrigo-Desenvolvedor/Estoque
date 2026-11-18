package model;

public class Serie {
	private int id_serie;
	private int id_produto;
	private String numero_serie;
	
	public Serie () {}
	
	public Serie (int id_serie, int id_produto, 
			      String numero_serie) {
		this();
		this.setId_serie(id_serie);
		this.setId_produto(id_produto);
		this.setNumero_serie(numero_serie);
		}

	public int getId_serie() {
		return id_serie;
	}

	public void setId_serie(int id_serie) {
		this.id_serie = id_serie;
	}

	public int getId_produto() {
		return id_produto;
	}

	public void setId_produto(int id_produto) {
		this.id_produto = id_produto;
	}

	public String getNumero_serie() {
		return numero_serie;
	}

	public void setNumero_serie(String numero_serie) {
		this.numero_serie = numero_serie;
	}
}