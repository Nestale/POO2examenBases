package Frontend;

import javax.swing.*;

public class FrmInicio extends JFrame{

    JLabel bienvenida;
    JButton salida;
    JPanel panel;

    public FrmInicio(){

        panel = new JPanel();
        panel.setLayout(null);
        add(panel);

        bienvenida = new JLabel("Bienvenido a la pantalla de inicio");
        bienvenida.setBounds(100, 15, 300, 30);

        salida = new JButton("Salida");
        salida.setBounds(150, 160, 100, 30);
        salida.addActionListener(
                e -> {
                    dispose();
                   });
        //Se agreegan
        panel.add(bienvenida);
        panel.add(salida);

        setTitle("Inicio");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);  }

        public static void initialize() {
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    new FrmInicio();
                }
            });
        
    }
}
