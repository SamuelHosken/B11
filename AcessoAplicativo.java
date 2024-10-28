import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoAplicativo extends JFrame {
    private JTextField usuarioField;
    private JPasswordField senhaField;

    public AcessoAplicativo() {
        super("Acesso ao Sistema");

        // Configuração da janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 150);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Painel para os campos de texto
        JPanel painelCampos = new JPanel(new GridLayout(2, 2));
        painelCampos.add(new JLabel("Usuário:"));
        usuarioField = new JTextField();
        painelCampos.add(usuarioField);
        painelCampos.add(new JLabel("Senha:"));
        senhaField = new JPasswordField();
        painelCampos.add(senhaField);
        add(painelCampos, BorderLayout.CENTER);

        // Painel para os botões
        JPanel painelBotoes = new JPanel();
        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");
        painelBotoes.add(confirmarButton);
        painelBotoes.add(cancelarButton);
        add(painelBotoes, BorderLayout.SOUTH);

        // Ação do botão Confirmar
        confirmarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuario = usuarioField.getText();
                String senha = new String(senhaField.getPassword());

                if (usuario.equals("denys.silva") && senha.equals("Teste@2024")) {
                    JOptionPane.showMessageDialog(null, "Acesso confirmado!");
                    dispose(); // Fecha a janela
                } else {
                    JOptionPane.showMessageDialog(null, "Usuário ou senha inválido!");
                }
            }
        });

        // Ação do botão Cancelar
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose(); // Fecha a janela
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new AcessoAplicativo().setVisible(true);
            }
        });
    }
}
