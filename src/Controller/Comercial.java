package Controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

import Model.Cliente;
import Model.Compra;
import Model.Fornecedor;
import Model.ItemCompra;
import Model.ItemVenda;
import Model.Pessoa;
import Model.Produto;
import Model.Venda;
import Model.Vendedor;
import utilitarios.Console;

public class Comercial {

	private ArrayList<Pessoa> pessoas = new ArrayList<>();
	private ArrayList<Produto> produtos = new ArrayList<>();
	private ArrayList<Compra> compras = new ArrayList<>();
	private ArrayList<Venda> vendas = new ArrayList<>();

	public ArrayList<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(ArrayList<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public ArrayList<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(ArrayList<Produto> produtos) {
		this.produtos = produtos;
	}

	public ArrayList<Compra> getCompras() {
		return compras;
	}

	public void setCompras(ArrayList<Compra> compras) {
		this.compras = compras;
	}

	public ArrayList<Venda> getVendas() {
		return vendas;
	}

	public void setVendas(ArrayList<Venda> vendas) {
		this.vendas = vendas;
	}

//metodo para inserir pessoa
	public void inserirPessoa(Pessoa pessoa) throws SisComException {
		boolean adicionar = false;
		if (pessoa instanceof Cliente) {
			for (Pessoa objpessoa : pessoas) {
				if (objpessoa instanceof Cliente) {
					if (((Cliente) objpessoa).getCpf().equals(((Cliente) pessoa).getCpf())) {
						throw new SisComException("Já existe uma pessoa com esse cpf");
					}
				}
			}
			adicionar = getPessoas().add((Cliente) pessoa);
		} else if (pessoa instanceof Fornecedor) {
			for (Pessoa objpessoa : pessoas) {
				if (objpessoa instanceof Fornecedor) {
					if (((Fornecedor) objpessoa).getCnpj().equals(((Fornecedor) pessoa).getCnpj())) {
						throw new SisComException("Já existe uma pessoa com esse cpf");
					}
				}
			}
			adicionar = getPessoas().add((Fornecedor) pessoa);
		} else if (pessoa instanceof Vendedor) {

			for (Pessoa objpessoa : pessoas) {
				if (objpessoa instanceof Vendedor) {
					if (((Vendedor) objpessoa).getCpf().equals(((Vendedor) pessoa).getCpf())) {
						throw new SisComException("Já existe uma pessoa com esse cpf");
					}
				}
			}
			adicionar = getPessoas().add((Vendedor) pessoa);
		}
		if (!adicionar) {
			throw new SisComException("Erro ao inserir pessoa");
		}
	}

//metodo para excluir uma pessoa
	public void excluirPessoa(String codigo, String identificador) throws SisComException {
		boolean remove = false;

		if (remove == false && identificador.equals("Cliente")){
			for (Venda venda : vendas) {
				if(codigo.equals(venda.getCliente().getCodigo())) {
					throw new SisComException("Erro o Cliente possui venda cadastrada!!!");
				}
			}
			remove = getPessoas().remove(buscarClientePorCPF(codigo));
		}
		if (remove == false && identificador.equals("Fornecedor")) {
			for (Compra compra : compras) {
				if(codigo.equals(compra.getFornecedor().getCodigo())) {
					throw new SisComException("Erro o Fornecedor possui Compra cadastrada!!!");
				}
			}
			remove = getPessoas().remove(buscarFornecedorPorCNPJ(codigo));
		}
		if (remove == false && identificador.equals("Vendedor")) {
			for (Venda venda : vendas) {
				if(codigo.equals(venda.getVendedor().getCodigo())) {
					throw new SisComException("Erro o Vendedor possui venda cadastrada!!!");
				}
			}
			remove = getPessoas().remove(buscarVendedorPorCPF(codigo));
		}
		if (!remove) {
			throw new SisComException("Erro ao excluir!!!");
		}
	}

//metodo para inserir uma compra ao fornecedor
	public void compras(Compra objCompra) throws SisComException {
		int num = 0;
		for (Compra compra : compras) {
			if (compra.getNumCompra() == num) {
				num++;
			} else {
				objCompra.setNumCompra(num);
			}
		}
		boolean adicionar = getCompras().add(objCompra);

		if (!adicionar) {
			throw new SisComException("Erro ao inserir compra");
		}

		for (ItemCompra item : objCompra.getCompraItens()) {
			for (Produto produto : produtos) {
				if (item.getProduto().getCodigo() == produto.getCodigo()) {
					produto.adicionarAoEstoque(item.getQuantCompra() + item.getProduto().getEstoque());
				}
			}
		}
	}

//metodo para excluir a compra do fornecedor
	public void excluirCompras(int numeroDeCompra) throws SisComException {
		boolean remove = false;
		for (Compra compra : getCompras()) {
			if (numeroDeCompra == compra.getNumCompra()) {
				remove = getCompras().remove(compra);
			}
		}
		if (!remove) {
			throw new SisComException("Erro ao excluir!!!");
		}

	}

//metodo para fazer vendas
	public void vendas(Cliente cliente, Vendedor vendedor, int formaDePagto, ArrayList<ItemVenda> vendaItens)
			throws SisComException {
		int num = 0;
		Venda venda = null;
		for (Venda vend : vendas) {
			if (vend.getNumVenda() == num) {
				num++;
			} else {
				venda = new Venda(num, cliente, vendedor, vendaItens, formaDePagto, null);
			}
		}

		boolean adicionar = getVendas().add(venda);
		if (!adicionar) {
			throw new SisComException("Erro ao inserir compra");
		}
	}
//metodo para excluir vendas
	public void excluirVendas(int numeroDeVenda) throws SisComException {
		boolean remove = false;
		for (Venda venda : getVendas()) {
			if (numeroDeVenda == venda.getNumVenda()) {
				remove = getVendas().remove(venda);
			}
		}
		if (!remove) {
			throw new SisComException("Erro ao excluir!!!");
		}

	}

//metodo para inserir produto
	public void produtos(Produto produto) throws SisComException {
		boolean adicionar = getProdutos().add(produto);
		if (produto instanceof Produto) {
			for (Produto objprod : produtos) {
				if (objprod instanceof Produto) {
					if (((Produto) objprod).getCodigo() == (((Produto) produto).getCodigo())) {
						throw new SisComException("Já existe um produto com esse codigo");
					}
				}
			}
			adicionar = getProdutos().add(produto);
		}
		if (!adicionar) {
			throw new SisComException("Erro ao inserir compra");
		}
	}

//metodo para excluir um produto
	public void excluirProdutos(int codigoProd) throws SisComException {

		Produto objProd = buscarProdutoPorCodigo(codigoProd);
		boolean remove = getProdutos().remove(objProd);
		if (!remove) {
			throw new SisComException("Erro ao excluir!!!");
		}

	}

//metodo para buscar clientes
	public Cliente buscarClientePorCPF(String cpf) throws SisComException {
		for (Pessoa cliente : getPessoas()) {
			if (cliente instanceof Cliente) {
				if (((Cliente) cliente).getCpf().contentEquals(cpf)) {
					return (Cliente) cliente;
				}

			}
		}
		throw new SisComException("Não existe pessoa para o cpf informado");
	}

//metodo para buscar um fornecedor
	public Fornecedor buscarFornecedorPorCNPJ(String cnpj) throws SisComException {
		for (Pessoa cliente : getPessoas()) {
			if (cliente instanceof Fornecedor) {
				if (((Fornecedor) cliente).getCnpj().contentEquals(cnpj)) {
					return (Fornecedor) cliente;
				}

			}
		}
		throw new SisComException("Não existe pessoa para o cnpj informado");
	}

//metodo para buscar um vendedor
	public Vendedor buscarVendedorPorCPF(String cpf) throws SisComException {
		for (Pessoa vendedor : getPessoas()) {
			if (vendedor instanceof Vendedor) {
				if (((Vendedor) vendedor).getCpf().contentEquals(cpf)) {
					return (Vendedor) vendedor;
				}
			}
		}
		throw new SisComException("Não existe pessoa para o cpf informado");
	}
//metodo para buscar um produto
	public Produto buscarProdutoPorCodigo(int codigoProd) throws SisComException {
		for (Produto produtos : getProdutos()) {
			if (codigoProd == (produtos.getCodigo())) {
				return produtos;
			}
		}
		throw new SisComException("Não existe produto para o codigo informado");

	}

//metodo para verificar se o produto esta abaixo do estoque minimo
	public boolean produtoEstoqueAbaixo(int estoque) throws SisComException {
		for (Produto produtos : getProdutos()) {
			if (estoque <= produtos.getEstoqueMinimo()) {
				return true;
			}
		}
		throw new SisComException("Estoque insuficiente");
	}
// metodo para obter estatisticas de compra do fornecedor
	public double estatisticaComprasFornecedor(String nome, int vendas, int valorTotal) throws SisComException {
		double estatistica;

		nome = Console.readLine("Digite o nome do fornecedor :");

		for (Compra compra : getCompras())
			if (nome.equals(compra.getFornecedor().getNome())) {
				vendas++;
				for (ItemCompra item : compra.getCompraItens()) {
					valorTotal += (item.getValorCompra() * item.getQuantCompra());
				}
			}
		estatistica = vendas % valorTotal;

		return estatistica;
		
	}
// metodo para obter estatisticas de vendas de vendedores
	public double estatisticaVendasVendedor(String nome, int vendas, int valorTotal) throws SisComException {

		double estatistica;

		for (Venda venda : getVendas())
			if (nome.equals(venda.getVendedor().getNome())) {
				vendas++;
				for (ItemVenda item : venda.getVendaItens()) {
					valorTotal += (item.getValorVenda() * item.getQuantVenda());
				}
			}
		estatistica = vendas % valorTotal;
		return estatistica;
	}
// metodo para obter estatisticas de vendas de clientes
	public double estatisticaVendasCliente(String nome, int vendas, int valorTotal) throws SisComException {

		double estatistica;

		for (Venda venda : getVendas())
			if (nome.equals(venda.getCliente().getNome())) {
				vendas++;
				for (ItemVenda item : venda.getVendaItens()) {
					valorTotal += (item.getValorVenda() * item.getQuantVenda());
				}
			}
		estatistica = vendas % valorTotal;

		return estatistica;
	}
// metodo para imprimir lista de vendas na ordem de fornecedor
	public void imprimirListaVendasPeriodoOrdemFornecedor(String nome, String dataInicio, String dataFim) throws SisComException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataFormatadaInicio = sdf.parse(dataInicio);
			System.out.println("Data início válida!!!");

			Date dataFormatadaFim = sdf.parse(dataFim);
			System.out.println("Data fim válida!!!");

			for (Venda vendas : getVendas()) {
				if (setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaFim) <= 0
						&& setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaInicio) >= 0) {
					for (Pessoa pessoas : getPessoas()) {
						if (!vendas.getCliente().equals(pessoas) && !vendas.getVendedor().equals(pessoas))

							System.out.println(vendas.toString());
					}
				}
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
// metodo para imprimir lista de vendas na ordem de vendedor
	public void imprimirListaVendasPeriodoOrdemVendedor(String nome, String dataInicio, String dataFim)throws SisComException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataFormatadaInicio = sdf.parse(dataInicio);
			System.out.println("Data início válida!!!");

