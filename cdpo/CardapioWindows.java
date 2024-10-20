package cdpo;
import java.awt.*;
import javax.swing.*;

public class CardapioWindows extends JFrame {
    private static final int LIM_REG = 100;
    private static String[][] produtos = new String[LIM_REG][4];
    private static String[][] clientes = new String[LIM_REG][10];
    private static int totalProdutos = 0;
    private static int totalClientes = 0;

    public CardapioWindows() {
        setTitle("Sistema de Cardapio PitDog");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Centralizando o menu
        JPanel menuPanel = new JPanel(new GridBagLayout());
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");

        JMenuItem cadastrarProduto = new JMenuItem("Cadastro de Produtos");
        JMenuItem cadastrarCliente = new JMenuItem("Cadastro de Clientes");
        JMenuItem exibirCardapio = new JMenuItem("Exibir Cardapio");

        menu.add(cadastrarProduto);
        menu.add(cadastrarCliente);
        menu.add(exibirCardapio);
        menuBar.add(menu);

        // Colocando o menu no centro da tela
        menuPanel.add(menuBar);
        setContentPane(menuPanel);

        cadastrarProduto.addActionListener(e -> abrirTelaCadastroProduto());
        cadastrarCliente.addActionListener(e -> abrirTelaCadastroCliente());
        exibirCardapio.addActionListener(e -> exibirCardapio());
    }

    private void abrirTelaCadastroProduto() {
        JFrame cadastroProdutoFrame = new JFrame("Cadastro de Produtos");
        cadastroProdutoFrame.setSize(400, 400);
        JPanel panel = new JPanel(new GridLayout(10, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        JLabel labelCodigo = new JLabel("Codigo (modelo: ABC123):");
        JTextField campoCodigo = new JTextField(6);

        JLabel labelProduto = new JLabel("Produto (min 3, max 60 caracteres):");
        JTextField campoProduto = new JTextField(60);

        JLabel labelPreco = new JLabel("Preco (modelo: 0.00):");
        JTextField campoPreco = new JTextField(6);

        JLabel labelAtivo = new JLabel("Ativo (selecione se estiver ativo):");
        JCheckBox checkBoxAtivo = new JCheckBox();

        JButton botaoSalvar = new JButton("Salvar");

        panel.add(labelCodigo);
        panel.add(campoCodigo);
        panel.add(labelProduto);
        panel.add(campoProduto);
        panel.add(labelPreco);
        panel.add(campoPreco);
        panel.add(labelAtivo);
        panel.add(checkBoxAtivo);
        panel.add(new JLabel());
        panel.add(botaoSalvar);

        botaoSalvar.addActionListener(e -> {
            if (totalProdutos >= LIM_REG) {
                JOptionPane.showMessageDialog(null, "Cadastro de produtos cheio.");
                return;
            }
            String codigo = campoCodigo.getText().toUpperCase();
            String produto = campoProduto.getText().toUpperCase();
            String preco = campoPreco.getText();
            String ativo = checkBoxAtivo.isSelected() ? "TRUE" : "FALSE";

            if (codigo.length() == 6 && produto.length() >= 3 && produto.length() <= 60) {
                produtos[totalProdutos++] = new String[]{codigo, produto, ativo, preco};
                JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
                cadastroProdutoFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados invalidos. Verifique os campos.");
            }
        });

        cadastroProdutoFrame.add(panel);
        cadastroProdutoFrame.setVisible(true);
    }

    private void abrirTelaCadastroCliente() {
        JFrame cadastroClienteFrame = new JFrame("Cadastro de Clientes");
        cadastroClienteFrame.setSize(400, 600);
        JPanel panel = new JPanel(new GridLayout(16, 1));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Padding

        JLabel labelNome = new JLabel("Nome completo (min 6, max 60 caracteres):");
        JTextField campoNome = new JTextField(60);

        JLabel labelLogradouro = new JLabel("Logradouro (ex: Rua Exemplo):");
        JTextField campoLogradouro = new JTextField(60);

        JLabel labelNumero = new JLabel("Numero (ex: 1234):");
        JTextField campoNumero = new JTextField(4);

        JLabel labelComplemento = new JLabel("Complemento (opcional):");
        JTextField campoComplemento = new JTextField(60);

        JLabel labelBairro = new JLabel("Bairro (ex: Centro):");
        JTextField campoBairro = new JTextField(60);

        JLabel labelCidade = new JLabel("Cidade (ex: Sao Paulo):");
        JTextField campoCidade = new JTextField(60);

        JLabel labelCEP = new JLabel("CEP (modelo: 99999-999):");
        JTextField campoCEP = new JTextField(8);

        JButton botaoSalvarCliente = new JButton("Salvar");

        panel.add(labelNome);
        panel.add(campoNome);
        panel.add(labelLogradouro);
        panel.add(campoLogradouro);
        panel.add(labelNumero);
        panel.add(campoNumero);
        panel.add(labelComplemento);
        panel.add(campoComplemento);
        panel.add(labelBairro);
        panel.add(campoBairro);
        panel.add(labelCidade);
        panel.add(campoCidade);
        panel.add(labelCEP);
        panel.add(campoCEP);
        panel.add(new JLabel());
        panel.add(botaoSalvarCliente);

        botaoSalvarCliente.addActionListener(e -> {
            if (totalClientes >= LIM_REG) {
                JOptionPane.showMessageDialog(null, "Cadastro de clientes cheio.");
                return;
            }
            String nome = campoNome.getText().toUpperCase();
            String logradouro = campoLogradouro.getText().toUpperCase();
            String numero = campoNumero.getText();
            String complemento = campoComplemento.getText();
            String bairro = campoBairro.getText();
            String cidade = campoCidade.getText();
            String cep = campoCEP.getText();

            if (nome.length() >= 6 && nome.length() <= 60) {
                clientes[totalClientes++] = new String[]{nome, logradouro, numero, complemento, bairro, cidade, cep};
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                cadastroClienteFrame.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Dados invalidos. Verifique os campos.");
            }
        });

        cadastroClienteFrame.add(panel);
        cadastroClienteFrame.setVisible(true);
    }

    private void exibirCardapio() {
        JFrame cardapioFrame = new JFrame("Cardapio");
        cardapioFrame.setSize(400, 300);
        JTextArea areaCardapio = new JTextArea();
        areaCardapio.setEditable(false);

        StringBuilder sb = new StringBuilder();
        sb.append("CODIGO\tPRODUTO\t\tPRECO\n");
        for (int i = 0; i < totalProdutos; i++) {
            if (produtos[i][2].equals("TRUE")) {
                sb.append(produtos[i][0]).append("\t").append(produtos[i][1]).append("\t\t").append(produtos[i][3]).append("\n");
            }
        }
        areaCardapio.setText(sb.toString());

        JScrollPane scrollPane = new JScrollPane(areaCardapio);
        cardapioFrame.add(scrollPane);
        cardapioFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            CardapioWindows tela = new CardapioWindows();
            tela.setVisible(true);
        });
    }
}
