package Assign2;

//Aileen Dong (ydong8@toromail.csudh.edu)
import java.util.Scanner;
public class BillCalculator {
    public static void main (String[] args){

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of voice call minutes:"+ '\t');
        int voiceCalls = sc.nextInt();
        if (voiceCalls < 0) {
            System.out.println("Invalid input: voice call minutes cannot be negative.");
            System.exit(0);
        }

        System.out.println("Enter the number of text messages:"+ '\t');
        int textMessages = sc.nextInt();
        if (textMessages < 0) {
            System.out.println("Invalid input: text messages cannot be negative.");
            System.exit(0);
        }

        System.out.println("Enter the number of MBs of data used:"+ '\t');
        int dataUsed = sc.nextInt();
        if (dataUsed < 0) {
            System.out.println("Invalid input: data usage cannot be negative.");
            System.exit(0);
        }

        System.out.println("Enter your package code (1-3):"+ '\t');
        int packageCode = sc.nextInt();
        if (packageCode < 1 || packageCode > 3) {
            System.out.println("Invalid input: package code must be between 1 and 3.");
            System.exit(0);
        }


        double monthlyCharge = 0.0;
        double additionalVoiceCharge = 0.0;
        double additionalTextCharge = 0.0;
        double additionalDataCharge = 0.0;
        int inclusiveMinutes = 0;
        int inclusiveText = 0;
        int inclusiveData = 0;
        double voiceCallRate = 0.0;
        double textMessageRate = 0.0;
        double dataRate = 0.0;


        switch (packageCode) {
            case 1:
                monthlyCharge = 20.0;
                inclusiveMinutes = 100;
                inclusiveText = 150;
                inclusiveData = 1024;
                voiceCallRate = 0.20;
                textMessageRate = 0.20;
                dataRate = 0.25;
                break;
            case 2:
                monthlyCharge = 30.0;
                inclusiveMinutes = 200;
                inclusiveText = 300;
                inclusiveData = 2048;
                voiceCallRate = 0.13;
                textMessageRate = 0.10;
                dataRate = 0.20;
                break;
            case 3:
                monthlyCharge = 40.0;
                inclusiveMinutes = 400;
                inclusiveText = 600;
                inclusiveData = 4096;
                voiceCallRate = 0.08;
                textMessageRate = 0.08;
                dataRate = 0.13;
                break;
            default:
                System.out.println("Invalid package code. Please enter a valid package code between 1 and 3.");
                return;
        }

        if (voiceCalls > inclusiveMinutes) {
            additionalVoiceCharge = (voiceCalls - inclusiveMinutes) * voiceCallRate;
        }
        if (textMessages > inclusiveText) {
            additionalTextCharge = (textMessages - inclusiveText) * textMessageRate;
        }
        if (dataUsed > inclusiveData) {
            additionalDataCharge = (dataUsed - inclusiveData) * dataRate;
        }

        double subTotal = monthlyCharge + additionalVoiceCharge + additionalTextCharge + additionalDataCharge;
        double stateTax = subTotal * 0.065;
        double totalDue = subTotal + stateTax;

        System.out.println("Summary of Usage:");
        System.out.println("You used " + voiceCalls + "/" + inclusiveMinutes + " minutes, you " +
                (voiceCalls > inclusiveMinutes ? "exceeded" : "are within") + " your monthly limit");
        System.out.println("You used " + textMessages + "/" + inclusiveText + " SMS messages, you " +
                (textMessages > inclusiveText ? "exceeded" : "are within") + " your monthly limit");
        System.out.println("You used " + dataUsed + "/" + inclusiveData+ " minutes, you " +
                (voiceCalls > inclusiveMinutes ? "exceeded" : "are within") + " your monthly limit");

        System.out.println("Charges:");
        System.out.println("Package code\t\t\t\t\t\t\t\t\t\t\t\t: " + packageCode);
        System.out.println("Monthly charges\t\t\t\t\t\t\t\t\t\t\t\t: $" + monthlyCharge);

        if (dataUsed > inclusiveData) {
            System.out.println("Additional voice charges (" + (voiceCalls - inclusiveMinutes) + " minute @$" + voiceCallRate + " per minute)\t: $" + String.format("%.2f",additionalVoiceCharge));
        } else {
            System.out.println("Additional voice charges (" + " 0 minute @ $" + voiceCallRate + " per minute)\t\t: $" + String.format("%.2f",additionalVoiceCharge));
        }

        if (textMessages > inclusiveText) {
            System.out.println("Additional SMS charges (" + (textMessages - inclusiveText) + " SMS @$" + textMessageRate + " per SMS)\t\t\t: $" + (String.format("%.2f",additionalTextCharge)));
        } else {
            System.out.println("Additional SMS charges (" + " 0 SMS @ $" + textMessageRate + " per minute)\t\t\t: $" + String.format("%.2f",additionalTextCharge));
        }

        if (dataUsed > inclusiveData) {
            System.out.println("Additional data charges (" + (dataUsed - inclusiveData) + " MB @$" + dataRate + " per MB)\t\t\t: $" + String.format("%.2f",additionalDataCharge));
        } else {
            System.out.println("Additional data charges (" + " 0 MB @ $" + dataRate + " per MB)\t\t\t\t: $" + String.format("%.2f",additionalDataCharge));
        }

        System.out.println("Sub Total\t\t\t\t\t\t\t\t\t\t\t\t\t: $" + String.format("%.2f",subTotal));
        System.out.println("State Tax (6.5%)\t\t\t\t\t\t\t\t\t\t\t: $" + String.format("%.2f",stateTax));
        System.out.println("Total due\t\t\t\t\t\t\t\t\t\t\t\t\t: $" + String.format("%.2f",totalDue));

    }
}

