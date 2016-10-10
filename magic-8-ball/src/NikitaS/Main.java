package NikitaS;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static float geicoRoyalties=0;
    static Random randomGen;
    static String initialPrompt= "Would you like the magic 8 ball to read your mind and answer your most complicated life questions (y/n)";
    static String repeatPrompt = "Would you like to channel the wisdom of the magic 8 ball again? (y/n)";
    static String[] replies = {"404: divination not found.", "Yes", "No, mayonnaise is not an instrument", "Answer unclear, but future looks bright", "Your answer is in another castle", "Time will tell", "What are you doing consulting an eight ball for guidance?", "I can't tell you that now, \nbut I can tell you I saved 15% by switching to GEICO","Indoobitably"};
    static String[] delayFillers ={"They are telling me...\n", "The spirits...","I'm beginning to see something" ,"...", "Okay, I have your question."};

    static String eightBallArt1 = "\n"+
            "   #######\n" +
            "  #########\n" +
            " ###     ###\n" +
            " ##  ###  ##\n" +
            " ##  # #  ##\n" +
            " ##  ###  ##\n" +
            " ##  # #  ##\n" +
            " ##  ###  ##\n" +
            " ###     ###\n" +
            "  #########\n" +
            "   ####### \n";

    static String eightBallArt2 = "\n"+
            "    #######\n" +
            "   #########\n" +
            "  ###     ###\n" +
            "  ##  ###  ##\n" +
            "  ##  # #  ##\n" +
            "  ##  ###  ##\n" +
            "  ##  # #  ##\n" +
            "  ##  ###  ##\n" +
            "  ###     ###\n" +
            "   #########\n" +
            "    ####### \n";

    static String eightBallArt3 = "\n"+
            "     #######\n" +
            "    #########\n" +
            "   ###     ###\n" +
            "   ##  ###  ##\n" +
            "   ##  # #  ##\n" +
            "   ##  ###  ##\n" +
            "   ##  # #  ##\n" +
            "   ##  ###  ##\n" +
            "   ###     ###\n" +
            "    #########\n" +
            "     ####### \n";

    static boolean initial= true;
    //ToDo: Add ASCII art
    //ToDo: Animate 8-ball shake?
    //ToDo: Increase interactivity?
    //Idea: Collect royalties from Geico and do things, like buy an item to go to next castle to get the answer you need.
    //Change replies to include: It's dangerous to go alone, here take this. Eventually turns into a text-based rpg.
    //I'm going to make this into a text based rpg.

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
    public static void delay(int time){
        try {
            Thread.sleep(1250);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (time>=1){
            System.out.println(delayFillers[time-1]);
            delay(time-1);
        }
    }

    public static void giveReply(int indexNum){
        System.out.println("Think of your question and I will telepathically read it.");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delay(5);
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

    public static int getRandomNumber(){return randomGen.nextInt(9);}

    public static String getReply(String prompt){
        System.out.println(prompt + " :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
