package application;

public class Up extends State {
    public Up() {
        super("UP");
    }

    @Override
    public int distance(int floor, int destination) {
        return (floor <= destination) ?
                    destination - floor :
                    2 * Building.numberOfFloors - floor - destination;
    }
}
