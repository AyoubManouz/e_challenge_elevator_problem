package application;

public class ElevatorFactory {

    public static Elevator createElevator(String elevator){
        String id = elevator.split(":")[0];
        int floor = Integer.parseInt(elevator.split(":")[1]);
        return new Elevator(id, floor);
    }
}
