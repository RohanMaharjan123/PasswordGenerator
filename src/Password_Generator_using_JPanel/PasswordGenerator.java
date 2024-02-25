package password_generator.Password_Generator.src.src.Password_Generator_using_JPanel;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

public class PasswordGenerator extends JFrame implements ActionListener {
    private JTextField lengthField;
    private JLabel passwordLabel;
    private static JButton generateButton;

    public PasswordGenerator() {
        setLayout(new FlowLayout());
        
        passwordLabel = new JLabel("Password length:");
        //passwordLabel.setBounds(20, 20, 150, 20);
        add(passwordLabel);

        lengthField = new JTextField(5);
        //lengthField.setBounds(150, 20, 120, 20);
        add(lengthField);

        generateButton = new JButton("Generate");
        //generateButton.setBounds(160, 70, 100, 20);
        add(generateButton);
        generateButton.addActionListener(this);

        setLocationRelativeTo(rootPane);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        PasswordGenerator gui = new PasswordGenerator();
        gui.setVisible(true);
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == generateButton) {
            try{
            int length = Integer.parseInt(lengthField.getText());
            String password = generatePassword(length);
            //passwordLabel.setText("Generated Password: " + password);
            JOptionPane.showMessageDialog(null, password, "Generated Password", JOptionPane.INFORMATION_MESSAGE);
        }catch (NumberFormatException ex) {
            passwordLabel.setText("Invalid input. Please enter a valid number.");
        }
    }
}
public static String generatePassword(int length) {
    char[] validCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#%^&*()".toCharArray();
    SecureRandom random = new SecureRandom();
    char[] password = new char[length];
    for (int i = 0; i < length; i++) {
        password[i] = validCharacters[random.nextInt(validCharacters.length)];
    }
    return new String(password);
}
    /*@Override
    public void actionPerformed(ActionEvent e) {
        this.password();
        if (e.getSource() == generateButton) {
            int length = Integer.parseInt(lengthField.getText());
            String password = generatePassword(length);
            JOptionPane.showMessageDialog(null, password, "Generated Password", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void password() {
    }*/
}
