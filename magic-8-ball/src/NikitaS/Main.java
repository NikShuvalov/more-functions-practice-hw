package NikitaS;

import java.util.Random;
import java.util.Scanner;


public class Main {
    static Random randomGen;
    static String initialPrompt= "Would you like the magic 8-ball to read your mind and answer your most burning questions? (y/n)";
    static String repeatPrompt = "Would you like to channel the wisdom of the magic 8 ball again? (y/n)";
    static String[] replies = {"404: divination not found.",
            "Yes",
            "No",
            "Answer unclear",
            "Your answer is in another 8-ball",
            "Time will tell",
            "That sounds more like a question for WebMD",
            "I can't tell you now, \nbut I can tell you I saved 15% by switching to GEICO",
            "I'm glad you asked that question\n"};

    static String[] delayFillers ={"They are telling me...\n", "The spirits...", "I'm beginning to see something" ,"...", "Okay, I have your question."};

    static String invalidResponse="That wasn't a valid response. Type either \"yes\" or \"quit\"";
    static String quitMessage = "Okay, you seem to have everything figured out anyway.";

    static String[] secondaryMessages={"An issue occurred while processing your request\nWould you like to try to reboot magic 8-ball (y/n)?",
            "Would you like me to check your question with WebMD? (y/n)",
            "CONGRADULATEONS! UVE WON ROYALTY MONEY FRAM GEICO! WANT FIND OUT MORE? (y/n)",
            "And that's a good question...\n(Press the magic-8 ball for more info? (y/n))",
    };

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
            "    ########\n" +
            "   ##########\n" +
            "  ###      ###\n" +
            " ##   ####   ##\n" +
            " ##   #  #   ##\n" +
            " ##   ####   ##\n" +
            " ##   #  #   ##\n" +
            " ##   ####   ##\n" +
            "  ###      ###\n" +
            "   ##########\n" +
            "    ######## \n",

            "\n"+
                    "      ########\n" +
                    "     ##########\n" +
                    "    ###      ###\n" +
                    "   ##   ####   ##\n" +
                    "   ##   #  #   ##\n" +
                    "   ##   ####   ##\n" +
                    "   ##   #  #   ##\n" +
                    "   ##   ####   ##\n" +
                    "    ###      ###\n" +
                    "     ##########\n" +
                    "      ######## \n",

            "\n"+
                    "        ########\n" +
                    "       ##########\n" +
                    "      ###      ###\n" +
                    "     ##   ####   ##\n" +
                    "     ##   #  #   ##\n" +
                    "     ##   ####   ##\n" +
                    "     ##   #  #   ##\n" +
                    "     ##   ####   ##\n" +
                    "      ###      ###\n" +
                    "       ##########\n" +
                    "        ######## \n",

