import java.util.Locale;
import java.util.Scanner;

public class Main
{
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

    public static void main(String[] args)
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
                input = scan.nextLine();
                human.move(input.toLowerCase());
                board[human.getYLocation()][human.getXLocation()].toggleContainsHuman();
            }
        }
    }
}
