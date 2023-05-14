import javax.swing.*;

public class HomePage {
    private JPanel Panel1;
    private JPanel DisplayPanel;
    private JButton addReservationsButton;
    private JButton SignOutButton;
    private JTextPane textPane1;
    private JLabel helloUserLabel;
    TemporaryVariables temp = new TemporaryVariables();
    Lists list = new Lists();
    String contentText = "";

    HomePage(){
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(400,500);
        frame.add(Panel1);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");


        helloUserLabel.setText("Hello! "+ temp.getLoggedInAccount());
        int j = 0;
        for (String i : list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation()){
            contentText = contentText.concat("\nDestination: " + i +
                    "\nTime: \t" + list.getAccounts().get(temp.getAccountID()).getThisAccountsTime().get(j) +
                    "\nCost: " + list.getAccounts().get(temp.getAccountID()).getThisAccountsCosts().get(j) +
                    "\nSeat: " + list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().get(j) + "\n");
            j++;
        }
        textPane1.setText(contentText);
        DisplayPanel.revalidate();
        DisplayPanel.repaint();


        SignOutButton.addActionListener(e -> {
            new LaunchPage();
            frame.dispose();
        });
        addReservationsButton.addActionListener(e -> {
            new AddReservation();
            frame.dispose();
            //textPane1.setText("heheheheh\nsgdgdsgsdgdsg\ndfdsfdsfsdfdsfdsf\nsdfsdfdsfsdfdsfsdf");
        });
    }
}
