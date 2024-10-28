import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SistemaPessoa extends JFrame {

    public SistemaPessoa() {

        setTitle("Sistema de Pessoa");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());


        JMenuBar menuBar = new JMenuBar();
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenu menuSair = new JMenu("Sair");


        JMenuItem itemFechar = new JMenuItem("Fechar");
        menuSair.add(itemFechar);


        menuBar.add(menuCadastro);
        menuBar.add(menuVisualizacao);
        menuBar.add(menuSair);
        setJMenuBar(menuBar);


        JPanel panelCadastro = new JPanel(new GridLayout(4, 2, 10, 10));
        panelCadastro.setBorder(BorderFactory.createTitledBorder("Cadastro de Usuários"));

        JLabel labelUsuario = new JLabel("Usuário:");
        JTextField textUsuario = new JTextField();
        
        JLabel labelSenha = new JLabel("Senha:");
        JPasswordField textSenha = new JPasswordField();

        JLabel labelEmail = new JLabel("Email:");
        JTextField textEmail = new JTextField();

        JLabel labelAtivo = new JLabel("Ativo:");
        JCheckBox checkAtivo = new JCheckBox();


        panelCadastro.add(labelUsuario);
        panelCadastro.add(textUsuario);
        
        panelCadastro.add(labelSenha);
        panelCadastro.add(textSenha);
        
        panelCadastro.add(labelEmail);
        panelCadastro.add(textEmail);
        
        panelCadastro.add(labelAtivo);
        panelCadastro.add(checkAtivo);


        JPanel panelBotoes = new JPanel(new FlowLayout());


        JButton btnIncluir = new JButton("Incluir");
        JButton btnAlterar = new JButton("Alterar");
        JButton btnExcluir = new JButton("Excluir");
        JButton btnConsultar = new JButton("Consultar");
        JButton btnCancelar = new JButton("Cancelar");
        JButton btnSair = new JButton("Sair");


        panelBotoes.add(btnIncluir);
        panelBotoes.add(btnAlterar);
        panelBotoes.add(btnExcluir);
        panelBotoes.add(btnConsultar);
        panelBotoes.add(btnCancelar);
        panelBotoes.add(btnSair);


        btnIncluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão clicado! - Incluir");
            }
        });

        btnAlterar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão clicado! - Alterar");
            }
        });

        btnExcluir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão clicado! - Excluir");
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão clicado! - Consultar");
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Botão clicado! - Cancelar");
            }
        });

        btnSair.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        itemFechar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });


        add(panelCadastro, BorderLayout.CENTER);
        add(panelBotoes, BorderLayout.SOUTH);


        setVisible(true);
    }

    public static void main(String[] args) {
        new SistemaPessoa();
    }
}
