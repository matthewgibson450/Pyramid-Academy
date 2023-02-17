import java.util.Scanner;

public class Board
{
    Scanner scan = new Scanner(System.in);

    private char[][] shotsTaken = new char[9][9];
    private char[][] myBoard = new char[9][9];
    private int numHits;
    private Carrier carrier;
    private Battleship battleship;
    private Destroyer destroyer;
    private Submarine submarine;
    private PatrolBoat patrolBoat;

    public Board()
    {
        for(int i = 0 ; i < shotsTaken.length; i++)
        {
            for(int j = 0; j < shotsTaken[i].length; j++)
            {
                shotsTaken[i][j] = '~';
                myBoard[i][j] = '~';
            }
        }
        numHits = 0;
        System.out.println("Setting up new board");
        carrier = new Carrier();
        setShip(carrier);
        battleship = new Battleship();
        setShip(battleship);
        destroyer = new Destroyer();
        setShip(destroyer);
        submarine = new Submarine();
        setShip(submarine);
        patrolBoat = new PatrolBoat();
        setShip(patrolBoat);
        System.out.println("Final board positions:");
        this.displayBoard();
    }

    public void setMyBoard(int x, int y, char valueIn)
    {
        myBoard[y][x] = valueIn;
    }

    public char getMyBoard(int x, int y)
    {
        return myBoard[y][x];
    }

    public void setShip(Ship ship)
    {
        this.displayBoard();
        int xLimit = 8;
        int yLimit = 8;
        System.out.println("Placing " + ship.toString());
        System.out.println("Would you like to place horizontally or vertically? (h or v)");
        String input = scan.next();
        char inputChar = input.toLowerCase().charAt(0);
        if(inputChar == 'h')
        {
            ship.setIsHorizontal(true);
            xLimit -= ship.getSize() - 1;
        }
        else if(inputChar == 'v')
        {
            ship.setIsHorizontal(false);
            yLimit -= ship.getSize() - 1;
        }
        else
        {
            System.out.println("Orientation Error");
        }
        System.out.println("Please enter x coordinate between 0 and " + xLimit);
        int coordinate = scan.nextInt();
        ship.setXLocation(coordinate);

        System.out.println("Please enter y coordinate between 0 and " + yLimit);
        coordinate = scan.nextInt();
        ship.setYLocation(coordinate);

        if(ship.getIsHorizontal())
        {
            for(int i = ship.getXLocation(); i < ship.getSize() + ship.getXLocation(); i++)
            {
                myBoard[ship.getYLocation()][i] = ship.toString().charAt(0);
            }
        }
        else
        {
            for(int i = ship.getYLocation(); i < ship.getSize() + ship.getYLocation(); i++)
            {
                myBoard[i][ship.getXLocation()] = ship.toString().charAt(0);
            }
        }
    }

    public void takeShot(Board targetBoard)
    {
        System.out.println("Shot display:");
        this.displayShots();

        System.out.println("Please enter target x coordinate");
        int targetX = scan.nextInt();

        System.out.println("Please enter target y coordinate");
        int targetY = scan.nextInt();

        if(targetBoard.getMyBoard(targetX, targetY) != '~')
        {
            System.out.println("Hit!");
            numHits++;
            shotsTaken[targetY][targetX] = 'x';
        }
        else
        {
            System.out.println("Miss");
            shotsTaken[targetY][targetX] = 'm';
        }
    }

    public boolean hasWon()
    {
        return !(numHits < 17);
    }

    public void displayBoard()
    {
        System.out.println("  012345678");
        for(int y = 0; y < myBoard.length; y++)
        {
            for(int x = 0; x < myBoard[y].length; x++)
            {
                if(x == 0)
                {
                    System.out.print(y + " ");
                }
                System.out.print(myBoard[y][x]);
            }
            System.out.println();
        }
    }

    public void displayShots()
    {
        System.out.println("  012345678");
        for(int y = 0; y < shotsTaken.length; y++)
        {
            for(int x = 0; x < shotsTaken[y].length; x++)
            {
                if(x == 0)
                {
                    System.out.print(y + " ");
                }
                System.out.print(shotsTaken[y][x]);
            }
            System.out.println();
        }
    }
}
