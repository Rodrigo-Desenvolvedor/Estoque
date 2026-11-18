package model;

public class Fornecedor {
	private int id_fornecedor;
	private String nome;
	private String documento;
	
	public Fornecedor () {}
	
	public Fornecedor (int id_fornecedor, String nome,
					   String documento) {
		this();
		this.setId_fornecedor(id_fornecedor);
		this.setNome(nome);
		this.setDocumento(documento);
	}

	public int getId_fornecedor() {
		return id_fornecedor;
	}

	public void setId_fornecedor(int id_fornecedor) {
		this.id_fornecedor = id_fornecedor;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}
}