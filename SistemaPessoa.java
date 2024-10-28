import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SistemaPessoa extends JFrame {
    public SistemaPessoa() {
        super("Sistema de Pessoa");

        // Configuração da janela principal
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Criar o menu
        JMenuBar menuBar = new JMenuBar();
        
        // Menu "Cadastro"
        JMenu menuCadastro = new JMenu("Cadastro");
        JMenuItem menuUsuarios = new JMenuItem("Usuários");
        JMenuItem menuPessoas = new JMenuItem("Pessoas");
        menuCadastro.add(menuUsuarios);
        menuCadastro.add(menuPessoas);
        menuBar.add(menuCadastro);
        
        // Menu "Visualização"
        JMenu menuVisualizacao = new JMenu("Visualização");
        JMenuItem listaUsuarios = new JMenuItem("Lista de usuário");
        JMenuItem listaPessoas = new JMenuItem("Lista de Pessoas");
        menuVisualizacao.add(listaUsuarios);
        menuVisualizacao.add(listaPessoas);
        menuBar.add(menuVisualizacao);
        
        // Menu "Sair"
        JMenuItem menuSair = new JMenuItem("Sair");
        menuBar.add(menuSair);
        
        setJMenuBar(menuBar);

        // Ação do item "Sair" no menu
        menuSair.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra o programa
            }
        });

        // Rodapé com informações
        JPanel rodapePanel = new JPanel(new BorderLayout());
        rodapePanel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        
        // Configuração dos dados do rodapé
        JLabel versaoLabel = new JLabel("Versão: 12.1.2024", SwingConstants.LEFT);
        JLabel usuarioLabel = new JLabel("Usuário: denys.silva", SwingConstants.CENTER);
        JLabel dataLabel = new JLabel("Data de acesso: " + getDataAtual(), SwingConstants.RIGHT);
        
        rodapePanel.add(versaoLabel, BorderLayout.WEST);
        rodapePanel.add(usuarioLabel, BorderLayout.CENTER);
        rodapePanel.add(dataLabel, BorderLayout.EAST);
        
        add(rodapePanel, BorderLayout.SOUTH);
    }

    // Método para obter a data e hora atual formatada
    private String getDataAtual() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        return LocalDateTime.now().format(formatter);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SistemaPessoa().setVisible(true);
            }
        });
    }
}