package Model;

import java.io.Serializable;
import java.util.Date;

public class Produto implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9017407454209216784L;
	private int codigo;
	private String nome;
	private double precoUnitario;
	private int estoque;
	private int estoqueMinimo;
	private Date dataCad;
	
	public Produto() {}

	public Produto(int codigo, String nome, double precoUnitario, int estoque, int estoqueMinimo, Date dataCad) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.precoUnitario = precoUnitario;
		this.estoque = estoque;
		this.estoqueMinimo = estoqueMinimo;
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

	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}

	public int getEstoque() {
		return estoque;
	}

	public void setEstoque(int estoque) {
		this.estoque = estoque;
	}

	public int getEstoqueMinimo() {
		return estoqueMinimo;
	}

	public void setEstoqueMinimo(int estoqueMinimo) {
		this.estoqueMinimo = estoqueMinimo;
	}

	public Date getDataCad() {
		return dataCad;
	}

	public void setDataCad(Date dataCad) {
		this.dataCad = dataCad;
	}

	public void adicionarAoEstoque(int quantidade) {	
		this.estoque += quantidade;
	}
	public int decrementarNoEstoque(int quantidade) {
		
		if(this.estoque-quantidade<0) {	
			return 0;
		}
		else {
			this.estoque-=quantidade;
			return 1;
		}
		
	}
	public void compareTo() {
	}


	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", nome=" + nome + ", precoUnitario=" + precoUnitario + ", estoque="
				+ estoque + ", estoqueMinimo=" + estoqueMinimo + "]";
	}
	
}
