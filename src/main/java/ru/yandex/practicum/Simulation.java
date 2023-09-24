package ru.yandex.practicum;
import ru.yandex.practicum.process.*;

public class Simulation {
   public static final int XX = 10;
   public static final int YY = 10;
    public static void main(String[] args) {

        Map map = new Map();
        MapRender action = new MapRender();
        action.creatingTheNewWorld(map);
        action.render(map);
        System.out.println(" "+ map.maps.entrySet().size());
        }



    }
   // nextTurn() -  // просимулировать и отрендерить один ход
   // startSimulation() - // запустить бесконечный цикл симуляции и рендеринга
   // pauseSimulation() - // приостановить бесконечный цикл симуляции и рендеринга

