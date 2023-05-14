import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.util.ArrayList;

public class AddReservation {
    private JPanel Panel1;
    private JCheckBox japanCheckBox;
    private JCheckBox singaporeCheckBox;
    private JCheckBox taiwanCheckBox;
    private JCheckBox chinaCheckBox;
    private JCheckBox southKoreaCheckBox;
    private JCheckBox a7AMCheckBox;
    private JCheckBox a7PMCheckBox;
    private JButton goBackButton;
    private JButton reserveButton;
    Lists list = new Lists();
    TemporaryVariables temp = new TemporaryVariables();
    String selectedLocation, selectedTime, selectedPlaneName = "";
    double selectedCost;


    AddReservation(){
        JFrame frame = new JFrame();
        frame.setVisible(true);
        frame.setSize(500,500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(Panel1);
        ImageIcon icon = new ImageIcon("src/happilogo.jpg");
        frame.setIconImage(icon.getImage());
        frame.setTitle("Airline Reservations System");


        goBackButton.addActionListener(e -> {
            new HomePage();
            frame.dispose();
        });



        // para single selection
        JCheckBox[] allCheckBoxes = {japanCheckBox, singaporeCheckBox, taiwanCheckBox, chinaCheckBox, southKoreaCheckBox};
        String[] places = {"Japan", "Singapore", "Taiwan", "China", "South Korea"};
        for (int i = 0; i < 5; i++){
            int select = i;
            allCheckBoxes[i].addActionListener(e -> {
                for (int j = 0; j < 5; j++){
                    if (j == select){
                        selectedLocation = places[select];
                        selectedCost = list.getSelectedPlaneCost().get(selectedLocation);
                        //list.getAccounts().get(temp.getAccountID()).addToThisAccountsLocation(places[select]);
                        continue;
                    }
                    allCheckBoxes[j].setSelected(false);
                }
            });
        }

        a7AMCheckBox.addActionListener(e -> {
            a7PMCheckBox.setSelected(false);
            selectedTime = "7 AM";
        });
        a7PMCheckBox.addActionListener(e -> {
            a7AMCheckBox.setSelected(false);
            selectedTime = "7 PM";
        });


        reserveButton.addActionListener(e -> {
            selectedPlaneName = selectedPlaneName.concat(selectedLocation + selectedTime);

            System.out.println("plane name" + selectedPlaneName);
            if (!list.getPlaneNames().contains(selectedPlaneName)){
                PlaneSeatsObject newPlane = new PlaneSeatsObject(selectedPlaneName);
                list.addToPlaneNames(selectedPlaneName);
                list.addToPlanes(newPlane);
            }
            if ((japanCheckBox.isSelected() || singaporeCheckBox.isSelected() || taiwanCheckBox.isSelected() || chinaCheckBox.isSelected() || southKoreaCheckBox.isSelected()) && (a7PMCheckBox.isSelected() || a7AMCheckBox.isSelected())){
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsLocation(selectedLocation);
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsTime(selectedTime);
                list.getAccounts().get(temp.getAccountID()).addToThisAccountsCost(selectedCost);
                temp.setPlaneID(list.getPlaneNames().indexOf(selectedPlaneName));
                new SeatsSelection();
                frame.dispose();
            }

//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsLocation());
//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsTime());
//            System.out.println(list.getAccounts().get(temp.getAccountID()).getThisAccountsCosts());
        });


    }
}
