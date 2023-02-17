import java.util.Locale;
import java.util.Scanner;

public class Main
{
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

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;

        clearBoard();

        while(isOn)
        {
            System.out.println("Welcome to Tic-Tac-Toe!");
            System.out.println("Do you want to be X or O?");
            String playerString = scan.nextLine();
            playerString = playerString.toUpperCase();
            player = playerString.charAt(0);

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
                int input = scan.nextInt();
                input--;
                while(occupiedSpaces[input])
                {
                    System.out.println("That space is taken. Please pick another one");
                    input = scan.nextInt();
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
            String input = scan.next();
            input = input.toLowerCase();
            if(input.equals("no"))
            {
                isOn = false;
            }
            else if(input.equals("yes"))
            {
                clearBoard();
                isPlaying = true;
                numberOfPlayerMoves = 0;
            }
        }
    }
}
