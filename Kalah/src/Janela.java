import javax.swing.JButton;
import javax.swing.JFrame;

public class Janela extends JFrame {
    
    public Janela(){
        
        setVisible(true);
        setSize(800,400 );
        setTitle("Jogo Kalah");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        //botao1
        setLayout(null);
        JButton jButton = new JButton();
        jButton.setText("cava");
        jButton.setBounds(100,200,250,70);
        add(jButton);

        //botao2
        JButton jButton2 = new JButton();
        jButton2.setText("cava2");
        jButton2.setBounds(400,250,250,70);
        add(jButton2);

        

    }



}
