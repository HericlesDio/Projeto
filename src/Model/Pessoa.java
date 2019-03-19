package Model;

import java.io.Serializable;
import java.util.Date;

public abstract class Pessoa implements Comparable<Pessoa>, Serializable {
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public abstract void tipoPessoa();
	private int codigo;
	private String nome;
	private String telefone;
	private String email;
	private Date dataCad;
	
	public Pessoa() {}

	public Pessoa(int codigo, String nome, String telefone, String email, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.telefone = telefone;
		this.email = email;
		this.dataCad = dataCad;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public int compareTo(Pessoa obj){
		if (!nome.equals(obj.nome))
			return -1;
			else
			return 0;
			}
	
	
	
	
	@Override
	public String toString() {
		return "Pessoa [codigo=" + codigo + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email + "]";
	}
	

	
	
}
