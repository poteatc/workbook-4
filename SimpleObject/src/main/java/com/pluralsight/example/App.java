package com.pluralsight.example;

public class App {
    public static void main(String[] args) {
        // Will usually get values from somewhere else such as user input, CSV file, or the network instead of hard coding
        String myFavoriteBrand = "JBL";
        String newestModel = "SK-500Z";
        double priceOnAmazon = 130.00;
        boolean bluetooth = true;

        //Headphones jbl = new Headphones("jbl", "SK-500Z", 49.99, true);
        Headphones myEarBuds = new Headphones(myFavoriteBrand, newestModel, priceOnAmazon, bluetooth);

        // Example use of getter
        //String brand = myEarBuds.getBrand();

        printHeadphones(myEarBuds);

    }

    static void printHeadphones(Headphones h) {
        String wireless = (h.isWireless()) ? "wireless" : "wired";
        //System.out.printf("%s %s %s headphones that cost $%.2f on Amazon and are wireless: %b",
                //h.getBrand(), h.getModel(), h.getPrice(), h.isWireless());
        System.out.printf("%s %s %s headphones cost $%.2f on Amazon",
                h.getBrand(), h.getModel(), wireless, h.getPrice());
    }
}