			Date dataFormatadaFim = sdf.parse(dataFim);
			System.out.println("Data fim válida!!!");

			for (Venda vendas : getVendas()) {
				if (setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaFim) <= 0
						&& setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaInicio) >= 0) {
					for (Pessoa pessoas : getPessoas()) {
						if (vendas.getVendedor().equals(pessoas))

							System.out.println(vendas.toString());
					}
				}
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}
// metodo para imprimir lista de vendas na ordem de clientes
	public void imprimirListaVendasPeriodoOrdemCliente(String nome, String dataInicio, String dataFim) throws SisComException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			Date dataFormatadaInicio = sdf.parse(dataInicio);
			System.out.println("Data início válida!!!");

			Date dataFormatadaFim = sdf.parse(dataFim);
			System.out.println("Data fim válida!!!");

			for (Venda vendas : getVendas()) {
				if (setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaFim) <= 0
						&& setTimeToMidnight(vendas.getDataVenda()).compareTo(dataFormatadaInicio) >= 0) {
					for (Pessoa pessoas : getPessoas()) {
						if (vendas.getCliente().equals(pessoas))

							System.out.println(vendas.toString());
					}
				}
			}
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}

	}
// metodo paraimprimir todos os produtos com estoque abaixo em ordem alfabetica
	public void imprimirProdutosEstoqueAbaixoAlfa() throws SisComException {
		ArrayList<Produto> listaprod = (ArrayList<Produto>) getPessoas().clone();
		Collections.sort(listaprod, new Comparator<Produto>() {
			public int compare(Produto o1, Produto o2) {
				return o1.getNome().compareTo(o2.getNome());
			}

		});

		for (Produto i : listaprod) {
			try {
				if (produtoEstoqueAbaixo(i.getEstoque())) {
					System.out.println(i.toString());
				}
			} catch (SisComException e) {
				System.out.println(e.getMensagemErro());
			}

		}
	}
