public class Main {

    public static void main(String[] args)
    {
        boolean isPlayerOnesTurn = true;

        Board playerOne = new Board();
        Board playerTwo = new Board();

        while(!playerOne.hasWon() && !playerTwo.hasWon())
        {
            if(isPlayerOnesTurn)
            {
                System.out.println("Player One's Turn:");
                playerOne.takeShot(playerTwo);
            }
            else
            {
                System.out.println("Player Two's Turn:");
                playerTwo.takeShot(playerOne);
            }
            isPlayerOnesTurn = !isPlayerOnesTurn;
        }
        System.out.println("Game Over");
        if(isPlayerOnesTurn)
        {
            System.out.println("Player Two Wins!");
        }
        else
        {
            System.out.println("Player One Wins!");
        }
    }
}
