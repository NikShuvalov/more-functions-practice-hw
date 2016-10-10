package NikitaS;

import java.util.Random;
import java.util.Scanner;

public class Main {
    static float geicoRoyalties=0;
    static Random randomGen;
    static String initialPrompt= "Would you like the magic 8-ball to read your mind and answer your most complicated life questions (y/n)";
    static String repeatPrompt = "Would you like to channel the wisdom of the magic 8 ball again? (y/n)";
    static String[] replies = {"404: divination not found.", "Yes", "No, mayonnaise is not an instrument", "Answer unclear, but future looks bright", "Your answer is in another castle", "Time will tell", "What are you doing consulting a toy for guidance?", "I can't tell you that now, \nbut I can tell you I saved 15% by switching to GEICO","Indoobitably"};
    static String[] delayFillers ={"They are telling me...\n", "The spirits...","I'm beginning to see something" ,"...", "Okay, I have your question."};

    static String invalidResponse="That wasn't a valid response. Type either \"yes\" or \"quit\"";
    static String quitMessage = "Okay, you seem to have everything figured out anyway.\"";

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    static String[] eightBallArt = {"\n" +
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
            "   ####### \n",

            "\n"+
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
                    "     ####### \n",
 "\n"+
            "       #######\n" +
            "      #########\n" +
            "     ###     ###\n" +
            "     ##  ###  ##\n" +
            "     ##  # #  ##\n" +
            "     ##  ###  ##\n" +
            "     ##  # #  ##\n" +
            "     ##  ###  ##\n" +
            "     ###     ###\n" +
            "      #########\n" +
            "       ####### \n"
    };





    static boolean initial= true;
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
            System.out.println(quitMessage);
        } else {
            System.out.println(invalidResponse);
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
        }else {animate();}
    }


    public static void animate(){
        int oscillations = 5;
        int count = 0;
        int frame= 0;
        boolean increasing= true;
        while(oscillations>count){
            try {
                Thread.sleep(250);
                System.out.println(eightBallArt[frame]);
                if (increasing){
                    frame++;
                    if (frame == 2){
                        increasing=false;
                        count++;
                    }
                }else{
                    frame--;
                    if (frame == 0){
                        increasing=true;
                        count++;
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }


    }


    public static void giveReply(int indexNum){
        System.out.println("Think of your question and I will telepathically read it.");
        String answer="Something went awry, call an exorcist.";
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delay(5);
        switch(indexNum){
            case 0:
                answer = replies[indexNum]+"\n";
                break;
            case 1:
                answer = replies[indexNum]+"\n";
                break;
            case 2:
                answer = replies[indexNum]+"\n";
                break;
            case 3:
                answer = replies[indexNum]+"\n";
                break;
            case 4:
                answer = replies[indexNum]+"\n";
                break;
            case 5:
                answer = replies[indexNum]+"\n";
                break;
            case 6:
                answer = replies[indexNum]+"\n";
                break;
            case 7:
                answer = replies[indexNum]+"\n";
                break;
            case 8:
                answer = replies[indexNum]+"\n";
                break;
        }
        System.out.println(ANSI_RED+answer+ANSI_RESET);

    }

    public static int getRandomNumber(){return randomGen.nextInt(9);}

    public static String getReply(String prompt){
        System.out.println(prompt + " :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();

    }
}
