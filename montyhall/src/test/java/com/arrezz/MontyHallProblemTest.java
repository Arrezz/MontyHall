package test.java.com.arrezz;


import main.java.com.arrezz.MontyHallProblem;
import org.junit.Test;

import static junit.framework.TestCase.fail;


public class MontyHallProblemTest {

    @Test
    public void resetProperlyTest() {
        MontyHallProblem testProblem = new MontyHallProblem(3, 2, 1);

        int sameWinningNumberCount = 0;
        int sameChosenNumberCount = 0;


        for(int i = 10; i > 0; i--) {
            if (testProblem.getWinningDoor() == 2) {
                sameWinningNumberCount++;
            }
            if (testProblem.getChosenDoor() == 1) {
                sameChosenNumberCount++;
            }
            testProblem.reset();
        }
        if (sameChosenNumberCount == 10 && sameWinningNumberCount == 10) {
            fail();
        }
    }
}
