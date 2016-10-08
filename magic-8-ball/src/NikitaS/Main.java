package NikitaS;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static float geicoRoyalties=0;
    static Random randomGen;
    static String initialPrompt= "Would you like the magic 8 ball to read your mind and answer your most complicated life questions (y/n)";
    static String repeatPrompt = "Would you like to channel the wisdom of the magic 8 ball again? (y/n)";
    static String[] replies = {"404: divination not found.", "Yes", "No, mayonaisse is not an instrument", "Answer unclear, but future looks bright", "Your answer is in another castle", "Time will tell", "What are you doing consulting an eight ball for your life questions?", "I can't tell you that now, \nbut I can tell you I saved 15% by switching to GEICO","Indoobitably"};

    static boolean initial= true;
    //ToDo: Add ASCII art
    //ToDo: Add either sleep() or countDownTimer()
    //ToDo: Animate 8-ball shake?
    //ToDo: Increase interactivity?
    //Idea: Collect royalties from Geico and do things, like buy an item to go to next castle to get the answer you need.

    public static void main(String[] args) {
        randomGen = new Random();
        askUser();

    }

    public static void askUser(){
        String prompt;
        if (initial){
            prompt=initialPrompt;
        }else{
            prompt = repeatPrompt;
        }
        String userInput = getReply(prompt).toLowerCase();
        if (userInput.equals("y") || userInput.equals("yes")) {
            shakeTheBall();
        } else if (userInput.equals("quit") || userInput.equals("q") || userInput.equals("n") || userInput.equals("no")) {
            System.out.println("Okay, you seem to have everything figured out anyway.");
        } else {
            System.out.println("That wasn't a valid response. Type either \"yes\" or \"quit\"");
            askUser();
        }
    }

    public static void shakeTheBall() {
        initial=false;
        int indexNum = getRandomNumber();
        if (indexNum==8){
            geicoRoyalties+=0.25;
        }
        giveReply(indexNum);
        askUser();

    }
    public static void giveReply(int indexNum){
        switch(indexNum){
            case 0:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 1:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 2:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 3:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 4:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 5:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 6:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 7:
                System.out.println(replies[indexNum]+"\n");
                break;
            case 8:
                System.out.println(replies[indexNum]+"\n");
                break;
        }

    }

    public static int getRandomNumber(){
        return randomGen.nextInt(9);
    }


    public static String getReply(String prompt){
        System.out.println(prompt + " :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
