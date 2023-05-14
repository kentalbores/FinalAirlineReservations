import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class SeatsSelection {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    Lists list = new Lists();
    TemporaryVariables temp = new TemporaryVariables();
    int selectedSeatNum;
    ArrayList<JButton> allSeatButtons= new ArrayList<>();
    JButton button;
    JButton reserveButton;
    SeatsSelection(){
        System.out.println(list.getPlaneNames());
        System.out.println("Selected plane num: "+temp.getPlaneID() );
        System.out.println("account id: "+ temp.getAccountID());

        frame.setSize(300,700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");
        frame.add(reserveButton = new JButton("Reserve"), BorderLayout.SOUTH);
        frame.setBackground(new Color(30,30,30));
        panel.setBackground(new Color(30,30,30));

        for (int i = 0; i < 50; i ++){
            panel.add(button = new JButton("seat "+i));
            allSeatButtons.add(button);
            button.setBackground(Color.GREEN);
            if (list.getPlanes().get(temp.getPlaneID()).getOccupiedSeats().contains(i)) {
                button.setBackground(Color.red);
            }
            button.setFocusable(false);
        }

        for (JButton button1: allSeatButtons){
            button1.addActionListener(e -> {
                System.out.println("Clicking button "+ button1.getText());
                button1.setBackground(Color.red);
                selectedSeatNum = allSeatButtons.indexOf(button1);
                int num = 0;
                for (JButton button2: allSeatButtons){
                    if (selectedSeatNum != allSeatButtons.indexOf(button2)){
                        button2.setBackground(Color.green);
                        if (list.getPlanes().get(temp.getPlaneID()).getOccupiedSeats().contains(allSeatButtons.indexOf(button2))){
                            button2.setBackground(Color.red);
                        }
                    }
                    num++;
                }
            });
        }
        frame.add(panel);
        frame.setVisible(true);

        reserveButton.addActionListener(e -> {
            list.getPlanes().get(temp.getPlaneID()).addToOccupiedSeats(selectedSeatNum);
            list.getAccounts().get(temp.getAccountID()).getThisAccountsSeats().add(selectedSeatNum);
            new HomePage();
            frame.dispose();
        });
    }
}
