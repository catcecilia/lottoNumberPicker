import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class UI extends JFrame implements ActionListener {
    ClassLoader loader= this.getClass().getClassLoader();;
    java.net.URL iconURL = loader.getResource("lotto.png");
    ImageIcon icon = new ImageIcon(iconURL);
    JLabel image= new JLabel(icon);
    JTextField txt = new JTextField( "", 20);
    JButton button = new JButton("Pick my numbers");
    JPanel panel = new JPanel();
    FlowLayout layout;

    public void actionPerformed(ActionEvent event) {
        if(event.getSource() == button){
            String results = Service.fiveNumbersAndMultiplier();
            txt.setText(results);
        }
    }

    public UI() {
        super("Lottery Number Picker");
        setSize(300, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        layout = new FlowLayout();
        add(image);
        add(txt);
        add(button);

        button.addActionListener(this);
        add(panel);
        setVisible(true);
        button.setVisible(true);
    }

    public static void main(String[] args){
        new UI();
    }

}

