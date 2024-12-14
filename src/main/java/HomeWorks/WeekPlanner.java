//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package HomeWorks;

import java.util.Scanner;

public class WeekPlanner {
    public WeekPlanner() {
    }

    public static void main(String[] args) {
        String[][] schedule = new String[7][2];
        Scanner sc = new Scanner(System.in);
        schedule[0][0] = "Monday";
        schedule[0][1] = "Meeting with Michael";
        schedule[1][0] = "Tuesday";
        schedule[1][1] = "Work on project";
        schedule[2][0] = "Wednesday";
        schedule[2][1] = "Read a book";
        schedule[3][0] = "Thursday";
        schedule[3][1] = "Go to gym";
        schedule[4][0] = "Friday";
        schedule[4][1] = "Explore new technologies";
        schedule[5][0] = "Saturday";
        schedule[5][1] = "Prepare for presentation";
        schedule[6][0] = "Sunday";
        schedule[6][1] = "Take a day off";
        String userInput = "";

        while(!userInput.equalsIgnoreCase("exit")) {
            System.out.println("Please, input the day of the week:");
            userInput = sc.nextLine().trim();
            boolean found = false;

            for(int i = 0; i < schedule.length; ++i) {
                String[] couple = schedule[i];
                if (couple[0].equalsIgnoreCase(userInput)) {
                    System.out.println(couple[0] + ": " + couple[1]);
                    found = true;
                } else if (userInput.split(" ")[0].equalsIgnoreCase("change") && couple[0].equalsIgnoreCase(userInput.split(" ")[1])) {
                    System.out.println("Please, input new tasks for  " + couple[0]);
                    String newTask = sc.nextLine();
                    schedule[i][1] = newTask;
                    System.out.println(couple[0] + ": " + couple[1]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Sorry, I don't understand you, please try again.");
            }
        }

    }
}
