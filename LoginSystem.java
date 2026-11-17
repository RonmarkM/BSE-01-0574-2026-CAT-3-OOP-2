import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginSystem extends JFrame implements ActionListener {

    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userText;
    private JPasswordField passText;
    private JButton loginButton;
    private JButton resetButton;

    // Hardcoded credentials based on the second screenshot ("WAINAINA")
    private final String VALID_USERNAME = "WAINAINA";
    private final String VALID_PASSWORD = "1234567890"; // 11 characters matching the dots in the image

    public LoginSystem() {
        // Window setup
        setTitle("Login System");
        setSize(420, 260);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centers the window on screen
        setLayout(null);

        // User Name Label and TextField
        userLabel = new JLabel("User Name");
        userLabel.setBounds(50, 45, 90, 25);
        add(userLabel);

        userText = new JTextField();
        userText.setBounds(150, 45, 190, 28);
        add(userText);

        // Password Label and PasswordField
        passLabel = new JLabel("Password");
        passLabel.setBounds(50, 95, 90, 25);
        add(passLabel);

        passText = new JPasswordField();
        passText.setBounds(150, 95, 190, 28);
        add(passText);

        // Login Button (Green)
        loginButton = new JButton("Login");
        loginButton.setBounds(65, 155, 115, 32);
        loginButton.setBackground(new Color(118, 238, 0)); // Bright green
        loginButton.setOpaque(true);
        loginButton.setBorderPainted(false); // Ensures color displays properly on macOS
        loginButton.addActionListener(this);
        add(loginButton);

        // Reset Button (Cyan)
        resetButton = new JButton("Reset");
        resetButton.setBounds(215, 155, 115, 32);
        resetButton.setBackground(new Color(102, 238, 238)); // Light cyan/aqua
        resetButton.setOpaque(true);
        resetButton.setBorderPainted(false); // Ensures color displays properly on macOS
        resetButton.addActionListener(this);
        add(resetButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String enteredUser = userText.getText();
            String enteredPass = new String(passText.getPassword());

            if (enteredUser.equals(VALID_USERNAME) && enteredPass.equals(VALID_PASSWORD)) {
                JOptionPane.showMessageDialog(
                        this,
                        "Successfully Login",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                JOptionPane.showMessageDialog(
                        this,
                        "Oops username/password is incorrect",
                        "Message",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } else if (e.getSource() == resetButton) {
            // Clears both input fields
            userText.setText("");
            passText.setText("");
        }
    }
}
