package Assign2;

//Aileen Dong (ydong8@toromail.csudh.edu)

import java.util.Scanner;
public class TipCalculator {
    public static void main(String[] args) {
        Double bill, tax, tip, total;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter bill amount:" +'\t');
        bill = input.nextDouble();

        if (bill <= 0) {
            System.out.println("Invalid meal charge. Bill amount must be greater than zero.");
            System.exit(0);
        }

        tax = bill * 0.0713;
        System.out.println("Your bill total: " + '\t' + (double) Math.round(bill * 100) / 100);
        System.out.println("Tax(@7.13%): " + '\t' + (double) Math.round(tax * 100) / 100);

        System.out.print("How happy are you with the service [1-5]:" + '\t');
        int service = input.nextInt();

        switch (service) {
            case 1:
                tip = bill * 0.05;
                System.out.println("Tip(@5%) based on happiness value 1 : "+ String.format("%.2f",tip));
                break;
            case 2:
                tip = bill * 0.075;
                System.out.println("Tip(@7.5%) based on happiness value 2 : "+ String.format("%.2f",tip));
                break;
            case 3:
                tip = bill * 0.1;
                System.out.println("Tip(@10%) based on happiness value 3 : "+ String.format("%.2f",tip));
                break;
            case 4:
                tip = bill * 0.15;
                System.out.println("Tip(@15%) based on happiness value 4 : "+ String.format("%.2f",tip));
                break;
            case 5:
                tip = bill * 0.2;
                System.out.println("Tip(@20%) based on happiness value 5 : "+ String.format("%.2f",tip));
                break;
            default:
                System.out.println("Invalid happiness value. Value must be between 1 and 5." +'\t');
                System.exit(0);
                return;
        }

        if(bill >= 0){
            total= bill + tax + tip;
        System.out.println("Total Payable: "  +'\t'+  String.format("%.2f",total));
        }

    }
}
