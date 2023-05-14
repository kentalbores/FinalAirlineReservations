import javax.swing.*;
import java.util.Arrays;

public class LaunchPage {
    private JPanel Panel1;
    private JPasswordField passwordField1;
    private JTextField textField1;
    private JButton signUpButton;
    private JButton logInButton;
    Lists lists = new Lists();
    TemporaryVariables temp = new TemporaryVariables();
    LaunchPage(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,400);
        frame.add(Panel1);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");

        signUpButton.addActionListener(e -> {
            new SignUp();
            frame.dispose();
        });
        logInButton.addActionListener(e -> {
            String username = textField1.getText();
            String pass = new String(passwordField1.getPassword());
            /*System.out.println(lists.getUsernames());
            System.out.println(lists.getPasswords());
            System.out.println("Username: "+ username);
            System.out.println(lists.getUsernames().contains(username));*/
            if (lists.getUsernames().contains(username)){
                temp.setAccountID(lists.getUsernames().indexOf(username));
                System.out.println("Account ID = " + temp.getAccountID());
                if (pass.equals(lists.getPasswords().get(temp.getAccountID()))){
                    temp.setLoggedInAccount(username);
                    new HomePage();
                    frame.dispose();
                }
            }else {
                JOptionPane.showMessageDialog(null, "Incorrect Log-in Details", "title", JOptionPane.WARNING_MESSAGE);
            }

        });

    }
}
