package ru.nistel.process;

import ru.nistel.Simulation;
import ru.nistel.objects.Emtity;
import ru.nistel.objects.mouvingObjects.Herbivore;
import ru.nistel.objects.mouvingObjects.Predator;
import ru.nistel.objects.notMovingObjects.Grass;
import ru.nistel.objects.notMovingObjects.Rock;
import ru.nistel.objects.notMovingObjects.Tree;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MapRender {

    JFrame frame;
    JLabel label;
    Font bigFont = new Font("aaa", Font.BOLD, 28);
    Random random = new Random();
    public static int notMovingObject = Simulation.XX * Simulation.YY / 7;
    public static int movingObject = Simulation.XX * Simulation.YY / 30;

    public void creatingTheNewWorld(Map map) {

        while (true) {
            Coordinates coordinates = new Coordinates(random.nextInt(Simulation.XX), random.nextInt(Simulation.YY));
            if (map.maps.entrySet().size() < notMovingObject) {
                if (map.maps.get(coordinates) == null) {
                    Grass emtity = new Grass(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 2) {
                if (map.maps.get(coordinates) == null) {
                    Rock emtity = new Rock(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 3) {
                if (map.maps.get(coordinates) == null) {
                    Tree emtity = new Tree(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < notMovingObject * 3 + movingObject) {
                if (map.maps.get(coordinates) == null) {
                    Herbivore emtity = new Herbivore(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else if (map.maps.entrySet().size() < ((notMovingObject * 3 + movingObject * 2) - 2)) {
                if (map.maps.get(coordinates) == null) {
                    Predator emtity = new Predator(coordinates);
                    map.setEmtity(coordinates, emtity);
                }
            } else {

                break;
            }
        }
    }

    private String getEmptySprite(Emtity emtity) {
        if (emtity.getClass().equals(Grass.class)) {
            return "\uD83C\uDF40";
        } else if (emtity.getClass().equals(Rock.class)) {
            return "\uD83C\uDF33";
        } else if (emtity.getClass().equals(Tree.class)) {
            return "\uD83C\uDF32";
        } else if (emtity.getClass().equals(Herbivore.class)) {
            return "\uD83C\uDFC7";
        } else if (emtity.getClass().equals(Predator.class)) {
            return "\uD83D\uDE3E";
        } else {
            return "☘";
        }
    }

    public void go(Map map) {

        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel mainPanel = getjPanel(map, bigFont);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);


        label = new JLabel("Simulation");
        label.setBackground(Color.GRAY);
        label.setFont(bigFont);
        frame.getContentPane().add(BorderLayout.NORTH, label);

        JPanel panelB = new JPanel();
        panelB.setBackground(Color.darkGray);

        JButton labelButton = new JButton("One step");
        labelButton.setBackground(Color.lightGray);
        labelButton.addActionListener(new OneStep());
        panelB.add(labelButton);

        JButton colorButton = new JButton("Unlimited");
        colorButton.setBackground(Color.lightGray);
        colorButton.addActionListener(new NonStop());
        panelB.add(colorButton);


        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, panelB);
        frame.getContentPane().add(BorderLayout.NORTH, label);


        frame.setSize(600, 600);
        frame.setVisible(true);

    }

    private JPanel getjPanel(Map map, Font bigFont) {
        GridLayout grid = new GridLayout(10, 10);
        JPanel mainPanel = new JPanel(grid);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 25, 10, 10));
        for (int i = 0; i < Simulation.XX; i++) {
            for (int j = 0; j < Simulation.YY; j++) {
                Coordinates cor = new Coordinates(i, j);
                if (map.maps.get(cor) == null) {
                    JLabel c = new JLabel();
                    c.setFont(bigFont);
                    c.setText("☘");
                    mainPanel.add(c);
                } else {
                    JLabel c = new JLabel();
                    c.setFont(bigFont);
                    c.setText(getEmptySprite(map.maps.get(cor)));
                    mainPanel.add(c);
                }
            }
        }
        return mainPanel;
    }

    public void repaint(Map map) {

        JPanel mainPanel = getjPanel(map, bigFont);
        frame.getContentPane().add(BorderLayout.CENTER, mainPanel);
        frame.setVisible(true);
    }

    class OneStep implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            boolean yes = true;
            Simulation.setIsRightBottom(yes);
        }
    }

    class NonStop implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            boolean yes = true;
            Simulation.setIsLeftBottom(yes);
        }
    }

}


