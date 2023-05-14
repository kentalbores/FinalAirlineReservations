import java.util.ArrayList;

public class Accounts {
    private String name;
    private ArrayList<String> thisAccountsLocation = new ArrayList<>();
    private ArrayList<String> thisAccountsTime = new ArrayList<>();
    private ArrayList<Double> thisAccountsCosts = new ArrayList<>();
    private ArrayList<Integer> thisAccountsSeats = new ArrayList<>();
    Accounts(String name){
        this.name = name;
    }
    public void addToThisAccountsSeats(int i){
        thisAccountsSeats.add(i);
    }
    public ArrayList<Integer> getThisAccountsSeats(){
        return thisAccountsSeats;
    }
    public ArrayList<String> getThisAccountsLocation(){
        return thisAccountsLocation;
    }
    public ArrayList<String> getThisAccountsTime(){
        return thisAccountsTime;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Double> getThisAccountsCosts(){
        return thisAccountsCosts;
    }
    public void addToThisAccountsLocation(String loc){
        thisAccountsLocation.add(loc);
    }
    public void addToThisAccountsTime(String time){
        thisAccountsTime.add(time);
    }
    public void addToThisAccountsCost(double cost){
        thisAccountsCosts.add(cost);
    }

}
