package org.example.homeworks.homework3;

public class Main {
    public static void main(String[] args) {
        House house = new House();
        House house2 = new House("Tbilisi, Gagarini", 30, "Hamilton", 25, true);
        Colour pink = new Colour("pink", 71, 63, 65);
        Circle circle = new Circle(4.5, pink);

        System.out.println(house2.houseBuilt());
        System.out.println(house.houseBuilt());

        System.out.println(circle.createdCircle());
    }
}
