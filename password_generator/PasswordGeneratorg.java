package password_generator.Password_Generator.src.password_generator;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class PasswordGeneratorg extends JFrame implements ActionListener {
    private JTextField lengthField;
    private JLabel passwordLabel;
    private JButton generateButton;
    /**
     * 
     */
    public PasswordGeneratorg() {
        super("Password Generator");
        setLayout(new FlowLayout());
        
        passwordLabel = new JLabel("Password Length");
        //passwordLabel.setBounds(20, 20, 150, 20);
        add(passwordLabel);
         
        lengthField = new JTextField(5);
        //lengthField.setBounds(250, 20, 120, 20);
        add(lengthField);

        generateButton = new JButton("Generate");
        //generateButton.setBounds(20, 20, 100, 20);
        generateButton.addActionListener(this);
        add(generateButton);
        
        setLocationRelativeTo(rootPane);
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        new PasswordGeneratorg();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
            if (e.getSource() == generateButton) {  
                try {
                int length = Integer.parseInt(lengthField.getText());
                String password = generatePassword(length);
                passwordLabel.setText("Generated Password: " + password);
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
}

