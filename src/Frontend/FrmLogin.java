package Frontend;

import java.sql.SQLException;

import javax.swing.*;

public class FrmLogin extends JFrame{

    JTextField usuario;
    JPasswordField contraseña;
    JLabel user, pass, titulo;
    JButton ingresar;

    public FrmLogin(){
        JPanel panel = new JPanel();
        panel.setBackground(new java.awt.Color(225, 225, 225));
        panel.setLayout(null);
        add(panel);

        titulo = new JLabel("Login");
        titulo.setBounds(175, 15, 100, 30);
        panel.add(titulo);

        user = new JLabel("Usuario");
        user.setBounds(100, 60, 100, 30);
        panel.add(user);
        usuario = new JTextField();
        usuario.setBounds(200, 60, 100, 30);
        panel.add(usuario);

        pass = new JLabel("Contraseña");
        pass.setBounds(90, 110, 100, 30);
        panel.add(pass);
        contraseña = new JPasswordField();
        contraseña.setBounds(200, 110, 100, 30);
        panel.add(contraseña);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(150, 160, 100, 30);
        ingresar.addActionListener(
                e -> {
                    try {
                        if (Backend.Enlistar.verificacionUsuario(usuario.getText(), new String(contraseña.getPassword()))) {
                            JOptionPane.showMessageDialog(null, "Bienvenido");
                            dispose();     
                            new FrmInicio();
                        } else {
                            JOptionPane.showMessageDialog(null, "Usuario o contraseña incorrectos");
                        }
                    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                            | SQLException e1) {
                        
                    }
                

                });
        panel.add(ingresar);

        setTitle("Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);

    }

    public static void initialize() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FrmLogin();
            }
        });
    }
}
