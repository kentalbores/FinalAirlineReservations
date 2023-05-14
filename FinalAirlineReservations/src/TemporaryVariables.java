import java.util.ArrayList;

public class TemporaryVariables {
    static ArrayList<String> Locations = new ArrayList<>();
    static ArrayList<String> Time = new ArrayList<>();
    private static String loggedInAccount;
    private static int accountID;
    private static int planeID;
    public int getAccountID(){
        return accountID;
    }
    public String getLoggedInAccount(){
        return loggedInAccount;
    }
    public void setLoggedInAccount(String acc){
        loggedInAccount = acc;
    }
    public void setAccountID(int i){
        accountID = i;
    }
    public void setPlaneID(int i){
        planeID = i;
    }
    public int getPlaneID(){
        return planeID;
    }
}
