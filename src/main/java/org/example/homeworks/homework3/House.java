package org.example.homeworks.homework3;

public class House {
    String address;
    int houseNumbers;
    String homeOwner;
    int numOfRooms;
    Boolean isFlat;

    public House(){}

    public House(String address, int houseNumbers, String homeOwner, int numOfRooms, Boolean isFlat) {
        this.address = address;
        this.houseNumbers = houseNumbers;
        this.homeOwner = homeOwner;
        this.numOfRooms = numOfRooms;
        this.isFlat = isFlat;
    }

    public static String houseBuilt(){
        return "House Built";
    }
}
