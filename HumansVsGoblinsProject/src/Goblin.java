public class Goblin
{
    private int xLocation;
    private int yLocation;
    private boolean isAlive;

    public Goblin()
    {
        xLocation = (int)(Math.random() * 10);
        yLocation = (int)(Math.random() * 10);
        isAlive = true;
    }

    public Goblin(int xLocationIn, int yLocationIn)
    {
        xLocation = xLocationIn;
        yLocation = yLocationIn;
        isAlive = true;
    }

    public int getXLocation()
    {
        return xLocation;
    }

    public int getYLocation()
    {
        return yLocation;
    }

    public void setXLocation(int xLocationIn)
    {
        xLocation = xLocationIn;
    }

    public void setYLocation(int yLocationIn)
    {
        yLocation = yLocationIn;
    }

    public boolean getIsAlive()
    {
        return isAlive;
    }

    public void toggleIsAlive()
    {
        isAlive = !isAlive;
    }

    public void pursue(Human target)
    {
        if(target.getXLocation() > xLocation)
        {
            xLocation++;
        }
        else if(target.getXLocation() < xLocation)
        {
            xLocation--;
        }

        if(target.getYLocation() > yLocation)
        {
            yLocation++;
        }
        else if(target.getYLocation() < yLocation)
        {
            yLocation--;
        }
    }

    public String toString()
    {
        String returnString = "Goblin located at (" + xLocation + ", " + yLocation + ") is ";
        if(!isAlive)
        {
            returnString += "not ";
        }
        return returnString + "alive.";
    }
}
