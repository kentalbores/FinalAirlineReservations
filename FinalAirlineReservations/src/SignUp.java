import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;

public class SignUp {
    private JPanel Panel1;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JPasswordField passwordField2;
    private JButton Submit;
    private JButton BackButton;

    Lists lists = new Lists();


    SignUp(){
        JFrame frame = new JFrame();
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Panel1);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");

        Submit.addActionListener(e -> {

            String username = textField1.getText();
            String pass1 = new String(passwordField1.getPassword());
            String pass2 = new String(passwordField2.getPassword());
            if (!lists.getUsernames().contains(username) && pass1.equals(pass2) && !username.equals("") && !pass1.equals("")){
                Accounts newAccount = new Accounts(username);
                lists.addToUsernames(username);
                lists.addToPasswords(pass1);
                lists.addToAccounts(newAccount);

                new LaunchPage();
                frame.dispose();
            }else if (!pass1.equals(pass2)){
                JOptionPane.showMessageDialog(null, "Passwords do not match", "title", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
}
