import java.util.ArrayList;

public class PlaneSeatsObject {
    String name;
    private ArrayList<Integer> occupiedSeats = new ArrayList<>();

    PlaneSeatsObject(String name){
        this.name = name;
    }

    public void addToOccupiedSeats(int seatNum){
        occupiedSeats.add(seatNum);
    }
    public ArrayList<Integer> getOccupiedSeats(){
        return occupiedSeats;
    }
}
