	package View;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import Controller.Comercial;
import Controller.SisComException;
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
import utilitarios.LtpLib;

public class InterfComercial {

	private static Comercial objComercial = new Comercial();

	public static void main(String[] args) {
		// if (new File("Clientes.obj").exists()) {
		// try {
		// objComercial.setClientes(LtpLib.lerArquivoObjetosArray("Clientes.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(1);
		// }
		// }
		if (new File("Compras.obj").exists()) {
			try {
				objComercial.setCompras(LtpLib.lerArquivoObjetosArray("Compras.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(2);
			}
		}
		// if (new File("Fornecedores.obj").exists()) {
		// try {
		// objComercial.setFornecedores(LtpLib.lerArquivoObjetosArray("Fornecedores.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(3);
		// }
		// }
		if (new File("Pessoas.obj").exists()) {
			try {
				objComercial.setPessoas(LtpLib.lerArquivoObjetosArray("Pessoas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(4);
			}
		}
		if (new File("Produtos.obj").exists()) {
			try {
				objComercial.setProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(5);
			}
		}
		if (new File("Vendas.obj").exists()) {
			try {
				objComercial.setVendas(LtpLib.lerArquivoObjetosArray("Vendas.obj"));
			} catch (Exception e) {
				System.out.println(e.getMessage());
				System.exit(6);
			}
		}
		// if (new File("Vendedores.obj").exists()) {
		//
		// try {
		// objComercial.setVendedores(LtpLib.lerArquivoObjetosArray("Vendedores.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(7);
		// }
		// }
		menu();

		System.out.println("Sistema finalizado.");
		System.exit(0);
	}

	public static void menu() {
		int menu;
		do {
			System.out.println("Digite oque deseja fazer");
			menu = Console.readInt("\n1-  ler os dados armazenados em arquivo" + "\n2-  gravar os dados em arquivo"
					+ "\n3-   inserir um novo fornecedor no banco de dados"
					+ "\n4-   excluir um fornecedor do banco de dados"
					+ "\n5-   inserir um novo cliente no banco de dados" + "\n6-   excluir um cliente do banco de dados"
					+ "\n7-   inserir um novo produto no banco de dados" + "\n8-   excluir um produto do banco de dados"
					+ "\n9-   inserir um novo vendedor no banco de dados"
					+ "\n10-   excluir um vendedor do banco de dados" + "\n11-   fazer uma compra para um fornecedor"
					+ "\n12-   excluir uma compra de um fornecedor" + "\n13-   fazer uma venda para um cliente"
					+ "\n14   excluir uma venda de um cliente" + "\n15-   consultar fornecedor por cnpj"
					+ "\n16-   imprimir lista de fornecedores em ordem alfabética "
					+ "\n17-   consultar o cliente por cpf"
					+ "\n18-   imprimir lista de clientes em ordem alfabética por parte do nome do cliente"
					+ "\n19-   consultar o vendedor por cpf"
					+ "\n20-   imprimir lista de vendedores por parte do nome em ordem alfabética"
					+ "\n21-   consultar produto por código"
					+ "\n22-   imprimir lista de produtos em ordem alfabética por parte do nome do produto"
					+ "\n23-   imprimir lista de produtos com estoque abaixo do mínimo em ordem alfabética"
					+ "\n24-   imprimir lista de vendas por período em ordem de cliente e data da venda decrescente"
					+ "\n25-   imprimir lista de vendas por período em ordem de vendedor e data da venda decrescente"
					+ "\n26-   imprimir lista de compras por período em ordem de fornecedor e data da compra decrescente"
					+ "\n27-   imprimir Estatística de Vendas agrupado por cliente por período de vendas"
					+ "\n28-  imprimir Estatística de Vendas agrupado por vendedor por período de vendas"
					+ "\n29-   imprimir Estatística de Compras agrupado por fornecedor por período de compras"
					+ "\n0-Sair");
			switch (menu) {

			case 1:
				lerDadosArquivo();
				break;
			case 2:
				gravarDadosArquivo();
				break;
			case 3:
				inserirFornecedor();
				break;
			case 4:
				excluirFornecedor();
				break;
			case 5:
				inserirCliente();
				break;
			case 6:
				excluirCliente();
				break;
			case 7:
				inserirProduto();
				break;
			case 8:
				excluirProduto();
				break;
			case 9:
				inserirVendedor();
				break;
			case 10:
				excluirVendedor();
				break;
			case 11:
				fzrCompraFornecedor();
				break;
			case 12:
				excluirCompraFornecedor();
				break;
			case 13:
				fzrVendaCliente();
				break;
			case 14:
				excluirVendaCliente();
				break;
			case 15:
				consultarFornecedorPorCNPJ();
				break;
			case 16:
				imprimirFornecedoresAlfabeticamente();
				break;
			case 17:
				consultarClientePorCPF();
				break;
			case 18:
				imprimirClientesAlfabeticamente();
				break;
			case 19:
				consultarVendedorPorCPF();
				break;
			case 20:
				imprimirVendedoresAlfabeticamente();
				break;
			case 21:
				consultarProdutoPorCodigo();
				break;
			case 22:
				imprimirProdutosAlfabeticamente();
				break;
			case 23:
				imprimirProdutosEstoqueAbaixoAlfa();
				break;
			case 24:
				imprimirListaVendasPeriodoOrdemCliente();
				break;
			case 25:
				imprimirListaVendasPeriodoOrdemVendedor();
				break;
			case 26:
				imprimirListaVendasPeriodoOrdemFornecedor();
				break;
			case 27:
				imprimirEstatisticaVendasCliente();
				break;
			case 28:
				imprimirEstatisticaVendasVendedor();
				break;
			case 29:
				imprimirEstatisticaComprasFornecedor();
				break;
			case 0:
				break;
			default:
				System.out.println("Opção errada");
				break;
			}
		} while (menu != 0);
	}

//metodo para imprimir estatisticas de compra do fornecedor
	private static void imprimirEstatisticaComprasFornecedor() {
		double estatistica = 0 ;
		String nome = Console.readLine("nome: ");
		try {
			estatistica = (objComercial.estatisticaComprasFornecedor(nome, 0, 0));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("A estatistica de vendas do fornecedor " + nome + " é: " + estatistica);

	}
//metodo para imprimir estatisticas de vendas de vendedores
	private static void imprimirEstatisticaVendasVendedor() {
		double estatistica = 0 ;
		String nome = Console.readLine("nome: ");

		try {
			estatistica = (objComercial.estatisticaVendasVendedor(nome, 0, 0));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("A estatistica de vendas do fornecedor " + nome + " é: " + estatistica);

	}
//metodo para imprimir estatisticas de vendas de clientes
	private static void imprimirEstatisticaVendasCliente() {
		double estatistica = 0 ;
		String nome = Console.readLine("nome: ");

		try {
			estatistica = (objComercial.estatisticaVendasCliente(nome, 0, 0));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
		
		System.out.println("A estatistica de vendas do fornecedor " + nome + " é: " + estatistica);

	}
//metodo para imprimir lista de vendas na ordem de fornecedor
	private static void imprimirListaVendasPeriodoOrdemFornecedor() {
		
		try {
			objComercial.imprimirListaVendasPeriodoOrdemFornecedor(Console.readLine("Nome: "), Console.readLine("Data início: "), Console.readLine("Data fim: "));
		} catch (SisComException e) {
		}
	}
//metodo para imprimir lista de vendas na ordem de vendedor
	private static void imprimirListaVendasPeriodoOrdemVendedor() {
		try {
			objComercial.imprimirListaVendasPeriodoOrdemVendedor(Console.readLine("Nome: "), Console.readLine("Data início: "), Console.readLine("Data fim: "));
		} catch (SisComException e) {
		}
	}
//metodo para imprimir lista de vendas na ordem de clientes
	private static void imprimirListaVendasPeriodoOrdemCliente() {
		try {
			objComercial.imprimirListaVendasPeriodoOrdemCliente(Console.readLine("Nome: "), Console.readLine("Data início: "), Console.readLine("Data fim: "));
		} catch (SisComException e) {
		}

	}
//metodo paraimprimir todos os produtos com estoque abaixo em ordem alfabetica
	private static void imprimirProdutosEstoqueAbaixoAlfa() {
		try {
			objComercial.imprimirProdutosEstoqueAbaixoAlfa();
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para imprimir todos os produtos em ordem alfabetica
	private static void imprimirProdutosAlfabeticamente() {
		try {
			objComercial.imprimirProdutosAlfabeticamente();
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para consultar produto por codigo
	private static void consultarProdutoPorCodigo() {
		System.out.println("\nConsultar Produto");
		try {
			System.out.println(objComercial.buscarProdutoPorCodigo(Console.readInt("Codigo Produto: ")));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para imprimir vendedores em ordem alfabetica
	private static void imprimirVendedoresAlfabeticamente() {
		try {
			objComercial.imprimirVendedoresAlfabeticamente();
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para consultar vendedores
	private static void consultarVendedorPorCPF() {
		System.out.println("\nConsultar Vendedor");
		try {
			System.out.println(objComercial.buscarVendedorPorCPF(Console.readLine("Cpf: ")));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para imprimir clientes em ordem alfabetica
	private static void imprimirClientesAlfabeticamente() {
		try {
			objComercial.imprimirClientesAlfabeticamente();
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para consultar clientes
	private static void consultarClientePorCPF() {
		System.out.println("\nConsultar Cliente");
		try {
			System.out.println(objComercial.buscarClientePorCPF(Console.readLine("Cpf: ")));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para imprimir fornecedores em ordem alfabetica
	private static void imprimirFornecedoresAlfabeticamente() {
		try {
			objComercial.imprimirFornecedoresAlfabeticamente();
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para consultar fornecedores
	private static void consultarFornecedorPorCNPJ() {
		System.out.println("\nConsultar Fornecedor");
		try {

			System.out.println(objComercial.buscarFornecedorPorCNPJ(Console.readLine("Cnpj: ")));
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para excluir uma venda
	private static void excluirVendaCliente() {
		System.out.println("\nExcluir Venda");
		try {
			objComercial.excluirVendas(Console.readInt("Numero da Venda: "));
			System.out.println("Venda excluida com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	
	}
//metodo para fazer uma venda ao cliente
	private static void fzrVendaCliente() {
		System.out.println("fazer venda");
		String cpf = null;
		int codigoProduto;
		int formaDePagamento;
		String cpfVend;
		int quantVenda;
		int valorVenda;
		Date datavenda = new Date();
		Pessoa cliente = null;
		Pessoa vendedor = null;
		Produto produto = null;

		try {
		cliente = objComercial.buscarClientePorCPF(cpf = Console.readLine("Digite o cpf do cliente: "));
		vendedor = objComercial.buscarVendedorPorCPF(cpfVend = Console.readLine("Digite o Cpf do vendedor: "));
		produto = objComercial.buscarProdutoPorCodigo(codigoProduto = Console.readInt("Digite o codigo do produto: "));
		}catch(SisComException e) {
			System.out.println(e.getMensagemErro());
		}
		quantVenda = Console.readInt("Digite a quantidade de venda: ");

		do {
			formaDePagamento = Console.readInt("Digite a forma de pagamento");

			if (formaDePagamento != 1 && formaDePagamento != 2) {
				System.out.println("So tem 2 formas de pagamento 1 a vista e 2 a prazo");

			}

		} while (formaDePagamento != 1 && formaDePagamento != 2);
		if (((Cliente) cliente).getLimiteCredito() < quantVenda * produto.getPrecoUnitario()) {
			System.out.println("A venda não pode passa o limite de credito do cliente");
			return;

		}

		ItemVenda itemvenda = new ItemVenda(produto, quantVenda, quantVenda * produto.getPrecoUnitario());
		Venda vendas;
		ArrayList<ItemVenda> lista = new ArrayList<ItemVenda>();
		lista.add(itemvenda);
		vendas = new Venda(0, ((Cliente) cliente), ((Vendedor) vendedor), lista, formaDePagamento,
				datavenda);
		
		
		if(produto.decrementarNoEstoque(quantVenda) == 0) {
			System.out.println("Estoque insuficiente");
		}else {
			produto.decrementarNoEstoque(quantVenda);
		}
		
		for (Venda venda : objComercial.getVendas()) {

			if (cpf.equals(venda.getVendedor().getCpf())) {

				for (ItemVenda item : venda.getVendaItens()) {
					if (produto.getCodigo() == item.getProduto().getCodigo()) {

						System.out.println("O vendedor ja tinha vendido esse item");
						produto.decrementarNoEstoque(quantVenda);
						item.setQuantVenda(item.getQuantVenda() + quantVenda);
						item.setValorVenda(item.getValorVenda() + (quantVenda * item.getProduto().getPrecoUnitario()));

					}

				}

			}

		}

		try {
			objComercial.vendas(((Cliente) cliente), ((Vendedor) vendedor), formaDePagamento, lista);
		} catch (SisComException e) {
			System.out.println(e.getMensagemErro());
		}

	}
//metodo para excluir uma compra de fornecedor
	private static void excluirCompraFornecedor() {
		System.out.println("\nExcluir Compra");
		try {
			objComercial.excluirCompras(Console.readInt("Numero da Compra: "));
			System.out.println("Compra excluida com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para fazer compra do fornecedor
	private static void fzrCompraFornecedor() {
		System.out.println("Compra de fornecedor");
		Compra objCompra = new Compra();
		ArrayList<ItemCompra> listaDeCompras = new ArrayList<>();
		ItemCompra objitem = new ItemCompra();

		int opcao;
		do {
			System.out.println("1 - Adicionar itens a lista" + "\n2 - Selecionar fornecedor");
			opcao = Console.readInt("Escolha uma opção:");

			switch (opcao) {
			case 1:
				imprimirProdutosAlfabeticamente();
				try {
					Produto produto = objComercial.buscarProdutoPorCodigo(Console.readInt("Codigo: "));
					objitem.setProduto(produto);
					objitem.setQuantCompra(Console.readInt("Quantidade:"));
					objitem.setValorCompra(produto.getPrecoUnitario() * objitem.getQuantCompra());
				} catch (SisComException e) {
					System.out.println(e.getMensagemErro());
				}
				boolean adicionar = listaDeCompras.add(objitem);
				if (!adicionar) {
					System.out.println("Erro ao adicionar");
				}
				break;
			case 2:
				break;

			default:
				System.out.println("Opção invalida");
				break;
			}
		} while (opcao != 2);

		objCompra.setCompraItens(listaDeCompras);
		objCompra.setDataCompra(new Date());

		try {
			objCompra.setFornecedor((Fornecedor) objComercial.buscarFornecedorPorCNPJ(Console.readLine("Cnpj: ")));
			try {
				objComercial.compras(objCompra);
			} catch (SisComException e) {
				System.out.println(e.getMensagemErro());
			}
		} catch (SisComException e) {
			System.out.println(e.getMensagemErro());
		}

	}
//metodo para excluir um vendedor
	private static void excluirVendedor() {
		System.out.println("\nExcluir Vendedor");
		try {
			objComercial.excluirPessoa(Console.readLine("Cpf: "), "Vendedor");
			System.out.println("Vendedor excluido com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para inserir um vendedor
	private static void inserirVendedor() {
		try {

			System.out.println("Cadastro Vendedor");

			int codigo;
			String nome;
			String telefone;
			String email;
			String dataCadSTR;
			Date dataCad = null;
			String cpf;
			double metaMensal;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			codigo = Console.readInt("Codigo:");
			nome = Console.readLine("nome:");
			telefone = Console.readLine("Telefone:");
			email = Console.readLine("Email:");
			cpf = Console.readLine("CPF:");
			metaMensal = Console.readDouble("Meta mensal:");
			dataCadSTR = Console.readLine("Data de cadastro DD/MM/AAAA");

			try {
				dataCad = sdf.parse(dataCadSTR);
				System.out.println("Data valida");

			} catch (Exception e) {
				System.out.println("Data inválida!!!");
				System.out.println(e.getMessage());
			}
			Vendedor vendedores = new Vendedor(codigo, nome, telefone, email, dataCad, cpf, metaMensal);

			objComercial.inserirPessoa(vendedores);

			System.out.println("Cadastro realizado com sucesso");

		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para excluir um produto
	private static void excluirProduto() {
		System.out.println("\nExcluir Produto");
		try {
			objComercial.excluirProdutos(Console.readInt("Codigo Produto: "));
			System.out.println("Produto excluido com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para inserir um produto
	private static void inserirProduto() {
		try {

			System.out.println("Produto");

			int codigo;
			String nome;
			double precoUnitario;
			int estoque;
			int estoqueMinimo;
			String dataCadSTR;
			Date dataCad = null;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			codigo = Console.readInt("Codigo:");
			nome = Console.readLine("nome:");
			precoUnitario = Console.readDouble("Preço unitario:");
			estoque = Console.readInt("Estoque:");
			estoqueMinimo = Console.readInt("estoque minimo:");
			dataCadSTR = Console.readLine("Data de cadastro DD/MM/AAAA");

			try {
				dataCad = sdf.parse(dataCadSTR);
				System.out.println("Data valida");

			} catch (Exception e) {
				System.out.println("Data inválida!!!");
				System.out.println(e.getMessage());
			}
			Produto produtos = new Produto(codigo, nome, precoUnitario, estoque, estoqueMinimo, dataCad);

			objComercial.produtos(produtos);

			System.out.println("Cadastro realizado com sucesso");

		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para excluir um cliente
	private static void excluirCliente() {
		System.out.println("\nExcluir Cliente");
		try {
			objComercial.excluirPessoa(Console.readLine("Cpf: "), "Cliente");
			System.out.println("Cliente excluido com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para inserir um cliente
	private static void inserirCliente() {
		try {

			System.out.println("Cadastro Cliente");

			int codigo;
			String nome;
			String telefone;
			String email;
			String dataCadSTR;
			Date dataCad = null;
			String cpf;
			double limiteCredito;

			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			codigo = Console.readInt("Codigo:");
			nome = Console.readLine("nome:");
			telefone = Console.readLine("Telefone:");
			email = Console.readLine("Email:");
			cpf = Console.readLine("CPF:");
			limiteCredito = Console.readDouble("Limite de credito:");
			dataCadSTR = Console.readLine("Data de cadastro DD/MM/AAAA");

			try {
				dataCad = sdf.parse(dataCadSTR);
				System.out.println("Data valida");

			} catch (Exception e) {
				System.out.println("Data inválida!!!");
				System.out.println(e.getMessage());
			}
			Cliente clientes = new Cliente(codigo, nome, telefone, email, dataCad, cpf, limiteCredito);

			objComercial.inserirPessoa(clientes);

			System.out.println("Cadastro realizado com sucesso");

		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para excluir um fornecedor
	private static void excluirFornecedor() {
		System.out.println("\nExcluir Fornecedor");
		try {
			objComercial.excluirPessoa(Console.readLine("Cnpj: "), "Fornecedor");
			System.out.println("Fornecedor excluido com sucesso");
		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}

	}
//metodo para inserir um fornecedor
	private static void inserirFornecedor() {

		try {

			System.out.println("Cadastro Fornecedor");

			int codigo;
			String nome;
			String telefone;
			String email;
			String dataCadSTR;
			String cnpj;
			String nomeContato;
			Date dataCad = null;
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

			codigo = Console.readInt("Codigo:");
			nome = Console.readLine("nome:");
			telefone = Console.readLine("Telefone:");
			email = Console.readLine("Email:");
			cnpj = Console.readLine("CNPJ:");
			nomeContato = Console.readLine("Nome do contrato:");
			dataCadSTR = Console.readLine("Data de cadastro DD/MM/AAAA");

			try {
				dataCad = sdf.parse(dataCadSTR);
				System.out.println("Data valida");

			} catch (Exception e) {
				System.out.println("Data inválida!!!");
				System.out.println(e.getMessage());
			}
			Fornecedor fornecedores = new Fornecedor(codigo, nome, telefone, email, dataCad, cnpj, nomeContato);

			objComercial.inserirPessoa(fornecedores);

			System.out.println("Cadastro realizado com sucesso");

		} catch (SisComException e) {
			System.out.println(e.getMessage());
		}
	}
//metodo para gravar dados
	private static void gravarDadosArquivo() {
		// try {
		// LtpLib.gravarArquivoObjetosArray("Clientes.obj", objComercial.getClientes());
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(8);
		// }

		try {
			LtpLib.gravarArquivoObjetosArray("Compras.obj", objComercial.getCompras());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(9);
		}
		// try {
		// LtpLib.gravarArquivoObjetosArray("Fornecedores.obj",
		// objComercial.getFornecedores());
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(10);
		// }
		try {
			LtpLib.gravarArquivoObjetosArray("Pessoas.obj", objComercial.getPessoas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(11);
		}
		try {
			LtpLib.gravarArquivoObjetosArray("Produtos.obj", objComercial.getProdutos());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(12);
		}
		try {
			LtpLib.gravarArquivoObjetosArray("Vendas.obj", objComercial.getVendas());
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(13);
		}
		// try {
		// LtpLib.gravarArquivoObjetosArray("Vendedores.obj",
		// objComercial.getVendedores());
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(14);
		// }

	}
//metodo para ler dados gravados
	private static void lerDadosArquivo() {
		// try {
		// objComercial.setClientes(LtpLib.lerArquivoObjetosArray("Clientes.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(1);
		// }

		try {
			objComercial.setCompras(LtpLib.lerArquivoObjetosArray("Compras.obj"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(2);
		}

		// try {
		// objComercial.setFornecedores(LtpLib.lerArquivoObjetosArray("Fornecedores.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(3);
		// }

		// try {
		// objComercial.setPessoas(LtpLib.lerArquivoObjetosArray("Pessoas.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(4);
		// }

		try {
			objComercial.setProdutos(LtpLib.lerArquivoObjetosArray("Produtos.obj"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(5);
		}

		try {
			objComercial.setVendas(LtpLib.lerArquivoObjetosArray("Vendas.obj"));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(6);
		}

		// try {
		// objComercial.setVendedores(LtpLib.lerArquivoObjetosArray("Vendedores.obj"));
		// } catch (Exception e) {
		// System.out.println(e.getMessage());
		// System.exit(7);
		// }

	}
}