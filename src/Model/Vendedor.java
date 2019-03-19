package Model;

import java.util.Date;

public class Vendedor extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1276158089175708639L;
	private String cpf;
	private double metaMensal;
	
	public Vendedor() {}
	
	public Vendedor(int codigo, String nome, String telefone, String email, Date dataCad, String cpf, double metaMensal) {
		super(codigo, nome, telefone, email, dataCad);
		this.cpf = cpf;
		this.metaMensal = metaMensal;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getMetaMensal() {
		return metaMensal;
	}

	public void setMetaMensal(double metaMensal) {
		this.metaMensal = metaMensal;
	}
	
	@Override
	public void tipoPessoa() {
		
	}


	@Override
	public String toString() {
		return super.toString() + "Vendedor [cpf=" + cpf + ", metaMensal=" + metaMensal + "]";
	}


	
	
	
}
