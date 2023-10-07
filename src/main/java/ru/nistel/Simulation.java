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

       while (true) {
           System.out.println();
           System.out.println("Cделать один ход введите ' 1 ', запустить симуляцию введите ' 2 ' ");
           int userInput = scanner.nextInt();
           if (userInput == 2) {
               mapRender.render(map);
               while (true) {
                   scanner.close();
                   System.out.println();
                   action.nextTurn(map);
                   Thread.sleep(1000);
                   mapRender.render(map);

               }
           } else if (userInput == 1) {
               System.out.println();
               mapRender.render(map);
               action.nextTurn(map);
           } else System.out.println("Неверный ввод. Cделать один ход введите ' 1 ', запустить симуляцию введите ' 2 ' ");


       }
    }




}


