public class Carrier extends Ship
{
    public Carrier()
    {
        setSize(5);
    }

    public Carrier(int xLocationIn, int yLocationIn, boolean isHorizontalIn)
    {
        setXLocation(xLocationIn);
        setYLocation(yLocationIn);
        setIsHorizontal(isHorizontalIn);
        setSize(5);
    }

    public String toString()
    {
        return "carrier";
    }
}
