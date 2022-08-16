import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import javax.imageio.ImageIO;
import javax.swing.*;




public class Lotto extends JFrame implements ActionListener{
    //bootstrap-ish elements
    ClassLoader loader= this.getClass().getClassLoader();
    java.net.URL iconURL = loader.getResource("lotto.png");
    ImageIcon icon = new ImageIcon(iconURL);

    //top panel elements
    JLabel image= new JLabel(icon);

    JLabel gameTitle = new JLabel( "Lotto Numbers");
    JLabel txt = new JLabel( "");

    //buttons for bottom panel
    JButton powerBallButton = new JButton("Powerball");
    JButton megaMillionsButton = new JButton("Mega Millions");
    JButton fantasy5Button = new JButton("Fantasy 5");
    JButton lotto47Button = new JButton("Lotto 47");
    JButton luckyForLifeButton = new JButton("Lucky for Life");

    //creation of UI stuff
    JPanel imagePanel = new JPanel();
    JPanel titlePanel = new JPanel();
    JPanel topPanel = new JPanel();
    JPanel bottomPanel = new JPanel();
    JFrame frame = new JFrame();

    String newLine = "\n\n";

    public Lotto(){
        super();

        //button format
        powerBallButton.setFocusable(false);
        powerBallButton.setSize(60, 40);
        powerBallButton.addActionListener(this);

        megaMillionsButton.setFocusable(false);
        megaMillionsButton.setSize(60, 40);
        megaMillionsButton.addActionListener(this);

        fantasy5Button.setFocusable(false);
        fantasy5Button.setSize(60, 40);
        fantasy5Button.addActionListener(this);

        lotto47Button.setFocusable(false);
        lotto47Button.setSize(60, 40);
        lotto47Button.addActionListener(this);

        luckyForLifeButton.setFocusable(false);
        luckyForLifeButton.setSize(60, 40);
        luckyForLifeButton.addActionListener(this);



        //image panel
        imagePanel.setBounds(0,0,750,200);
        imagePanel.setLayout(new GridBagLayout());

        //Game title and numbers
        gameTitle.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.setBounds(0,200,750,100);
        titlePanel.setLayout(new GridBagLayout());

        txt.setFont(new Font("Arial", Font.PLAIN, 16));

        //top panel size and layout
        topPanel.setBounds(0,300,750,50);
        topPanel.setLayout(new GridBagLayout());


        //bottom panel size and layout
        bottomPanel.setBounds(0,350,750,400);
        bottomPanel.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        bottomPanel.setLayout(new GridLayout(3,3));

        //frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(760,790);
        frame.setTitle("Michigan Lottery Numbers");
        frame.setVisible(true);

        //adding elements to panels
        imagePanel.add(image);

        imagePanel.repaint();
        titlePanel.add(gameTitle);
        topPanel.add(txt);

        bottomPanel.add(powerBallButton);
        bottomPanel.add(megaMillionsButton);
        bottomPanel.add(fantasy5Button);
        bottomPanel.add(lotto47Button);
        bottomPanel.add(luckyForLifeButton);
        luckyForLifeButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        //adding panels to JFrame
        frame.add(imagePanel);
        frame.add(titlePanel);
        frame.add(topPanel);
        frame.add(bottomPanel);

    }

    String mainNumbersAndMultiplier(Integer maxArray1, Integer pick1) {
        ArrayList mainNumbers;
        mainNumbers = getNumberArray(maxArray1);
        String outputMainNumbers = getNumbers(mainNumbers, pick1);
        return outputMainNumbers;
    }
    String mainNumbersAndMultiplier(Integer maxArray1, Integer maxArray2, Integer pick1, Integer pick2) {
        ArrayList mainNumbers;
        mainNumbers = getNumberArray(maxArray1);
        String outputMainNumbers = getNumbers(mainNumbers, pick1);

        ArrayList multiplierNumber= getNumberArray(maxArray2);
        String outputMultiplierNumber = getNumbers(multiplierNumber, pick2);

        String str = outputMainNumbers + " And " + outputMultiplierNumber;
        return str;
    }

    static ArrayList getNumberArray(Integer maxNum) {
        ArrayList<Object> numberArray = new ArrayList<>();

        for(Integer i = 0; i <= maxNum; i++) {
            numberArray.add(i);
        }
        return numberArray;
    }
    String getNumbers(ArrayList numberArray, Integer num) {
        String stringOfNumbers = "";
        Collections.shuffle(numberArray);
        for (Integer i =0; i <= (num-1); i++){
            stringOfNumbers += " " + Integer.toString((Integer)numberArray.get(i)) + " ";
        }
        return stringOfNumbers;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==powerBallButton) {
            String str = mainNumbersAndMultiplier(69,26,5,1);
            txt.setText(str);
            gameTitle.setText("Power Ball");
        }
        if(e.getSource()==megaMillionsButton) {
            String str = mainNumbersAndMultiplier(70,25,5,1);
            txt.setText(str);
            gameTitle.setText("Mega Millions");
        }
        if(e.getSource()==fantasy5Button) {
            String str = mainNumbersAndMultiplier(39,5);
            txt.setText(str);
            gameTitle.setText("Fantasy 5");
        }
        if(e.getSource()==lotto47Button) {
            String str = mainNumbersAndMultiplier(47,6);
            txt.setText(str);
            gameTitle.setText("Lotto 47");
        }
        if(e.getSource()==luckyForLifeButton) {
            String str = mainNumbersAndMultiplier(48,18,5,1);
            txt.setText(str);
            gameTitle.setText("Lucky For Life");
        }
    }

    public static void main(String[] args) {

        // JButton = a button that performs an action when clicked on
        new Lotto();

    }
}