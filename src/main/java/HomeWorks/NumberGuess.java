package HomeWorks;

import java.util.Scanner;

public class NumberGuess {
    public static int numGenerator(int digits) {
        StringBuilder number = new StringBuilder();

        for (int x = 0; x < digits; x++) {
            int currentNum = (int) (Math.random() * 10);
            if (x == 0 && currentNum == 0) {
                number.append(currentNum + 1);
            } else {
                number.append(currentNum);
            }
        }
        return Integer.parseInt(number.toString());
    }

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        int currentGuess = 0;
        int attempts = 0;
        System.out.println("Enter length of number(max 9):");
        int lenOfNum = sc.nextInt();
        int selectedNum = numGenerator(lenOfNum);
//        System.out.println(selectedNum);
        while (currentGuess != selectedNum) {
            System.out.print("Guess Number: ");
            currentGuess = sc.nextInt();
            attempts++;
            if (currentGuess == selectedNum) {
                System.out.println("Attempts: " + attempts);
                System.out.println("Congrats you win!");
                break;
            } else {
                StringBuilder resultText = new StringBuilder();
                String currentNumStr = String.valueOf(currentGuess);
                String selectedNumStr = String.valueOf(selectedNum);
                for (int k = 0; k < currentNumStr.length(); k++) {
                    if (selectedNumStr.contains(String.valueOf(currentNumStr.charAt(k)))) {
                        if (String.valueOf(currentNumStr.charAt(k)).equals(String.valueOf(selectedNumStr.charAt(k)))) {
                            resultText.append(String.valueOf(currentNumStr.charAt(k))).append(" is Green ");

                        } else {
                            resultText.append(String.valueOf(currentNumStr.charAt(k))).append(" is Yellow ");
                        }
                    }

                }
                if (resultText.isEmpty()) {
                    System.out.println("Nothing Match");
                } else {
                    System.out.println(resultText);
                }
            }
        }
    }
}