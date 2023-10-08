package ru.nistel;

import ru.nistel.process.Action;
import ru.nistel.process.Map;
import ru.nistel.process.MapRender;

import java.util.Scanner;

public class Simulation {
   public static final int XX = 10;
   public static final int YY = 10;

    public static void main(String[] args) throws InterruptedException {

        Scanner scanner = new Scanner(System.in);
        Map map = new Map();
        MapRender mapRender = new MapRender();
        mapRender.creatingTheNewWorld(map);
        Action action = new Action();
        mapRender.go(map);
        System.out.println();
        System.out.println("Cделать один ход введите ' 1 ', запустить симуляцию введите ' 2 ' ");

        while (true) {
            int userInput = Integer.parseInt(scanner.next());
            if (userInput == 2) {
                mapRender.repaint(map);
                scanner.close();
                while (true) {
                    mapRender.repaint(map);
                    action.nextTurn(map);
                    Thread.sleep(1000);
                }
            }
            else if (userInput == 1) {
                action.nextTurn(map);
                mapRender.repaint(map);
                System.out.println("Cделать один ход введите ' 1 ', запустить симуляцию введите ' 2 ' ");

            }
            else System.out.println("Неверный ввод. Cделать один ход введите ' 1 ', запустить симуляцию введите ' 2 ' ");

        }
    }
}


