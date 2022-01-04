package application;

public class Down extends State {

    public Down(){
        super("DOWN");
    }

    @Override
    public int distance(int floor, int destination) {
        return (floor >= destination) ?
                    floor - destination :
                    destination + floor;
    }
}
