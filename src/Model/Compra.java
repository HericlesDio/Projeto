package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

public class Compra implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = -6980767262278617360L;
	private int numCompra;
	private Fornecedor fornecedor;
	private ArrayList<ItemCompra> compraItens = new ArrayList<ItemCompra>();
	private Date dataCompra;
	
	public Compra() {}

	public Compra(int numCompra, Fornecedor fornecedor, ArrayList<ItemCompra> compraItens, Date dataCompra) {
		super();
		this.numCompra = numCompra;
		this.fornecedor = fornecedor;
		this.compraItens = compraItens;
		this.dataCompra = dataCompra;
	}

	public int getNumCompra() {
		return numCompra;
	}

	public void setNumCompra(int numCompra) {
		this.numCompra = numCompra;
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public ArrayList<ItemCompra> getCompraItens() {
		return compraItens;
	}

	public void setCompraItens(ArrayList<ItemCompra> compraItens) {
		this.compraItens = compraItens;
	}

	public Date getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(Date dataCompra) {
		this.dataCompra = dataCompra;
	}

	@Override
	public String toString() {
		return "Compra [numCompra=" + numCompra + ", fornecedor=" + fornecedor + "]";
	}
	
	
	
}
