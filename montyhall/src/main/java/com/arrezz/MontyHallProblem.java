package main.java.com.arrezz;

import java.util.LinkedList;
import java.util.Random;

public class MontyHallProblem {
    private final Random ran = new Random();

    private final int doorAmount;
    private int winningDoor;
    private int chosenDoor;


    public MontyHallProblem(int doorAmount, int winningDoor, int chosenDoor) {
        this.doorAmount = doorAmount;
        this.winningDoor = winningDoor;
        this.chosenDoor = chosenDoor;
    }

    public int getWinningDoor() {
        return winningDoor;
    }

    public int getChosenDoor() {
        return chosenDoor;
    }

    public void setWinningDoor(int winningDoor) {
        this.winningDoor = winningDoor;
    }

    public void setChosenDoor(int chosenDoor) {
        this.chosenDoor = chosenDoor;
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
            return !doorList.get(chosenDoor).isWinner();
        } else {
            return doorList.get(chosenDoor).isWinner();
        }
    }

    public void reset() {
        setWinningDoor(ran.nextInt(doorAmount));
        setChosenDoor(ran.nextInt(doorAmount));
    }

}
