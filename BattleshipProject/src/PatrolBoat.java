public class PatrolBoat extends Ship
{
    public PatrolBoat()
    {
        setSize(2);
    }

    public PatrolBoat(int xLocationIn, int yLocationIn, boolean isHorizontalIn)
    {
        setXLocation(xLocationIn);
        setYLocation(yLocationIn);
        setIsHorizontal(isHorizontalIn);
        setSize(2);
    }

    public String toString()
    {
        return "patrol boat";
    }
}
