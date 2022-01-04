package application;

import java.util.HashMap;
import java.util.Map;

public class Building {

    public static int numberOfFloors;
    Map<String, Elevator> elevators;

    public Building(){

    }

    public Building(int numberOfFloors, String ... elevatorList){
        Building.numberOfFloors = numberOfFloors;
        elevators = new HashMap<>();
        for (String elevatorString: elevatorList) {
            Elevator elevator = ElevatorFactory.createElevator(elevatorString);
            this.elevators.put(elevator.getId(), elevator);
        }
    }

    public String requestElevator(int destination){
        int minDistance = 2 * numberOfFloors;
        String closestElevatorId = null;
        for (Elevator elevator: elevators.values()) {
            if (elevator.distance(destination) <= minDistance){
                minDistance = elevator.distance(destination);
                closestElevatorId = elevator.getId();
            }
        }
        return closestElevatorId;
    }

    public String requestElevator(){
        return requestElevator(numberOfFloors);
    }

    public void move(String id, String action){
        this.elevators.get(id).move(action);
    }

    public void stopAt(String id, int floor) {
        this.elevators.get(id).setStopping(true);
        this.elevators.get(id).setFloor(floor);
    }
}
