public class Battleship extends Ship
{
    public Battleship()
    {
        setSize(4);
    }

    public Battleship(int xLocationIn, int yLocationIn, boolean isHorizontalIn)
    {
        setXLocation(xLocationIn);
        setYLocation(yLocationIn);
        setIsHorizontal(isHorizontalIn);
        setSize(4);
    }

    public String toString()
    {
        return "battleship";
    }
}
