public class Submarine extends Ship
{
    public Submarine()
    {
        setSize(3);
    }

    public Submarine(int xLocationIn, int yLocationIn, boolean isHorizontalIn)
    {
        setXLocation(xLocationIn);
        setYLocation(yLocationIn);
        setIsHorizontal(isHorizontalIn);
        setSize(3);
    }

    public String toString()
    {
        return "submarine";
    }
}
