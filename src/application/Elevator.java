package application;

public class Elevator {
    private String id;
    private int floor;
    private State state;
    private boolean stopping;

    public Elevator(){}

    public Elevator(String id, int floor){
        this.id = id;
        this.floor = floor;
        this.state = new Rest();
        this.stopping = false;
    }

    public void move(String action) {
        if (action.equals("UP")) {
            this.state = new Up();
        } else if (action.equals("DOWN")) {
            this.state = new Down();
        } else if (action.equals("REST")) {
            this.state = new Rest();
        }
    }

    public int distance(int destination) {
        return this.stopping ? 2 * Building.numberOfFloors : this.state.distance(this.floor, destination);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public boolean isStopping() {
        return stopping;
    }

    public void setStopping(boolean stopping) {
        this.stopping = stopping;
    }
}
