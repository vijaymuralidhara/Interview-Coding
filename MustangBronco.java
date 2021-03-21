import javax.swing.*;
import java.awt.event.*;
import java.awt.Font;

public class MustangBronco implements ActionListener {
    
    private static JLabel succ;
    private static JTextField usetext;
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        panel.setLayout(null);
        Font verd = new Font("Verdana", Font.PLAIN, 17);
        setFrame(frame);
        frame.add(panel);
        setLabels(verd, panel);
        setText();
        panel.add(usetext);
        setButton(panel);
        outText(verd);
        panel.add(succ);
        frame.setResizable(false);
        frame.setVisible(true);
    }

    public static void setFrame(JFrame frame) {     // Creates frame and title for GUI
        frame.setTitle("Mustang-Bronco GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setSize(450, 300);
    }

    public static void setLabels(Font verd, JPanel panel) {     // Sets GUI text
        JLabel label = new JLabel("Enter an integer:");
        label.setFont(new Font("Verdana", Font.PLAIN, 15));
        label.setBounds(20, 150, 200, 25);
        JLabel reslabel = new JLabel("Result:");
        reslabel.setBounds(80, 70, 100, 25);
        reslabel.setFont(verd);
        panel.add(label);
        panel.add(reslabel);
    }

    public static void setText() {      // Creates text box for user input
        usetext = new JTextField(50);
        usetext.setBounds(150, 150, 165, 25);
    }

    public static void setButton(JPanel panel) {    // Creates button for user to run program
        JButton button = new JButton("Run");
        button.setBounds(150, 200, 165, 25);
        button.addActionListener(new MustangBronco());
        panel.add(button);
    }

    public static void outText(Font verd) {     // Sets output text
        succ = new JLabel("");
        succ.setBounds(150, 70, 300, 25);
        succ.setFont(verd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {    // Handles all logic for user input
        int count = 0;
        int tries = Integer.MAX_VALUE;
        try{
            String input = usetext.getText();
            input = input.replace(" ", "");
            Long in = Long.parseLong(input);
            if (in % 3 == 0 && in % 5 == 0) {
                succ.setText("MustangBronco");
            } else if (in % 3 == 0) {
                succ.setText("Mustang");
            } else if (in % 5 == 0) {
                succ.setText("Bronco");
            } else {
                succ.setText(String.valueOf(in));
            }
        } catch (NumberFormatException err) {
            succ.setText("Please enter an integer!");
            if (++count == tries) throw err;
        }
    }
}