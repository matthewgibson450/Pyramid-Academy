import java.util.Scanner;

public class Main
{
    public static void DragonCave()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into? (1 or 2)\n");

        int input;
        try
        {
            input = scan.nextInt();
        }
        catch(Exception e)
        {
            System.out.println("Input error: line 26\nInput will be set to 1");
            input = 1;
        }

        System.out.println("\nYou approach the cave...\n" +
                "\n" +
                "It is dark and spooky...\n" +
                "\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n");

        if(input == 1)
        {
            System.out.println("Gobbles you down in one bite!");
        }

        if(input == 2)
        {
            System.out.println("Says there's enough treasure for two!");
        }
    }

    public static void GuessTheNumber()
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;
        String name = "";
        int number;
        int tries = 0;
        boolean isPlaying = true;

        while(isOn)
        {
            System.out.println("Hello! What is your name?");
            try
            {
                name = scan.next();
            }
            catch(Exception e)
            {
                System.out.println("Input error: line 66");
                name = "Matt";
            }

            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            number = (int)(Math.random() * (20) + 1);

            while(tries < 6 && isPlaying)
            {
                System.out.println("Take a guess.");
                int guess;
                try
                {
                    guess = scan.nextInt();
                }
                catch(Exception e)
                {
                    System.out.println("Input error: line 83");
                    guess = -1;
                }

                if(guess > number)
                {
                    System.out.println("Your guess is too high.");
                    tries++;
                }
                else if(guess < number)
                {
                    System.out.println("Your guess is too low.");
                    tries++;
                }
                else if(guess == number)
                {
                    System.out.print("Good job, " + name + "! ");
                    tries++;
                    isPlaying = false;
                }
            }

            if(isPlaying)
            {
                System.out.println("Too bad, " + name + "!");
            }
            else
            {
                System.out.println("You guessed my number in " + tries + " guesses!");
            }


            System.out.println("Would you like to play again? (y or n)");
            scan.nextLine();
            String input;
            try
            {
                input = scan.nextLine().toLowerCase();
            }
            catch(Exception e)
            {
                System.out.println("Input error: line 124");
                input = "n";
            }
            if(input.equals("y"))
            {
                tries = 0;
                isPlaying = true;
            }
            else
            {
                isOn = false;
            }

        }
    }

    public static void drawHangman(int strikes)
    {
        if(strikes == 0)
        {
            System.out.println(" +---+");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 1)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 2)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println(" |   |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 3)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|   |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 4)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 5)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("/    |");
            System.out.println("    === ");
        }
        else
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("/ \\  |");
            System.out.println("    === ");
        }
    }

    public static void Hangman()
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;
        boolean isPlaying = true;
        String missedLetters = "";

        String guessString;
        char guess;
        String answerWord = "cat";
        char[] progress = new char[answerWord.length()];
        char[] answer = new char[answerWord.length()];
        for(int i = 0; i < answerWord.length(); i++)
        {
            answer[i] = answerWord.charAt(i);
        }

        while(isOn)
        {
            System.out.println("H A N G M A N");
            for(int i = 0; i < progress.length; i++)
            {
                progress[i] = '_';
            }

            while(missedLetters.length() < 6 && isPlaying)
            {
                drawHangman(missedLetters.length());
                System.out.println("Missed letters: " + missedLetters);
                System.out.println(progress);
                System.out.println("Guess a letter");
                try
                {
                    guessString = scan.nextLine().toLowerCase();
                    guess = guessString.charAt(0);
                }
                catch(Exception e)
                {
                    System.out.println("Input error: line 239");
                    guess = 'e';
                }

                while(missedLetters.indexOf(guess) != -1 ||
                        (answerWord.indexOf(guess) != -1 && progress[answerWord.indexOf(guess)] != '_'))
                {
                    System.out.println("You have already guessed that letter. Choose again");
                    try
                    {
                        guessString = scan.nextLine().toLowerCase();
                        guess = guessString.charAt(0);
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error: line 254");
                        guess = 'e';
                    }
                }

                if(answerWord.indexOf(guess) == -1)
                {
                    missedLetters += guess;
                }
                else
                {
                    for(int i = 0; i < answer.length; i++)
                    {
                        if(answer[i] == guess)
                        {
                            progress[i] = guess;
                        }
                    }
                    isPlaying = false;
                    for(char c: progress)
                    {
                        if(c == '_')
                        {
                            isPlaying = true;
                        }
                    }
                }
            }

            if(isPlaying)
            {
                drawHangman(missedLetters.length());
                System.out.println("Too bad! The secret word is " + answerWord + ". You have lost.");
            }
            else
            {
                System.out.println("Yes! The secret word is " + answerWord + "! You have won!");
            }

            System.out.println("Do you want to play again? (yes or no)");
            String input;
            try
            {
                input = scan.nextLine().toLowerCase();
            }
            catch(Exception e)
            {
                System.out.println("Input error: line 301");
                input = "no";
            }
            if(input.equals("yes"))
            {
                missedLetters = "";
                isPlaying = true;
            }
            else
            {
                isOn = false;
            }
        }
    }

    static char player;
    static char computer;
    static boolean[] occupiedSpaces = new boolean[9];
    static boolean[] playerSpaces = new boolean[9];
    static boolean[] computerSpaces = new boolean[9];
    static boolean isPlaying = true;
    static int numberOfPlayerMoves = 0;

    public static void clearBoard()
    {
        for(int i = 0; i < 9; i++)
        {
            occupiedSpaces[i] = false;
            playerSpaces[i] = false;
            computerSpaces[i] = false;
        }
    }

    public static void computerMove()
    {
        String slots = "";

        for(int i = 0; i < occupiedSpaces.length; i++)
        {
            if(!occupiedSpaces[i])
            {
                slots += i + "";
            }
        }

        int random = (int)(Math.random() * slots.length());

        int i = Integer.valueOf(slots.substring(random, random + 1));

        occupiedSpaces[i] = true;
        computerSpaces[i] = true;
    }

    public static void displayBoard()
    {
        char[] board = new char[9];
        for(int i = 0; i < 9; i++)
        {
            if(playerSpaces[i])
            {
                board[i] = player;
            }
            else if(computerSpaces[i])
            {
                board[i] = computer;
            }
            else
            {
                board[i] = ' ';
            }
        }
        System.out.println(" " + board[0] + " | " + board[1] + " | " + board[2] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[3] + " | " + board[4] + " | " + board[5] + " ");
        System.out.println("-----------");
        System.out.println(" " + board[6] + " | " + board[7] + " | " + board[8] + " ");
    }

    public static boolean checkForWin(boolean[] spaces)
    {
        if(spaces[0] && spaces[1] && spaces[2])
        {
            return true;
        }
        else if(spaces[3] && spaces[4] && spaces[5])
        {
            return true;
        }
        else if(spaces[6] && spaces[7] && spaces[8])
        {
            return true;
        }
        else if(spaces[0] && spaces[3] && spaces[6])
        {
            return true;
        }
        else if(spaces[1] && spaces[4] && spaces[7])
        {
            return true;
        }
        else if(spaces[2] && spaces[5] && spaces[8])
        {
            return true;
        }
        else if(spaces[0] && spaces[4] && spaces[8])
        {
            return true;
        }
        else if(spaces[6] && spaces[4] && spaces[2])
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public static void NoughtsAndCrosses()
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;

        clearBoard();

        while(isOn)
        {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Do you want to be X or O?");
            String playerString;
            try
            {
                playerString = scan.nextLine().toUpperCase();
                player = playerString.charAt(0);
            }
            catch(Exception e)
            {
                System.out.println("Input error: line 439");
                playerString = "X";
                player = playerString.charAt(0);
            }

            if(player == 'X')
            {
                computer = 'O';
            }
            else
            {
                computer = 'X';
            }

            System.out.println("The computer will go first");

            computerMove();
            displayBoard();

            while(isPlaying)
            {
                System.out.println("What is your next move?");
                int input;
                try
                {
                    input = scan.nextInt();
                    input--;
                }
                catch(Exception e)
                {
                    System.out.println("Input error: line 469");
                    input = 6;
                }
                while(occupiedSpaces[input])
                {
                    System.out.println("That space is taken. Please pick another one");
                    try
                    {
                        input = scan.nextInt();
                        input--;
                    }
                    catch(Exception e)
                    {
                        System.out.println("Input error: line 482");
                        input = 6;
                    }
                }
                occupiedSpaces[input] = true;
                playerSpaces[input] = true;
                numberOfPlayerMoves++;
                displayBoard();
                boolean playerResult = checkForWin(playerSpaces);
                if(playerResult)
                {
                    isPlaying = false;
                    System.out.println("You Win");
                }
                else
                {
                    System.out.println("The computer will now move again");
                    computerMove();
                    displayBoard();
                    boolean computerResult = checkForWin(computerSpaces);
                    if(computerResult)
                    {
                        isPlaying = false;
                        System.out.println("You Lose");
                    }
                    else if(numberOfPlayerMoves >= 4)
                    {
                        isPlaying = false;
                        System.out.println("It's a draw");
                    }
                }
            }

            System.out.println("Do you want to play again? (yes or no)");
            String input;
            try
            {
                input = scan.next().toLowerCase();
            }
            catch(Exception e)
            {
                System.out.println("Input error: line 523");
                input = "no";
            }
            if(input.equals("yes"))
            {
                clearBoard();
                isPlaying = true;
                numberOfPlayerMoves = 0;
            }
            else
            {
                isOn = false;
            }
        }
    }

    public static void displayBoard(Land[][] board)
    {
        for(int y = 0; y < board.length; y++)
        {
            for(int x = 0; x < board[y].length; x++)
            {
                if(x == 0)
                {
                    System.out.print(" ");
                }
                else
                {
                    System.out.print(" | ");
                }
                System.out.print(board[y][x].toString());
            }
            System.out.println(" ");
            if(y < board.length - 1)
            {
                System.out.println("---------------------------------------");
            }
        }
    }

    public static void HumansVsGoblins()
    {
        Scanner scan = new Scanner(System.in);

        String input = "";
        Land[][] board = new Land[10][10];
        for(int i = 0 ; i < board.length; i++)
        {
            for(int j = 0; j < board[i].length; j++)
            {
                board[i][j] = new Land();
            }
        }
        Human human = new Human();
        board[human.getYLocation()][human.getXLocation()].toggleContainsHuman();
        Goblin goblin = new Goblin();
        board[goblin.getYLocation()][goblin.getXLocation()].toggleContainsGoblin();

        while(!input.equals("quit"))
        {
            board[goblin.getYLocation()][goblin.getXLocation()].toggleContainsGoblin();
            goblin.pursue(human);
            board[goblin.getYLocation()][goblin.getXLocation()].toggleContainsGoblin();

            displayBoard(board);

            if(board[human.getYLocation()][human.getXLocation()].containsBoth())
            {
                System.out.println("You have encountered a goblin!");
                int outcome = (int)(Math.random() * 10);
                if(outcome == 0)
                {
                    System.out.println("You were defeated by the goblin.");
                    input = "quit";
                }
                else
                {
                    System.out.println("You defeated the goblin!");
                    board[goblin.getYLocation()][goblin.getXLocation()].toggleContainsGoblin();
                    input = "quit";
                }

            }
            else
            {
                board[human.getYLocation()][human.getXLocation()].toggleContainsHuman();
                System.out.println("Which direction would you like to move in? (or enter \"quit\" to quit)");
                try
                {
                    input = scan.nextLine();
                }
                catch(Exception e)
                {
                    System.out.println("Input error: line 616");
                    input = "quit";
                }
                human.move(input.toLowerCase());
                board[human.getYLocation()][human.getXLocation()].toggleContainsHuman();
            }
        }
    }

    public static void main(String[] args)
    {
        DragonCave();
        GuessTheNumber();
        Hangman();
        NoughtsAndCrosses();
        HumansVsGoblins();
    }
}
