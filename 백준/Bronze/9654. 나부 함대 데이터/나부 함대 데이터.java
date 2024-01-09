import java.io.*;

public class Main {

    public static void main(String[] args) {
       
        StringBuilder sb = new StringBuilder();
        sb
            .append(String.format("%-15s%-15s%-11s%-10s\n", "SHIP NAME", "CLASS", "DEPLOYMENT", "IN SERVICE"))
                .append(String.format("%-15s%-15s%-11s%-10s\n", "N2 Bomber", "Heavy Fighter", "Limited", "21"))
                .append(String.format("%-15s%-15s%-11s%-10s\n", "J-Type 327", "Light Combat", "Unlimited", "1"))
                .append(String.format("%-15s%-15s%-11s%-10s\n", "NX Cruiser", "Medium Fighter", "Limited", "18"))
                .append(String.format("%-15s%-15s%-11s%-10s\n", "N1 Starfighter", "Medium Fighter", "Unlimited", "25"))
                .append(String.format("%-15s%-15s%-11s%-10s", "Royal Cruiser", "Light Combat", "Limited", "4"));
        System.out.println(sb);
    }

}