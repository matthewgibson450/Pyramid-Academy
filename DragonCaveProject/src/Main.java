import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("You are in a land full of dragons. In front of you,\n" +
                "\n" +
                "you see two caves. In one cave, the dragon is friendly\n" +
                "\n" +
                "and will share his treasure with you. The other dragon\n" +
                "\n" +
                "is greedy and hungry and will eat you on sight.\n" +
                "\n" +
                "Which cave will you go into? (1 or 2)\n");

        int input = scan.nextInt();

        System.out.println("\nYou approach the cave...\n" +
                "\n" +
                "It is dark and spooky...\n" +
                "\n" +
                "A large dragon jumps out in front of you! He opens his jaws and...\n");

        if(input == 1)
        {
            System.out.println("Gobbles you down in one bite!");
        }

        if(input == 2)
        {
            System.out.println("Says there's enough treasure for two!");
        }
    }
}
