package application;

public class Rest extends State{

    public Rest(){
        super("REST");
    }

    @Override
    public int distance(int floor, int destination) {
        return Math.abs(floor - destination);
    }
}
