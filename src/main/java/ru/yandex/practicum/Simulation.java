package ru.yandex.practicum;
import ru.yandex.practicum.process.*;

public class Simulation {
   public static final int XX = 10;
   public static final int YY = 10;
    public static void main(String[] args) throws InterruptedException {

        Map map = new Map();
        MapRender mapRender = new MapRender();
        mapRender.creatingTheNewWorld(map);
        Action action = new Action();

        while (true) {
            System.out.println();
            mapRender.render(map);
            Thread.sleep(1000);
            action.nextTurn(map);


       }



    }




}
   // nextTurn() -  // просимулировать и отрендерить один ход
   // startSimulation() - // запустить бесконечный цикл симуляции и рендеринга
   // pauseSimulation() - // приостановить бесконечный цикл симуляции и рендеринга

