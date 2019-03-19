package Model;

import java.util.Date;

public class Cliente extends Pessoa {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5086130762149060718L;
	private String cpf;
	private double limiteCredito;
	
	public Cliente() {}
	
	public Cliente(int codigo, String nome, String telefone, String email, Date dataCad, String cpf, double limiteCredito) {
		super(codigo, nome, telefone, email, dataCad);
		this.cpf = cpf;
		this.limiteCredito = limiteCredito;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	@Override
	public void tipoPessoa() {
	}

	@Override
	public String toString() {
		return super.toString() + "Cliente [cpf=" + cpf + ", limiteCredito=" + limiteCredito + "]";
	}


	


	
	
}
