package ru.nistel;

import ru.nistel.process.Action;
import ru.nistel.process.Map;
import ru.nistel.process.MapRender;

import java.io.IOException;


public class Simulation {
    public static final int XX = 10;
    public static final int YY = 10;

    public static void setUserInput(boolean userInput) {
        Simulation.userInput = userInput;
    }

    static boolean userInput = false;

    public static void setUserInput2(boolean userInput2) {
        Simulation.userInput2 = userInput2;
    }

    static boolean userInput2 = false;


    public static void main(String[] args) throws InterruptedException, IOException {


        Map map = new Map();
        MapRender mapRender = new MapRender();
        mapRender.creatingTheNewWorld(map);
        Action action = new Action();
        mapRender.go(map);
        while (true) {
            while (true) {
                if (userInput) {
                    mapRender.repaint(map);
                    while (true) {
                        mapRender.repaint(map);
                        action.nextTurn(map);
                        Thread.sleep(1000);
                    }
                } else if (userInput2) {
                    action.nextTurn(map);
                    mapRender.repaint(map);
                    userInput2 = false;
                } else System.out.print("");
            }
        }
    }
}

