import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class SistemaPessoaCadastroPessoa extends JFrame {
    private JTextField nomeField, enderecoField, cidadeField, ufField, emailField, telefoneField;
    private JComboBox<String> sexoComboBox;

    public SistemaPessoaCadastroPessoa() {
        setTitle("Sistema de Pessoa");
        setLayout(new BorderLayout());

        JMenuBar menuBar = new JMenuBar();
        JMenu cadastroMenu = new JMenu("Cadastro");
        menuBar.add(cadastroMenu);
        JMenu visualizacaoMenu = new JMenu("Visualização");
        menuBar.add(visualizacaoMenu);
        JMenu sairMenu = new JMenu("Sair");
        sairMenu.addMenuListener(new javax.swing.event.MenuListener() {
            @Override
            public void menuSelected(javax.swing.event.MenuEvent e) {
                dispose();
            }
            @Override
            public void menuDeselected(javax.swing.event.MenuEvent e) {}
            @Override
            public void menuCanceled(javax.swing.event.MenuEvent e) {}
        });
        menuBar.add(sairMenu);
        setJMenuBar(menuBar);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(Color.WHITE);

        JLabel nomeLabel = new JLabel("Nome:");
        nomeLabel.setBounds(10, 10, 80, 25);
        mainPanel.add(nomeLabel);
        nomeField = new JTextField();
        nomeField.setBounds(100, 10, 200, 25);
        mainPanel.add(nomeField);

        JLabel enderecoLabel = new JLabel("Endereço:");
        enderecoLabel.setBounds(10, 40, 80, 25);
        mainPanel.add(enderecoLabel);
        enderecoField = new JTextField();
        enderecoField.setBounds(100, 40, 200, 25);
        mainPanel.add(enderecoField);

        JLabel cidadeLabel = new JLabel("Cidade:");
        cidadeLabel.setBounds(10, 70, 80, 25);
        mainPanel.add(cidadeLabel);
        cidadeField = new JTextField();
        cidadeField.setBounds(100, 70, 200, 25);
        mainPanel.add(cidadeField);

        JLabel ufLabel = new JLabel("UF:");
        ufLabel.setBounds(10, 100, 80, 25);
        mainPanel.add(ufLabel);
        ufField = new JTextField();
        ufField.setBounds(100, 100, 200, 25);
        mainPanel.add(ufField);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(10, 130, 80, 25);
        mainPanel.add(emailLabel);
        emailField = new JTextField();
        emailField.setBounds(100, 130, 200, 25);
        mainPanel.add(emailField);

        JLabel telefoneLabel = new JLabel("Telefone:");
        telefoneLabel.setBounds(10, 160, 80, 25);
        mainPanel.add(telefoneLabel);
        telefoneField = new JTextField();
        telefoneField.setBounds(100, 160, 200, 25);
        mainPanel.add(telefoneField);

        JLabel sexoLabel = new JLabel("Sexo:");
        sexoLabel.setBounds(10, 190, 80, 25);
        mainPanel.add(sexoLabel);
        String[] sexos = {"Masculino", "Feminino", "Outro"};
        sexoComboBox = new JComboBox<>(sexos);
        sexoComboBox.setBounds(100, 190, 200, 25);
        mainPanel.add(sexoComboBox);

        JButton incluirButton = new JButton("Incluir");
        incluirButton.setBounds(10, 230, 80, 25);
        incluirButton.addActionListener(new ButtonClickListener());
        mainPanel.add(incluirButton);

        JButton alterarButton = new JButton("Alterar");
        alterarButton.setBounds(100, 230, 80, 25);
        alterarButton.addActionListener(new ButtonClickListener());
        mainPanel.add(alterarButton);

        JButton excluirButton = new JButton("Excluir");
        excluirButton.setBounds(190, 230, 80, 25);
        excluirButton.addActionListener(new ButtonClickListener());
        mainPanel.add(excluirButton);

        JButton consultarButton = new JButton("Consultar");
        consultarButton.setBounds(280, 230, 90, 25);
        consultarButton.addActionListener(new ButtonClickListener());
        mainPanel.add(consultarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(380, 230, 90, 25);
        cancelarButton.addActionListener(new ButtonClickListener());
        mainPanel.add(cancelarButton);

        JButton sairButton = new JButton("Sair");
        sairButton.setBounds(480, 230, 80, 25);
        sairButton.addActionListener(e -> dispose());
        mainPanel.add(sairButton);

        add(mainPanel, BorderLayout.CENTER);

        JPanel rodapeCinza = new JPanel(new BorderLayout());
        rodapeCinza.setBackground(new Color(230, 230, 230));
        rodapeCinza.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        JLabel versaoLabel = new JLabel("Versão: 12.1.2024", JLabel.LEFT);
        JLabel usuarioLabel = new JLabel("Usuário: denys.silva", JLabel.CENTER);
        JLabel dataAcessoLabel = new JLabel("Data de acesso: 20/09/2024 10:58", JLabel.RIGHT);

        rodapeCinza.add(versaoLabel, BorderLayout.WEST);
        rodapeCinza.add(usuarioLabel, BorderLayout.CENTER);
        rodapeCinza.add(dataAcessoLabel, BorderLayout.EAST);

        add(rodapeCinza, BorderLayout.SOUTH);

        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton source = (JButton) e.getSource();
            JOptionPane.showMessageDialog(null, "Botão clicado! " + source.getText());
        }
    }

    public static void main(String[] args) {
        new SistemaPessoaCadastroPessoa();
    }
}