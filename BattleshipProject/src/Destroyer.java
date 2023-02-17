public class Destroyer extends Ship
{
    public Destroyer()
    {
        setSize(3);
    }

    public Destroyer(int xLocationIn, int yLocationIn, boolean isHorizontalIn)
    {
        setXLocation(xLocationIn);
        setYLocation(yLocationIn);
        setIsHorizontal(isHorizontalIn);
        setSize(3);
    }

    public String toString()
    {
        return "destroyer";
    }
}
