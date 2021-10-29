package main.java.com.arrezz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

public class App {
    private static final Random ran = new Random();

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int simulationAmount = 0;

        System.out.println("Welcome to the Monty Hall Problem \n How many times would you like to simulate the problem? (Integer):");
        try {
            simulationAmount = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Non-integer entered!");
        }

        int doorAmount = 0;

        System.out.println("How many doors are there in total? (Integer):");
        try {
            doorAmount = Integer.parseInt(reader.readLine());
        } catch (IOException e) {
            System.out.println("Non-integer entered!");
        }

        int winningDoor = ran.nextInt(doorAmount);
        int chosenDoor = ran.nextInt(doorAmount);

        boolean swapSimulationResult;
        boolean noSwapSimulationResult;

        int successSwapSimulationCounter = 0;
        int successNoSwapSimulationCounter = 0;

        MontyHallProblem montyHallProblem = new MontyHallProblem(doorAmount, winningDoor, chosenDoor);

        for (int i = simulationAmount; i > 0; i--) {
            swapSimulationResult = montyHallProblem.simulateGame(false);

            montyHallProblem.reset();

            noSwapSimulationResult = montyHallProblem.simulateGame(true);

            if (swapSimulationResult) {
                successSwapSimulationCounter++;
            }
            if (noSwapSimulationResult) {
                successNoSwapSimulationCounter++;
            }

            montyHallProblem.reset();
        }

        System.out.println("These are the results of the simulation for swapping!");
        System.out.println("Result for swapping simulation:");
        System.out.println("In total " + simulationAmount + " games were simulated");
        System.out.println("In total there were " + successSwapSimulationCounter + " games where we won");
        System.out.println("In total there were " + (simulationAmount - successSwapSimulationCounter) + " games were we lost");

        System.out.println("--------------------------------------------------------");
        System.out.println("These are the results of the simulation for not swapping!");
        System.out.println("Result for not swapping simulation:");
        System.out.println("In total there were " + successNoSwapSimulationCounter + " games where we won");
        System.out.println("In total there were " + (simulationAmount - successNoSwapSimulationCounter) + " games were we lost");

    }
}
