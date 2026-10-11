import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("\n");
        String[] quarters = {"Q1", "Q2", "Q3", "Q4"};
        String[] brands = {"NIKE", "ADIDAS", "REEBOK"};
        int[][] sales = {{100, 150, 70}, {88, 92, 103}, {75, 45, 90}, {65, 95, 175}};
        String filename ="UltimateShoe.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))){


        writer.write("--------------------------------------------------");
        writer.newLine();
        writer.write ("ULTIMATE SHOE SALES");
        writer.newLine();
        writer.write("--------------------------------------------------");
        writer.newLine();

      writer.write(String.format ("%-15s%-15s%-15s%-15s%n", "QUARTER", brands[0], brands[1], brands[2]));
       writer.write("--------------------------------------------------");
       writer.newLine();
        for (int i = 0; i < quarters.length; i++) {
            writer.write(String.format("%-15s%-15d%-15d%-15d%n",
                    quarters[i], sales[i][0], sales[i][1], sales[i][2]));
        }
       writer.newLine();
       writer.write("--------------------------------------------------");
       writer.newLine();
        int[] totals = new int[brands.length];
        double[] averages = new double[brands.length];
        int[] minSales = new int[brands.length];
        int[] maxSales = new int[brands.length];

        for (int b = 0; b < brands.length; b++) {
            int sum = 0;
            int min = sales[0][b];
            int max = sales[0][b];

            for (int q = 0; q < quarters.length; q++) {
                int val = sales[q][b];
                sum += val;
                if (val < min) min = val;
                if (val > max) max = val;
            }

            totals[b] = sum;
            averages[b] = (double) sum / quarters.length;
            minSales[b] = min;
            maxSales[b] = max;
        }

       writer.write(String.format("%-15s%-15d%-15d%-15d%n", "TOTAL:", totals[0], totals[1], totals[2]));
       writer.write(String.format("%-15s%-15.1f%-15.1f%-15.1f%n", "AVERAGE:", averages[0], averages[1], averages[2]));
       writer.write(String.format("%-15s%-15d%-15d%-15d%n", "MIN:", minSales[0], minSales[1], minSales[2]));
       writer.write(String.format("%-15s%-15d%-15d%-15d%n", "MAX:", maxSales[0], maxSales[1], maxSales[2]));
       writer.write("--------------------------------------------------");

            System.out.println("Data successfully written to " + filename);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println();
        System.out.println("READING DATA FROM FILE");
        System.out.println("=========================================================================================================================");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println("Error reading from file " + e.getMessage());
        }
    }
}