            "\n"
    };

    static String[] rebootMessages ={"Disconnecting from spiritual channels...",
    "Shutting down systems...",
    "Booting Seance-98...",
    "Interpreting astrological alignments...",
    "Implementing Tarot compiler...",
    "Coalescing Geist entities...",
    "Exorcising evil spirits...",
    "Generating auras...",
    "Initializing phonological interpreter...",
    "Unzipping cold-reading techniques library...",
    "Load complete"
    };

    static String[] deflectionStatements={"But is that the question we should be asking ourselves?",
            "Well before I address that question, we must understand the nature of the question",
            "Truth be told, I'm not prepared for that question and I can't answer it. Let's move on."
    };



    static boolean initial= true;

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
        giveReply(indexNum);
        askUser();

    }
    public static void delay(int time){
        try {
            Thread.sleep(750);
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (time>=1){
            System.out.println(delayFillers[time-1]);
            delay(time-1);
        }else {animate();}
    }


    public static void animate(){
        int oscillations = 3;
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
        System.out.println("Think of your question and I will telepathically retrieve it.");
        try {
            Thread.sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        delay(5);
        switch(indexNum){
            case 0:
                System.out.println(ANSI_RED+replies[indexNum]+"\n"+ANSI_RESET);
                reboot();
                break;
            case 1:
                System.out.println(ANSI_PURPLE+replies[indexNum]+"\n"+ANSI_RESET);
                break;
            case 2:
                System.out.println(ANSI_PURPLE+replies[indexNum]+"\n"+ANSI_RESET);
                break;
            case 3:
                System.out.println(ANSI_PURPLE+replies[indexNum]+"\n"+ANSI_RESET);
                break;
            case 4:
                System.out.println(ANSI_YELLOW+replies[indexNum]+"\n"+ANSI_RESET);
                break;
            case 5:
                System.out.println(ANSI_PURPLE+replies[indexNum]+"\n"+ANSI_RESET);
                break;
            case 6:
                System.out.println(ANSI_RED+replies[indexNum]+"\n"+ANSI_RESET);
                askWebMD();
                break;
            case 7:
                System.out.println(ANSI_RED+replies[indexNum]+"\n"+ANSI_RESET);
                claimYourPrize();
                break;
            case 8:
                System.out.println(ANSI_RED+replies[indexNum]+"\n"+ANSI_RESET);
                pressForAnswers();
                break;
        }


    }

    public static int getRandomNumber(){return randomGen.nextInt(9);}

    public static String getReply(String prompt){
        System.out.println(prompt + " :");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void reboot(){
        String ans = getReply(secondaryMessages[0]);
        if (ans.equals("yes")||ans.equals("y")){
            for (int i = 0; i < rebootMessages.length; i++) {
                System.out.print(rebootMessages[i]);
                try {
                    Thread.sleep(400);
                    System.out.print(".");
                    Thread.sleep(300);
                    System.out.print(".\n");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }else if(ans.equals("no")||ans.equals("n")){
            System.out.println(ANSI_PURPLE+"Resuming without reboot."+ANSI_RESET);
        } else{
            System.out.println("That wasn't a valid entry.");
        }
        initial=true;
    }

    public static void askWebMD(){
        String ans =getReply(secondaryMessages[1]);
        if (ans.equals("y")||ans.equals("yes")){
            System.out.println(ANSI_YELLOW+"Okay well, I typed your symptoms into this browser thingy here\nand it says you could have \"Network connectivity problems\"\n"+ANSI_RESET);
        }else if (ans.equals("n")||ans.equals("no")){
            System.out.println(ANSI_YELLOW+"WebMD probably would have blown it out of proportion anyway."+ANSI_RESET);
        }else {
            System.out.println("That wasn't a valid entry.");
        }
    }
    public static void claimYourPrize(){
        String ans = getReply(ANSI_BLUE+secondaryMessages[2]+ANSI_RESET);
        if (ans.equals("y")||ans.equals("yes")){
            getReply(ANSI_BLUE+"GR8! YOUVE ERNED $750 DOLLARS FROM GIECO ADS. YOU CAN CLAIM THIS CASH MOENY NOW.\nBUT YOU HAVE TO ACT QUICK!!!! (y/n)"+ANSI_RESET);
            System.out.println(ANSI_BLUE+"\nPREFECT! JUST VERIFY IDENTIY BY SEND YOUR SOCIAL SECUTIRY NUMBER WITH YOUR MOTHERS MAIDEN NAME & YOUR D.O.B TO \"ethiopianPrince@noscammy.com\"\nAND YOU GET MONEY IN MAIL 3 DAYS!!!!!\n"+ANSI_RESET);
            try {
                Thread.sleep(3000);
                System.out.println(ANSI_RED+"Malicious software detected. Reboot recommended.\n"+ANSI_RESET);
                reboot();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else if (ans.equals("n")||ans.equals("no")){
            System.out.println();
        }else {
            System.out.println("That wasn't a valid entry.");
        }
    }
    public static void pressForAnswers(){
        String ans =getReply(ANSI_RED+secondaryMessages[3]+ANSI_RESET);
        if(ans.equals("y")||ans.equals("yes")){
            System.out.println("You try to get the 8-ball to divulge more info.");
            for (int i = 0; i < deflectionStatements.length; i++) {
                if(i==deflectionStatements.length-1){
                    ans= getReply(ANSI_RED+deflectionStatements[i]+ANSI_RESET);
                }else{
                    ans= getReply(ANSI_RED+deflectionStatements[i]+"(Push further?(y/n))"+ANSI_RESET);
                }
                if(ans.equals("y")||ans.equals("yes")){
                    if(i!=deflectionStatements.length-1){
                        System.out.println("You try to get the 8-ball to divulge more info.");
                    }

                }else if (ans.equals("n")||ans.equals("no")){
                    System.out.println("You stop the line of questioning.");
                    break;
                }else{
                    System.out.println("That wasn't a valid entry.");
                    i--;
                }

            }
        }

    }
}