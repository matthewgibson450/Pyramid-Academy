public abstract class Ship
{
    private int xLocation;
    private int yLocation;
    private boolean isHorizontal;
    private int size;

    public int getXLocation()
    {
        return xLocation;
    }

    public void setXLocation(int xLocationIn)
    {
        xLocation = xLocationIn;
    }

    public int getYLocation()
    {
        return yLocation;
    }

    public void setYLocation(int yLocationIn)
    {
        yLocation = yLocationIn;
    }

    public boolean getIsHorizontal()
    {
        return isHorizontal;
    }

    public void toggleIsHorizontal()
    {
        isHorizontal = !isHorizontal;
    }

    public void setIsHorizontal(boolean isHorizontalIn)
    {
        isHorizontal = isHorizontalIn;
    }

    public int getSize()
    {
        return size;
    }

    public void setSize(int sizeIn)
    {
        size = sizeIn;
    }
}
