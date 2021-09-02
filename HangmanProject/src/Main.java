import java.lang.reflect.Array;
import java.util.Scanner;
import java.util.ArrayList;

public class Main
{
    public static void drawHangman(int strikes)
    {
        if(strikes == 0)
        {
            System.out.println(" +---+");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 1)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("     |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 2)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println(" |   |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 3)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|   |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 4)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("     |");
            System.out.println("    === ");
        }
        else if(strikes == 5)
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("/    |");
            System.out.println("    === ");
        }
        else
        {
            System.out.println(" +---+");
            System.out.println(" O   |");
            System.out.println("/|\\  |");
            System.out.println("/ \\  |");
            System.out.println("    === ");
        }
    }

    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);

        boolean isOn = true;
        boolean isPlaying = true;
        String missedLetters = "";

        String guessString;
        char guess;
        String answerWord = "cat";
        char[] progress = new char[answerWord.length()];
        char[] answer = new char[answerWord.length()];
        for(int i = 0; i < answerWord.length(); i++)
        {
            answer[i] = answerWord.charAt(i);
        }

        while(isOn)
        {
            System.out.println("H A N G M A N");
            for(int i = 0; i < progress.length; i++)
            {
                progress[i] = '_';
            }

            while(missedLetters.length() < 6 && isPlaying)
            {
                drawHangman(missedLetters.length());
                System.out.println("Missed letters: " + missedLetters);
                System.out.println(progress);
                System.out.println("Guess a letter");
                guessString = scan.nextLine();
                guessString.toLowerCase();
                guess = guessString.charAt(0);

                while(missedLetters.indexOf(guess) != -1 ||
                        (answerWord.indexOf(guess) != -1 && progress[answerWord.indexOf(guess)] != '_'))
                {
                    System.out.println("You have already guessed that letter. Choose again");
                    guessString = scan.nextLine();
                    guessString.toLowerCase();
                    guess = guessString.charAt(0);
                }

                if(answerWord.indexOf(guess) == -1)
                {
                    missedLetters += guess;
                }
                else
                {
                    for(int i = 0; i < answer.length; i++)
                    {
                        if(answer[i] == guess)
                        {
                            progress[i] = guess;
                        }
                    }
                    isPlaying = false;
                    for(char c: progress)
                    {
                        if(c == '_')
                        {
                            isPlaying = true;
                        }
                    }
                }
            }

            if(isPlaying)
            {
                drawHangman(missedLetters.length());
                System.out.println("Too bad! The secret word is " + answerWord + ". You have lost.");
            }
            else
            {
                System.out.println("Yes! The secret word is " + answerWord + "! You have won!");
            }

            System.out.println("Do you want to play again? (yes or no)");
            String input = scan.nextLine();
            input.toLowerCase();
            if(input.equals("no"))
            {
                isOn = false;
            }
            else if(input.equals("yes"))
            {
                missedLetters = "";
                isPlaying = true;
            }
        }
    }
}
