package Model;

import java.util.Date;

public class Fornecedor extends Pessoa {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 537533284069507337L;
	private String cnpj;
	private String nomeContato;
	
	public Fornecedor() {}

	public Fornecedor(int codigo, String nome, String telefone, String email, Date dataCad, String cnpj, String nomeContato) {
		super(codigo, nome, telefone, email, dataCad);
		this.cnpj = cnpj;
		this.nomeContato = nomeContato;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getNomeContato() {
		return nomeContato;
	}

	public void setNomeContato(String nomeContato) {
		this.nomeContato = nomeContato;
	}
	
	@Override
	public void tipoPessoa() {
		
	}

	@Override
	public String toString() {
		return super.toString() + "Fornecedor [cnpj=" + cnpj + ", nomeContato=" + nomeContato + "]";
	}

	
	
	
	
}
