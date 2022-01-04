package application;

public abstract class State {
    String state;

    public State(String state) {
        this.state = state;
    }

    public abstract int distance(int floor, int destination);
}