// metodo para imprimir todos os produtos em ordem alfabetica
	public void imprimirProdutosAlfabeticamente() throws SisComException {
		ArrayList<Produto> listaprod = (ArrayList<Produto>) getPessoas().clone();
		Collections.sort(listaprod, new Comparator<Produto>() {

			public int compare(Produto o1, Produto o2) {
				return o1.getNome().compareTo(o2.getNome());
			}

		});
		for (Produto i : listaprod) {
			System.out.println(i.toString());
		}

	}
// metodo para imprimir vendedores em ordem alfabetica
	public void imprimirVendedoresAlfabeticamente() throws SisComException{
		ArrayList<Vendedor> listavendedor = (ArrayList<Vendedor>) getPessoas().clone();
		Collections.sort(listavendedor, new Comparator<Vendedor>() {

			public int compare(Vendedor o1, Vendedor o2) {
				return o1.getNome().compareTo(o2.getNome());
			}

		});
		for (Vendedor i : listavendedor) {
			System.out.println(i.toString());
		}

	}
// metodo para imprimir clientes em ordem alfabetica
	public void imprimirClientesAlfabeticamente() throws SisComException {
		// Buscar Produtos por Nome
		ArrayList<Cliente> listacliente = (ArrayList<Cliente>) getPessoas().clone();
		Collections.sort(listacliente, new Comparator<Cliente>() {

			public int compare(Cliente o1, Cliente o2) {
				return o1.getNome().compareTo(o2.getNome());
			}

		});
		for (Cliente i : listacliente) {
			System.out.println(i.toString());
		}

	}
// metodo para imprimir fornecedores em ordem alfabetica
	public void imprimirFornecedoresAlfabeticamente() throws SisComException {
		ArrayList<Fornecedor> listafornecedor = (ArrayList<Fornecedor>) getPessoas().clone();
		Collections.sort(listafornecedor, new Comparator<Fornecedor>() {

			public int compare(Fornecedor o1, Fornecedor o2) {
				return o1.getNome().compareTo(o2.getNome());
			}

		});
		for (Fornecedor i : listafornecedor) {
			System.out.println(i.toString());
		}

	}
	//metodo para transformar as horas em meia noite para as pesquisas
	private static Date setTimeToMidnight(Date date) {
		Calendar calendar = Calendar.getInstance();

		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}
}