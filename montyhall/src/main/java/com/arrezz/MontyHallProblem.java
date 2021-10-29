package main.java.com.arrezz;

import java.util.LinkedList;
import java.util.Random;

public class MontyHallProblem {
    private final Random ran = new Random();

    private final int doorAmount;
    private int winningDoor;
    private int initialDoorToBeChosen;


    public MontyHallProblem(int doorAmount, int winningDoor, int initialDoorToBeChosen) {
        this.doorAmount = doorAmount;
        this.winningDoor = winningDoor;
        this.initialDoorToBeChosen = initialDoorToBeChosen;
    }

    public void setWinningDoor(int winningDoor) {
        this.winningDoor = winningDoor;
    }

    public void setChosenDoor(int chosenDoor) {
        this.initialDoorToBeChosen = chosenDoor;
    }

    public boolean simulateGame(boolean swapDoor) {

        LinkedList<Door> doorList = new LinkedList<>();

        for(int i = 0; i < doorAmount; i++) {
            if (i == winningDoor) {
                doorList.add(new Door(true));
            } else {
                doorList.add(new Door(false));
            }
        }

        if (swapDoor) {
            return !doorList.get(initialDoorToBeChosen).isWinner();
        } else {
            return doorList.get(initialDoorToBeChosen).isWinner();
        }
    }

    public void reset() {
        setWinningDoor(ran.nextInt(doorAmount));
        setChosenDoor(ran.nextInt(doorAmount));
    }

}
