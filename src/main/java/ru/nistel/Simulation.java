package ru.nistel;

import ru.nistel.process.Action;
import ru.nistel.process.Map;
import ru.nistel.process.MapRender;

import java.io.IOException;


public class Simulation {
    public static final int XX = 10;
    public static final int YY = 10;
    static boolean isLeftBottom = false;
    static boolean isRightBottom = false;

    public static void main(String[] args) throws InterruptedException, IOException {

        Map map = new Map();
        MapRender mapRender = new MapRender();
        mapRender.creatingTheNewWorld(map);
        Action action = new Action();
        mapRender.go(map);
        while (true) {
            while (true) {
                if (isLeftBottom) {
                    mapRender.repaint(map);
                    while (true) {
                        mapRender.repaint(map);
                        action.nextTurn(map);
                        Thread.sleep(1000);
                    }
                } else if (isRightBottom) {
                    action.nextTurn(map);
                    mapRender.repaint(map);
                    isRightBottom = false;
                } else System.out.print("");
            }
        }
    }
    public static void setIsLeftBottom(boolean isLeftBottom) {
        Simulation.isLeftBottom = isLeftBottom;
    }
    public static void setIsRightBottom(boolean isRightBottom) {
        Simulation.isRightBottom = isRightBottom;
    }

}

