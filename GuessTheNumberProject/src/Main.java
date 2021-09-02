import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;
        String name;
        int number;
        int tries = 0;
        boolean isPlaying = true;

        while(isOn)
        {
            System.out.println("Hello! What is your name?");
            name = scan.next();

            System.out.println("Well, " + name + ", I am thinking of a number between 1 and 20.");
            number = (int)(Math.random() * (20) + 1);

            while(tries < 6 && isPlaying)
            {
                System.out.println("Take a guess.");
                int guess = scan.nextInt();

                if(guess > number)
                {
                    System.out.println("Your guess is too high.");
                    tries++;
                }
                else if(guess < number)
                {
                    System.out.println("Your guess is too low.");
                    tries++;
                }
                else if(guess == number)
                {
                    System.out.print("Good job, " + name + "! ");
                    tries++;
                    isPlaying = false;
                }
            }

            if(isPlaying)
            {
                System.out.println("Too bad, " + name + "!");
            }
            else
            {
                System.out.println("You guessed my number in " + tries + " guesses!");
            }


            System.out.println("Would you like to play again? (y or n)");
            scan.nextLine();
            String input = scan.nextLine();
            input.toLowerCase();
            if(input.equals("n"))
            {
                isOn = false;
            }
            else if(input.equals("y"))
            {
                tries = 0;
                isPlaying = true;
            }
        }
    }
}
